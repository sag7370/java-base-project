package online.bigzhouzhou.design_patterns.behavioral.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * HandlerChain类<br/>
 * date: 2024/8/19 09:20<br/>
 * <br/>
 *
 * @author SAg <br/>
 */
public class HandlerChain {
    // 持有所有Handler
    private List<Handler> handlers = new ArrayList<>();

    public void addHandler(Handler handler)
    {
        this.handlers.add(handler);
    }

    public boolean process(Request request) {
        for (Handler handler : handlers) {
            Boolean r = handler.process(request);
            if (r != null) {
                // 如果返回TRUE或FALSE，处理结束
                System.out.println(request.getName() + " " + (r ? "Approved by " : "Denied by ") + handler.getClass().getSimpleName());
                return r;
            }
        }
        throw new RuntimeException("Could not handle request: " + request);
    }
}
