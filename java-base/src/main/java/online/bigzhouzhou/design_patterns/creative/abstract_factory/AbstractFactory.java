package online.bigzhouzhou.design_patterns.creative.abstract_factory;

/**
 * AbstractFactory接口：抽象工厂
 * date: 2024/8/12 11:19<br/>
 * 提供一个Markdown文本转换为HTML和Word的服务
 *
 * @author SAg <br/>
 */
public interface AbstractFactory {
    HtmlDocument createHtml(String md);

    WordDocument createWord(String md);
}
