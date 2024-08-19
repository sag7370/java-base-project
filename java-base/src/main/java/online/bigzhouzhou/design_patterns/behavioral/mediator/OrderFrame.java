package online.bigzhouzhou.design_patterns.behavioral.mediator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * OrderFrame类<br/>
 * date: 2024/8/19 22:31<br/>
 * <br/>
 *
 * @author SAg <br/>
 */
public class OrderFrame extends JFrame {
    public OrderFrame(String... names){
        setTitle("Order");
        setSize(460, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));
        c.add(new JLabel("Use Mediator Pattern"));
        java.util.List<JCheckBox> checkBoxList = addCheckBox(names);
        JButton selectAll = addButton("Select All");
        JButton selectNone = addButton("Select None");
        selectNone.setEnabled(false);
        JButton selectInverse = addButton("Inverse Select");
        new Mediator(checkBoxList, selectAll, selectNone, selectInverse);
        setVisible(true);
    }

    private JButton addButton(String label) {
        JButton button = new JButton(label);
        getContentPane().add(button);
        return button;
    }

    private java.util.List<JCheckBox> addCheckBox(String... names) {
        JPanel panel = new JPanel();
        java.util.List<JCheckBox> list = new ArrayList<>();
        for (String name : names) {
            JCheckBox checkBox = new JCheckBox(name);
            list.add(checkBox);
            panel.add(checkBox);
        }
        getContentPane().add(panel);
        return list;
    }
}
