package online.bigzhouzhou.design_patterns.behavioral.command;

/**
 * Command接口<br/>
 * date: 2024/8/19 10:20<br/>
 * <br/>
 *
 * @author SAg <br/>
 */
public interface Command {
    void execute();

    void undo();
}
