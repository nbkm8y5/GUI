/**
 * THE GUI PACKAGE IS THE MAIN PACKAGE IN THIS PROGRAM.
 */
package GUI;

/**
 * Constants Interface. COPYRIGHT (C) 2014 Rolando
 * Moreno. All Rights Reserved.
 *
 * @author Rolando Moreno COP 3337
 * @version 1.01 07-27-2014
 */
public interface Constants {

    /**
     * MY WINDOW PROGRAM CONSTANTS.
     */
    public static final int INDEX_ZERO = 0;
    public static final int INDEX_ONE = 1;
    public static final int INDEX_TWO = 2;
    public static final int INDEX_THREE = 3;
    public static final int X_POSITION = 0;
    public static final int Y_POSITION = 0;

    public static final String DASH = "-";

    public static final String PROGRAM_HEADER = "MY FIRST JAVA GRAPHICAL USER INTERFACE PROGRAM";
    public static final String[] MENU_ARRAY = {"File", "Tools", "Help"};
    public static final String[] FILE_ARRAY = {"New", "Open", Constants.DASH, "Save", Constants.DASH, "Close"};
    public static final String[] TOOLS_SUB_ARRAY = {"Copy", "Paste"};
    public static final String[] TOOLS_ARRAY = {"Sort", "Search", Constants.DASH};
    public static final String[] HELP_ARRAY = {"About GUI Program"};
    public static final String[] BUTTON = {"Browser", "Graphics"};

    public static final String ERROR_MESSAGE_HEADER = "ERROR";
    public static final String ACTION_PERFORMED_HEADER = "ACTION PERFORMED";
    public static final String CLOSE_HEADER = "WINDOW CLOSING";
    public static final String ABOUT_HEADER = "ABOUT GUI PROGRAM";

    public static final String CLOSE_PROMPT = "The window is closing";

    public static final String ACTION_PERFORMED_PROMPT = "The string is %s.";

    public static final String NEW = "New";
    public static final String OPEN = "Open";
    public static final String SAVE = "Save";
    public static final String CLOSE = "Close";
    public static final String COPY = "Copy";
    public static final String PASTE = "Paste";
    public static final String SORT = "Sort";
    public static final String SEARCH = "Search";
    public static final String ABOUT = "About GUI Program";
    public static final String BROWSER = "Browser";
    public static final String GRAPHICS = "Graphics";

    public static final String HORDE_IMAGE_FILE_PATH = "horde.png";
    public static final String TALENTS_IMAGE_FILE_PATH = "talents.png";
    public static final String JOURNAL_IMAGE_FILE_PATH = "journal.png";
    public static final String RAID_IMAGE_FILE_PATH = "raid.png";
    public static final String HORDE_LOGO_IMAGE_FILE_PATH = "hordeLogoBig.png";
    public static final String HORDE_FRAME_ICON = "hordeFrameIcon.png";

    public static final String ABOUT_GIU_PROGRAM_PROMPT
            = "My Window Class Program.\n"
            + "Solves COP3337 Assignment 6\n"
            + "COPYRIGHT (C) 2014\n"
            + "Rolando Moreno. All Rights Reserved.\n"
            + "Version 1.01 08-01-2014\n";

    /**
     * BASIC FILE CONSTANTS.
     */
    public static final String STRING_INITIALIZER = "";
    public static final String STRING_WITH_DOT_INITIALIZER = ".";
    public static final String NEW_LINE = "\n";
    public static final char WHITE_SPACE = ' ';

    public static final String FILE_NOT_FOUND = "ERROR GENERATED:\n%s\nFILE NOT FOUND. PLEASE TRY AGAIN.";
    public static final String NO_SELECTION_MADE = "ERROR GENERATED:\n%s\nNO OPTION WAS SELECTED. PLEASE TRY AGAIN.";

    public static final String DIRECTORY = "Directory: ";
    public static final String FILE = "File: ";

    public static final String FILE_CONTENTS_FORMAT
            = "FILE %s CONTENTS:\n"
            + "NUMBER OF LINES: %s\n"
            + "NUMBER OF WORDS: %s\n"
            + "NUMBER OF NUMBERS: %s\n"
            + "NUMBER OF CHARACTERS: %s (approximately)\n";

    public static final String SEARCH_QUERY_FORMAT
            = "%d: %s\n%s";

    public static final String READ_ERROR_MESSAGE = "CANNOT READ FROM FILE";

    public static final String BACKUP_PROMPT = "FILE IS OPEN.  PLEASE CHOOSE NEW FILE NAME AND DIRECTORY FOR BACKUP.";
    public static final String SUMMARY_BACKUP_PROMPT = "PLEASE CHOOSE NEW FILE NAME AND DIRECTORY FOR FINAL BACKUP.";

    public static final String BACKUP_HEADER = "FILE OPERATIONS";

    /**
     * MY GRAPHICS CONSTANTS.
     */
    public static final int X_POS = 100;
    public static final int Y_POS = 120;
    public static final int X_FACTOR = 2;
    public static final int Y_FACTOR = 3;
    public static final int X[] = {55, 67, 109, 73, 83, 55, 27, 37, 1, 43};
    public static final int Y[] = {50, 86, 86, 104, 146, 122, 146, 104, 86, 86};
    public static final int XX[] = {100, 20, 20, 180, 180};
    public static final int YY[] = {180, 250, 300, 300, 250};
}
