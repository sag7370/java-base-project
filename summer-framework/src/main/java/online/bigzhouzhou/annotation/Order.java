package online.bigzhouzhou.annotation;

import java.lang.annotation.*;

/**
 * Bean的内部排序顺序
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Order {

    int value();

}
