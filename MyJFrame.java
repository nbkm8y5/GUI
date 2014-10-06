/**
 * THE GUI PACKAGE IS THE MAIN PACKAGE IN THIS PROGRAM.
 */
package GUI;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * MyJFrame Class. COPYRIGHT (C) 2014 Rolando
 * Moreno. All Rights Reserved.
 *
 * @author Rolando Moreno COP 3337
 * @version 1.01 07-27-2014
 */
public class MyJFrame extends JFrame {

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenu subMenu;
    private JMenuItem menuItem;

    /**
     * This is the default constructor of MyJFrame Class.
     *
     * @param frameTitle This is a String parameter being passed into
     * constructor.
     */
    public MyJFrame(String frameTitle) {
        super(frameTitle);
        ImageIcon image = new ImageIcon(Constants.HORDE_FRAME_ICON);
        this.setIconImage(image.getImage());
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        buildMenu();
    }

    /**
     * This method builds the frame menu.
     */
    private void buildMenu() {
        for (int i = 0; i < Constants.MENU_ARRAY.length; i++) {
            menu = new JMenu(Constants.MENU_ARRAY[i]);
            switch (i) {
                case Constants.INDEX_ZERO:
                    menu.setMnemonic(KeyEvent.VK_F);
                    fileChoices();
                    break;
                case Constants.INDEX_ONE:
                    menu.setMnemonic(KeyEvent.VK_T);
                    toolsChoices();
                    toolsSubMenuChoices();
                    break;
                case Constants.INDEX_TWO:
                    menu.setMnemonic(KeyEvent.VK_H);
                    helpChoices();
                    break;
                default:
                    /**
                     * NOTHING HAPPENING AT THE MOMENT.
                     */
                    break;
            }
            menuBar.add(menu);
        }
    }

    /**
     * This method builds the file menu choices.
     */
    private void fileChoices() {
        for (String FILE_ARRAY : Constants.FILE_ARRAY) {
            if (FILE_ARRAY.equals(Constants.DASH)) {
                menu.addSeparator();
            } else {
                menu.add(menuItem = new JMenuItem(FILE_ARRAY, new ImageIcon(Constants.HORDE_IMAGE_FILE_PATH)));
                switch (FILE_ARRAY) {
                    case Constants.NEW:
                        menuItem.setMnemonic(KeyEvent.VK_N);
                        break;
                    case Constants.OPEN:
                        menuItem.setMnemonic(KeyEvent.VK_O);
                        break;
                    case Constants.SAVE:
                        menuItem.setMnemonic(KeyEvent.VK_S);
                        break;
                    default:
                        menuItem.setMnemonic(KeyEvent.VK_C);
                        break;
                }
                menuItem.addActionListener(new GUIActions(this));
            }
        }
    }

    /**
     * This method builds the tools menu choices.
     */
    private void toolsChoices() {
        for (String TOOLS_ARRAY : Constants.TOOLS_ARRAY) {
            if (TOOLS_ARRAY.equals(Constants.DASH)) {
                menu.addSeparator();
            } else {
                menu.add(menuItem = new JMenuItem(TOOLS_ARRAY, new ImageIcon(Constants.TALENTS_IMAGE_FILE_PATH)));
                if (TOOLS_ARRAY.equals(Constants.SORT)) {
                    menuItem.setMnemonic(KeyEvent.VK_S);
                } else {
                    menuItem.setMnemonic(KeyEvent.VK_E);
                }
                menuItem.addActionListener(new GUIActions(this));
            }
        }
    }

    /**
     * This method builds the tools submenu choices.
     */
    private void toolsSubMenuChoices() {
        subMenu = new JMenu(Constants.TOOLS_SUB_ARRAY[1]);
        subMenu.setMnemonic(KeyEvent.VK_P);
        for (String TOOLS_SUB_ARRAY : Constants.TOOLS_SUB_ARRAY) {
            if (TOOLS_SUB_ARRAY.equals(Constants.DASH)) {
                subMenu.addSeparator();
            } else {
                subMenu.add(menuItem = new JMenuItem(TOOLS_SUB_ARRAY, new ImageIcon(Constants.JOURNAL_IMAGE_FILE_PATH)));
                if (TOOLS_SUB_ARRAY.equals(Constants.COPY)) {
                    menuItem.setMnemonic(KeyEvent.VK_C);
                } else {
                    menuItem.setMnemonic(KeyEvent.VK_P);
                }
                menuItem.addActionListener(new GUIActions(this));
            }
        }
        menu.add(subMenu);
    }

    /**
     * This method builds the help menu choices.
     */
    private void helpChoices() {
        for (String HELP_ARRAY : Constants.HELP_ARRAY) {
            if (HELP_ARRAY.equals(Constants.DASH)) {
                menu.addSeparator();
            } else {
                menu.add(menuItem = new JMenuItem(HELP_ARRAY, new ImageIcon(Constants.RAID_IMAGE_FILE_PATH)));
                menuItem.setMnemonic(KeyEvent.VK_A);
                menuItem.addActionListener(new GUIActions(this));
            }
        }
    }
}
