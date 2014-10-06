
package GUI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * BASIC FILE CLASS. RUNS FILE UTILITIES.
 * COPYRIGHT (C) 2014 Rolando Moreno. All Rights Reserved.
 *
 * @author Rolando Moreno
 * @version 1.00 08/02/2014
 */
public class BasicFile {

    private File inputFile;
    private File backup;
    private DataInputStream rawDataInput;
    private DataOutputStream rawDataOutput;
    private DataOutputStream finalRawDataOutput;
    private ArrayList<Byte> rawData = new ArrayList<>();

    /**
     * CONSTRUCTOR OF THE CLASS. Allows the user to access the file that is then
     * added to the instance variable.
     */
    public BasicFile() {
        JFileChooser fileOpener = new JFileChooser(Constants.STRING_WITH_DOT_INITIALIZER);
        int status = fileOpener.showOpenDialog(null);

        try {
            if (status != JFileChooser.APPROVE_OPTION) {
                throw new IOException();
            }
            inputFile = fileOpener.getSelectedFile();
            if (!inputFile.exists()) {
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException e) {
            String tempString = Constants.STRING_INITIALIZER;
            tempString = String.format(Constants.FILE_NOT_FOUND, e.toString());
            display(tempString);
        } catch (IOException e) {
            String tempString = Constants.STRING_INITIALIZER;
            tempString = String.format(Constants.NO_SELECTION_MADE, e.toString());
            display(tempString);
        }
    }

    /**
     * THIS METHOD RETURNS THE NAME OF THE FILE.
     *
     * @return Returns a String of the file name.
     */
    public String getName() {
        return inputFile.getName();
    }

    /**
     * THIS METHOD GETS THE CONTENTS OF THE FILE.
     *
     * @return Returns a compiled String of the contents in the file.
     */
    public String getContents() {
        String returnValue = Constants.STRING_INITIALIZER;
        int lineCounter = 0;
        int wordCounter = 0;
        int numberCounter = 0;
        int characterCounter = 0;

        try {
            try (FileReader reader = new FileReader(inputFile)) {
                StreamTokenizer tokenizer = new StreamTokenizer(reader);

                tokenizer.whitespaceChars(Constants.WHITE_SPACE, Constants.WHITE_SPACE);

                tokenizer.eolIsSignificant(true);
                while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                    switch (tokenizer.ttype) {
                        case StreamTokenizer.TT_EOL:
                            lineCounter++;
                            break;
                        case StreamTokenizer.TT_WORD:
                            wordCounter++;
                            characterCounter += tokenizer.sval.length();
                            break;
                        case StreamTokenizer.TT_NUMBER:
                            numberCounter++;
                            String tempString = String.valueOf(tokenizer.nval);
                            characterCounter += tempString.length();
                            break;
                        case StreamTokenizer.TT_EOF:
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BasicFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BasicFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        returnValue = String.format(Constants.FILE_CONTENTS_FORMAT, inputFile.getName(), lineCounter, wordCounter, numberCounter, characterCounter);
        return returnValue;
    }

    /**
     * THIS METHOD DISPLAYS ALL ERROR MESSAGES FOR THIS CLASS.
     *
     * @param errorMessage The String containing the error message.
     * @param errorHeader The String containing the error message header.
     */
    private void display(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, Constants.ERROR_MESSAGE_HEADER, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * THIS METHOD READS DATA FROM A CHOSE FILE AND INSERTS INTO AN ARRAYLIST.
     */
    public void readDataFromFile() {
        try {
            rawDataInput = new DataInputStream(new FileInputStream(inputFile));
        } catch (FileNotFoundException ex) {
            String tempString = Constants.STRING_INITIALIZER;
            tempString = String.format(Constants.FILE_NOT_FOUND, ex.toString());
            Logger.getLogger(BasicFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rawDataInput.available() > 0) {
                rawData.add(rawDataInput.readByte());
            }
            rawDataInput.close();
        } catch (IOException ex) {
            String tempString = Constants.STRING_INITIALIZER;
            tempString = String.format(Constants.READ_ERROR_MESSAGE, ex.toString());
            //display(tempString);
            Logger.getLogger(BasicFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * THIS METHOD BACKUPS UP ANY FILE THAT IS OPENED.
     */
    public void backup() {
        JFileChooser fileSaver = new JFileChooser(Constants.STRING_WITH_DOT_INITIALIZER);
        int status = fileSaver.showSaveDialog(null);
        try {
            if (status != JFileChooser.APPROVE_OPTION) {
                throw new IOException();
            }
            backup = fileSaver.getSelectedFile();
            rawDataOutput = new DataOutputStream(new FileOutputStream(backup));
            for (Byte rawData1 : rawData) {
                rawDataOutput.writeByte(rawData1);
            }
            rawDataOutput.close();
        } catch (IOException e) {
            String tempString = Constants.STRING_INITIALIZER;
            tempString = String.format(Constants.NO_SELECTION_MADE, e.toString());
            display(tempString);
        }
    }
}
