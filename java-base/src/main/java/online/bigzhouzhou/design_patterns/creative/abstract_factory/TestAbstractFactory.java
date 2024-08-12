package online.bigzhouzhou.design_patterns.creative.abstract_factory;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * TestAbstractFoctory类
 * date: 2024/8/12 11:34<br/>
 *
 * @author SAg <br/>
 */
public class TestAbstractFactory {

    public static void main(String[] args) throws IOException {
        // 创建AbstractFactory，实际类型是FastFactory
        AbstractFactory factory = new FastFactory();
        // 生成HTML文档
        HtmlDocument html = factory.createHtml("Hello World!");
        html.save(Paths.get(".", "fast.html"));
        // 生成Word文档
        WordDocument word = factory.createWord("Hello World!");
        word.save(Paths.get(".", "fast.doc"));
    }

    /**
     * 抽象工厂模式：
     * 1. 为了让创建工厂和一组产品与使用分离，并可以随时切换到另一个工厂以及另一组产品
     * 2. 实现的关键点是定义工厂接口和产品接口，如何实现工厂与产品本身需要留给具体的子类实现，
     * 客户端只和抽象工厂与抽象产品打交道
     */
}
