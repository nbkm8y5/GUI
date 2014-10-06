/*
 * THE GUI PACKAGE IS THE MAIN PACKAGE IN THIS PROGRAM.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.HyperlinkEvent;

/**
 * GUIActions Class. Solves COP3337 Assignment 6 COPYRIGHT (C) 2014 Rolando
 * Moreno. All Rights Reserved.
 *
 * @author Rolando Moreno COP 3337
 * @version 1.01 08-02-2014
 */
public class GUIActions implements ActionListener {

    String tempString;
    Display displayMessage;
    DisplayText dt;
    BasicFile file;
    MyGraphics graphics;
    Browser browser;
    MyJFrame frame;
    Browser broswer;
    MyJButton myJButton;

    /**
     *
     * @param myJButton
     */
    public GUIActions(MyJButton myJButton) {
        this.myJButton = myJButton;
    }

    /**
     *
     * @param broswer
     */
    public GUIActions(Browser broswer) {
        this.broswer = broswer;
    }

    /**
     *
     * @param frame
     */
    public GUIActions(MyJFrame frame) {
        this.frame = frame;
    }

    /**
     * This methods displays that an action has been performed.
     *
     * @param event The parameter of the action being performed.
     */
    @Override
    public void actionPerformed(ActionEvent event) {

        switch (event.getActionCommand()) {
            case Constants.NEW:
                dt = new DisplayText("Untitled........", "");
                break;
            case Constants.OPEN:
                file = new BasicFile();
                file.readDataFromFile();
                dt = new DisplayText(file.getName(), file.getContents());
                break;
            case Constants.SAVE:
                /**
                 * NOT WORKING YET.
                 */
                try {
                    file.backup();
                } catch (NullPointerException e) {
                    System.out.println(e.toString());
                }
                break;
            case Constants.CLOSE:
                displayMessage = new Display(Constants.CLOSE_PROMPT, Constants.CLOSE_HEADER);
                displayMessage.getCloseMessage();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                break;
            case Constants.COPY:
                dt.text.copy();
                break;
            case Constants.PASTE:
                dt.text.paste();
                break;
            case Constants.SORT:
                tempString = String.format(Constants.ACTION_PERFORMED_PROMPT, event.getActionCommand());
                displayMessage = new Display(tempString, Constants.ACTION_PERFORMED_HEADER);
                displayMessage.getInformationMessage();
                break;
            case Constants.SEARCH:
                tempString = String.format(Constants.ACTION_PERFORMED_PROMPT, event.getActionCommand());
                displayMessage = new Display(tempString, Constants.ACTION_PERFORMED_HEADER);
                displayMessage.getInformationMessage();
                break;
            case Constants.ABOUT:
                displayMessage = new Display(Constants.ABOUT_GIU_PROGRAM_PROMPT, Constants.ABOUT_HEADER);
                displayMessage.getAboutProgramMessage();
                break;
            case Constants.BROWSER:
                browser = new Browser();
                break;
            case Constants.GRAPHICS:
                graphics = new MyGraphics();
                break;
            default:
                try {
                    broswer.hyperlinkUpdate(new HyperlinkEvent(event.getSource(), HyperlinkEvent.EventType.ACTIVATED, new URL(event.getActionCommand())));
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GUIActions.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
        }
    }
}
