import online.bigzhouzhou.io.ResourceResolver;

/**
 * TestResoureResolver类
 * date: 2024/8/8 16:45<br/>
 *
 * @author SAg <br/>
 */
public class TestResourceResolver {
    public static void main(String[] args) {
        ResourceResolver resolver = new ResourceResolver("online.bigzhouzhou.resource_resolver");
        resolver.scan(resource -> {
            System.out.println(resource.getName());
            return null;
        });
    }
}
