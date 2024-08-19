package online.bigzhouzhou.design_patterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * DeleteCommand类<br/>
 * date: 2024/8/19 10:46<br/>
 * <br/>
 *
 * @author SAg <br/>
 */
public class DeleteCommand implements Command {
    private TextEditor textEditor;
    private List<Character> characterList = new ArrayList<>();
    public DeleteCommand(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    @Override
    public void execute() {
        characterList.add(textEditor.getState().charAt(textEditor.getState().length() - 1));
        textEditor.delete();
    }

    @Override
    public void undo() {
        if (!characterList.isEmpty()) {
            for (int i = characterList.size() - 1; i >= 0; i--) {
                Character c = characterList.get(i);
                textEditor.add(c.toString());
            }
        }
    }
}
