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
	
	//Success Messages
	
	//Error Messages
}
