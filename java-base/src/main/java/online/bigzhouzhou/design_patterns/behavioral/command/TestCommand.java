package online.bigzhouzhou.design_patterns.behavioral.command;

/**
 * TestCommand类<br/>
 * date: 2024/8/19 10:15<br/>
 * <br/>
 *
 * @author SAg <br/>
 */
public class TestCommand {
    public static void main(String[] args) {
        // 简单的编辑操作
        //testTextEditor();

        // undo
        Invoker invoker = new Invoker();
        TextEditor editor = new TextEditor();
        AddCommand addCommand = new AddCommand(editor, "Command pattern in text editor.");
        invoker.invoke(addCommand);
        System.out.println(editor.getState());
        DeleteCommand deleteCommand = new DeleteCommand(editor);
        invoker.invoke(deleteCommand);
        System.out.println(editor.getState());
        invoker.undo();
        System.out.println(editor.getState());

    }

    public static void testTextEditor() {
        TextEditor editor = new TextEditor();
        editor.add("Command pattern in text editor.\n");
        editor.delete();
        editor.delete();
        editor.delete();
        System.out.println(editor.getState());
    }

    /**
     * 命令模式：
     * 1. 把命令的创建和执行分离，使得调用者无需关心具体的执行过程
     * 2. 封装`Command`对象，命令模式可以保存已执行的命令，从而支持撤销、重做等操作
     */
}
