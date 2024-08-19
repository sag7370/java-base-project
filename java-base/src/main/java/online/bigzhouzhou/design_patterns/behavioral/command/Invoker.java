package online.bigzhouzhou.design_patterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Invoker类<br/>
 * date: 2024/8/19 10:34<br/>
 * <br/>
 *
 * @author SAg <br/>
 */
public class Invoker {

    private List<Command> commands = new ArrayList<>();
    public void invoke(Command command)
    {
        commands.add(command);
        command.execute();
    }

    public void undo() {
        Command command = commands.get(commands.size() - 1);
        command.undo();
    }
}
