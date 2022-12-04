package com.Lockedme.constants;

public class LockedmeConstants {
	// Welcome Screen
	public static final String PROJECT_TITLE = "LockedMe.com";
	public static final String PROJECT_SUB_TITLE = "File Management";
	public static final String DEVELOPER_NAME = "Priya Chaskar";
	public static final String VERSION = "1.0.0.0";
	
	// Main Options
	public static final int DISPLAY_FILE_CODE = 1;
	public static final String DISPLAY_FILE_OPTION = "Display file";
	public static final int OPERATE_FILE_CODE = 2;
	public static final String OPERATE_FILE_OPTION = "Operate file";
	public static final int EXIT_CODE = 3;
	public static final String EXIT_OPTION = "Exit";
	
	public static final String[] DISPLAY_OPTIONS = new String[] {
			String.format("%d) %s", LockedmeConstants.DISPLAY_FILE_CODE, LockedmeConstants.DISPLAY_FILE_OPTION),
			String.format("%d) %s", LockedmeConstants.OPERATE_FILE_CODE, LockedmeConstants.OPERATE_FILE_OPTION),
			String.format("%d) %s", LockedmeConstants.EXIT_CODE, LockedmeConstants.EXIT_OPTION) };
	
	// Common
	public static final String NEW_LINE_CHAR = "\n";
	public static final String TAB_CHAR = "\t";
	
	// Messages
	public static final String ENTER_OPTION_CODE = "Enter the choice";
	public static final String EXIT_MESSAGE = "Good bye!";
	public static final String OPERATE_OPTION = "Available options: ";
	public static final String FILENAME = "Enter the filename";
	
	//Success Messages
	public static final String FILE_EXISTED_MESSAGE = "file existed";
	public static final String FILE_NOTEXISTED_MESSAGE = "file does not existed";
	
	//Error Messages
	public static final String DEFAULT_MESSAGE = "Wrong choice, Enter correct option";
	
	//Operation Options
	public static final int ADD_FILE_CODE = 1;
	public static final String ADD_FILE_OPTION = "Add file";
	public static final int DELETE_FILE_CODE = 2;
	public static final String DELETE_FILE_OPTION = "Delete file";
	public static final int SEARCH_FILE_CODE = 3;
	public static final String SEARCH_FILE_OPTION = "Search file";
	public static final int BACK_HOME_CODE = 4;
	public static final String BACK_HOME_OPTION = "Back to Home";
	
	public static final String[] OPERATE_OPRATION = new String[] {
		String.format("%d) %s", LockedmeConstants.ADD_FILE_CODE, LockedmeConstants.ADD_FILE_OPTION),
		String.format("%d) %s", LockedmeConstants.DELETE_FILE_CODE, LockedmeConstants.DELETE_FILE_OPTION ),
		String.format("%d) %s", LockedmeConstants.SEARCH_FILE_CODE, LockedmeConstants.SEARCH_FILE_OPTION),
		String.format("%d) %s", LockedmeConstants.BACK_HOME_CODE, LockedmeConstants.BACK_HOME_OPTION)
			};
}
