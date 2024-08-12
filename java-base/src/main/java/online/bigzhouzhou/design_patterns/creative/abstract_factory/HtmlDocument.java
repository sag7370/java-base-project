package online.bigzhouzhou.design_patterns.creative.abstract_factory;

import java.io.IOException;
import java.nio.file.Path;

/**
 * HtmlDocument接口：抽象产品
 * date: 2024/8/12 11:22<br/>
 * Html文档接口
 *
 * @author SAg <br/>
 */
public interface HtmlDocument {

    String toHtml();

    void save(Path path) throws IOException;
}
