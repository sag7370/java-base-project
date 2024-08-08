package online.bigzhouzhou.io;

/**
 * Resource类
 * date: 2024/8/7 09:42<br/>
 *
 * @author SAg <br/>
 */
public class Resource {
    private String path;
    private String name;

    public Resource(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
