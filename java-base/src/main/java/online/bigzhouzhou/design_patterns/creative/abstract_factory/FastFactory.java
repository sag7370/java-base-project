package online.bigzhouzhou.design_patterns.creative.abstract_factory;

/**
 * FastFactory类
 * date: 2024/8/12 11:33<br/>
 *
 * @author SAg <br/>
 */
public class FastFactory implements AbstractFactory{

    @Override
    public HtmlDocument createHtml(String md) {
        return new FastHtmlDocument();
    }

    @Override
    public WordDocument createWord(String md) {
        return new FastWordDocument();
    }
}
