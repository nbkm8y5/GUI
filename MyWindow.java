/**
 * THE GUI PACKAGE IS THE MAIN PACKAGE IN THIS PROGRAM.
 */
package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * MyWindow Class Program. COPYRIGHT (C) 2014
 * Rolando Moreno. All Rights Reserved.
 *
 * @author Rolando Moreno COP 3337
 * @version 1.01 07-27-2014
 */
public class MyWindow {

    static MyJFrame f = null;
    static MyJButton b = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        f = new MyJFrame(Constants.PROGRAM_HEADER);
        b = new MyJButton(f);
        b.addButtons();
        getFrameProperties();
    }

    /**
     * This method prepares the properties of the frame.
     */
    private static void getFrameProperties() {
        Toolkit tk = f.getToolkit();
        Dimension d = tk.getScreenSize();

        Rectangle r = new Rectangle(Constants.X_POSITION, Constants.Y_POSITION, d.width, d.height);
        f.setBounds(r);

        Container c = f.getContentPane();
        c.setBackground(Color.WHITE);
        c.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

        f.setVisible(true);
        f.setDefaultCloseOperation(MyJFrame.EXIT_ON_CLOSE);
    }
}
