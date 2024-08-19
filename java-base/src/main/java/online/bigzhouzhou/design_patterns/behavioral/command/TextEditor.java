package online.bigzhouzhou.design_patterns.behavioral.command;

/**
 * TextEditor类<br/>
 * date: 2024/8/19 10:12<br/>
 * <br/>
 *
 * @author SAg <br/>
 */
public class TextEditor {
    private StringBuilder buffer = new StringBuilder();

    public void copy() {
        buffer.append(buffer);
    }
    public void add(String s) {
        buffer.append(s);
    }

    public void delete() {
        if (buffer.length() > 0) {
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }

    public String getState() {
        return buffer.toString();
    }
}
