package online.bigzhouzhou.design_patterns.creative.abstract_factory;

import java.io.IOException;
import java.nio.file.Path;

/**
 * FastHtmlDocument类
 * date: 2024/8/12 11:31<br/>
 *
 * @author SAg <br/>
 */
public class FastHtmlDocument implements HtmlDocument{
    @Override
    public String toHtml() {
        return null;
    }

    @Override
    public void save(Path path) throws IOException {

    }
}
