package online.bigzhouzhou.design_patterns.creative.abstract_factory;

import java.io.IOException;
import java.nio.file.Path;

/**
 * WordDocument接口：抽象产品
 * date: 2024/8/12 11:22<br/>
 * Word文档接口
 *
 * @author SAg <br/>
 */
public interface WordDocument {

    void save(Path path) throws IOException;
}
