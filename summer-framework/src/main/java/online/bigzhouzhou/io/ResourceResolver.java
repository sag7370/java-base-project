package online.bigzhouzhou.io;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * ResourceResolver类
 * 定义scan()方法来获取扫描到的Resource,负责扫描并列出所有文件
 * date: 2024/8/7 09:46<br/>
 *
 * @author SAg <br/>
 */
public class ResourceResolver {

    Logger logger = LoggerFactory.getLogger(getClass());

    String basePackage;

    public ResourceResolver(String basePackage) {
        this.basePackage = basePackage;
    }

    public <R> List<R> scan(Function<Resource, R> mapper) {
        // org.example -> org/example
        String basePackagePath = this.basePackage.replace(".", "/");
        String path = basePackagePath;
        try {
            // 文件列表
            List<R> collector = new ArrayList<>();
            scan0(basePackagePath, path, collector, mapper);
            return collector;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    <R> void scan0(String basePackagePath, String path, List<R> collector, Function<Resource, R> mapper) throws IOException, URISyntaxException {
        logger.atDebug().log("scan path: {}", path);
        // 通过ClassLoader获取文件URL列表
        Enumeration<URL> en = getContextClassLoader().getResources(path);
        while (en.hasMoreElements()) {
            URL url = en.nextElement();
            URI uri = url.toURI();
            // 删除最后的  路径分割符
            String uriStr = removeTrailingSlash(uriToString(uri));// file:/Users/ly/Documents/Codes/java-base-project/summer-framework/target/classes/online/bigzhouzhou/resource_resolver
            String uriBaseStr = uriStr.substring(0, uriStr.length() - basePackagePath.length());//file:/Users/ly/Documents/Codes/java-base-project/summer-framework/target/classes/
            if (uriBaseStr.startsWith("file:")) {
                // 在目录中搜索
                uriBaseStr = uriBaseStr.substring(5);///Users/ly/Documents/Codes/java-base-project/summer-framework/target/classes/
            }
            if (uriStr.startsWith("jar:")) {
                // 在Jar包中搜索
                scanFile(true, uriBaseStr, jarUriToPath(basePackagePath, uri), collector, mapper);
            } else {
                scanFile(false, uriBaseStr, Paths.get(uri), collector, mapper);
            }
        }
    }

    ClassLoader getContextClassLoader() {
        ClassLoader cl = null;
        // ClassLoader首先从 Thread.getContextClassLoader() 获取。
        // Web应用的ClassLoader是Servlet容器提供的,在 /WEB-INF/lib/ /WEB-INF/classes 下的jar包中搜索
        cl = Thread.currentThread().getContextClassLoader();
        if (cl == null) {
            // 获取不到从当前class获取
            // JVM提供的的ClassLoader，在默认的Classpath搜索
            cl = getClass().getClassLoader();
        }
        return cl;
    }

    Path jarUriToPath(String basePackagePath, URI jarUri) throws IOException {
        // FileSystems.newFileSystem(URI, Map) 基于给定的URI创建一个 新文件系统
        return FileSystems.newFileSystem(jarUri, Map.of()).getPath(basePackagePath);
    }

    <R> void scanFile(boolean isJar, String base, Path root, List<R> collector, Function<Resource, R> mapper) throws IOException {
        // 处理路径，获得文件夹 ///Users/ly/Documents/Codes/java-base-project/summer-framework/target/classes/ -> /Users/ly/Documents/Codes/java-base-project/summer-framework/target/classes
        String baseDir = removeTrailingSlash(base);
        // 遍历文件  过滤出普通文件
        Files.walk(root).filter(Files::isRegularFile).forEach(file -> {
            Resource res = null;
            if (isJar) {
                // 移除 file 的开头 斜杠
                res = new Resource(baseDir, removeLeadingSlash(file.toString()));
            } else {
                //
                String path = file.toString();
                // 移除baseDir之后的部分
                String name = removeLeadingSlash(path.substring(baseDir.length()));
                // 加上前缀 file: 构建Resource对象
                res = new Resource("file:" + path, name);
            }
            logger.atDebug().log("found resource: {}", res);
            R r = mapper.apply(res);
            if (r != null) {
                collector.add(r);
            }
        });
    }

    String uriToString(URI uri) {
        return URLDecoder.decode(uri.toString(), StandardCharsets.UTF_8);
    }

    /**
     * 删除最前面的 /  路径分隔符 : Windows  \   ;  Linux / macOS  /
     * @param s
     * @return
     */
    String removeLeadingSlash(String s) {
        if (s.startsWith("/") || s.startsWith("\\")) {
            s = s.substring(1);
        }
        return s;
    }

    /**
     * 删除最后边的 /
     * @param s
     * @return
     */
    String removeTrailingSlash(String s) {
        if (s.endsWith("/") || s.endsWith("\\")) {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }
}


