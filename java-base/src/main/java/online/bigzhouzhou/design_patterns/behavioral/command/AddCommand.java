package online.bigzhouzhou.design_patterns.behavioral.command;

/**
 * AddCommand类<br/>
 * date: 2024/8/19 10:44<br/>
 * <br/>
 *
 * @author SAg <br/>
 */
public class AddCommand implements Command{

    private TextEditor textEditor;

    private String addStr;

    public AddCommand(TextEditor textEditor, String addStr) {
        this.textEditor = textEditor;
        this.addStr = addStr;
    }

    @Override
    public void execute() {
        textEditor.add(addStr);
    }

    @Override
    public void undo() {
        textEditor.delete();
    }
}
