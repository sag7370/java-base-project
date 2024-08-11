package online.bigzhouzhou.annotation;

import java.lang.annotation.*;

/**
 * 定义的`@Bean`方法，可以看作Bean的工厂方法，需要回去方法返回值作为Class类型，<br/>
 * 方法本身作为创建Bean的 factoryMethod，<br/>
 * 收集`@Bean`定义的initMethod和destroyMethod标识的初始化与销毁方法
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Bean {

    /**
     * Bean name. default to method name.
     */
    String value() default "";

    String initMethod() default "";

    String destroyMethod() default "";
}
