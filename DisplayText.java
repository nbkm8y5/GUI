/**
 * THE GUI PACKAGE IS THE MAIN PACKAGE IN THIS PROGRAM.
 */
package GUI;

import java.awt.Container;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * DISPLAY TEXT CLASS. COPYRIGHT (C) 2014 Rolando Moreno. All Rights Reserved.
 *
 * @author Rolando Moreno
 * @version 1.00 08/02/2014
 */
public class DisplayText {

    public static JTextArea text;

    /**
     * This is the constructor of the Display Text Class.
     *
     * @param title
     * @param info
     */
    public DisplayText(String title, String info) {
        MyJFrame frame = new MyJFrame(title);
        Container container = frame.getContentPane();

        text = new JTextArea(info);

        JScrollPane scrollPane = new JScrollPane(text);
        container.add(scrollPane);

        frame.setBounds(100, 200, 500, 400);
        frame.setVisible(true);
    }

    /**
     *
     * @return
     */
    public JTextArea getText() {
        return text;
    }

}
