/*
 * THE GUI PACKAGE IS THE MAIN PACKAGE IN THIS PROGRAM.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 * Browser Class
 *
 * @author Rolando Moreno COP 3337
 * @version 1.01 08-02-2014
 */
public class Browser implements HyperlinkListener {

    JEditorPane contents;
    JTextField enter;

    /**
     *
     */
    public Browser() {
        try {
            MyJFrame frame = new MyJFrame("BROWSER");
            Container container = frame.getContentPane();
            enter = new JTextField("http://");
            container.add(enter, BorderLayout.NORTH);
            contents = new JEditorPane();
            contents.setEditable(false);
            contents.setPage("http://users.cis.fiu.edu/~smithjo");
            JScrollPane pane = new JScrollPane(contents);
            container.add(pane, BorderLayout.CENTER);
            frame.setBounds(100, 200, 500, 400);
            frame.setVisible(true);
            enter.addActionListener(new GUIActions(this));
        } catch (IOException ex) {
            Logger.getLogger(Browser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param he
     */
    @Override
    public void hyperlinkUpdate(HyperlinkEvent he) {
        if (he.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            getThePage(he.getURL().toString());
        }
    }

    /**
     *
     * @param location
     */
    private void getThePage(String location) {
        try {
            contents.setPage(location);
            enter.setText(location);
        } catch (IOException io) {
            JOptionPane.showMessageDialog(null, "Error cannot access specified URL", "Bad URL", JOptionPane.ERROR_MESSAGE);
        }
    }
}
