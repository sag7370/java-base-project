package online.bigzhouzhou.annotation;

import java.lang.annotation.*;

/**
 * 定义存在多个相同类型时返回哪个“主要”Bean
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Primary {
}
