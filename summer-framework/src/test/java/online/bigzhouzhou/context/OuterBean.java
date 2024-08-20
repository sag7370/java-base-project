package online.bigzhouzhou.context;


import online.bigzhouzhou.annotation.Component;

@Component
public class OuterBean {

    @Component
    public static class NestedBean {

    }
}
