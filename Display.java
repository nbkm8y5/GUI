/**
 * THE GUI PACKAGE IS THE MAIN PACKAGE IN THIS PROGRAM.
 */
package GUI;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Display Class. COPYRIGHT (C) 2014 Rolando Moreno.
 * All Rights Reserved.
 *
 * @author Rolando Moreno COP 3337
 * @version 1.01 07-27-2014
 */
public class Display {

    private String errorMessage;
    private String informationMessage;
    private String informationHeader;
    private String questionMessage;
    private String questionHeader;
    private int messageType;

    /**
     * This is the constructor for error messages.
     *
     * @param errorMessage The parameter String with the specific error message.
     */
    public Display(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * This is the constructor for information messages.
     *
     * @param informationMessage The parameter String with the specific
     * information message.
     * @param informationHeader The parameter String with the specific
     * information header.
     */
    public Display(String informationMessage, String informationHeader) {
        this.informationMessage = informationMessage;
        this.informationHeader = informationHeader;
    }

    /**
     * This is the constructor for information messages.
     *
     * @param questionMessage The parameter String with the specific question
     * message.
     * @param questionHeader The parameter String with the specific question
     * header.
     * @param messageType The parameter integer with the specific question
     * message type, which also helps in overloading constructors.
     */
    public Display(String questionMessage, String questionHeader, int messageType) {
        this.questionMessage = questionMessage;
        this.questionHeader = questionHeader;
        this.messageType = messageType;
    }

    /**
     * This method displays the error message.
     */
    public void getErrorMessage() {
        JOptionPane.showMessageDialog(null, this.errorMessage, Constants.ERROR_MESSAGE_HEADER, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * This method displays the information message.
     */
    public void getInformationMessage() {
        JTextArea textArea = new JTextArea(this.informationMessage, 20, 40);
        JScrollPane pane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, pane, this.informationHeader, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This is a custom method for About GUI Program selection.
     */
    public void getAboutProgramMessage() {
        ImageIcon image = new ImageIcon(Constants.HORDE_LOGO_IMAGE_FILE_PATH);
        JOptionPane.showMessageDialog(null, this.informationMessage, this.informationHeader, JOptionPane.INFORMATION_MESSAGE, image);
    }

    /**
     * This is a custom method for closing window selection.
     */
    public void getCloseMessage() {
        JOptionPane.showMessageDialog(null, this.informationMessage, this.informationHeader, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method displays the question message and returns a String with the
     * input.
     *
     * @return Returns the String with the user input.
     */
    public String getQuestionMessage() {
        return JOptionPane.showInputDialog(null, questionMessage, questionHeader, messageType);
    }
}
