package com.Lockedme;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.Lockedme.constants.LockedmeConstants;

public class LockedMe {

	static Logger log = Logger.getLogger(LockedMe.class);

	FileUtil util = new FileUtil();

	public static void main(String[] args) {
		log.info("Application Started");
		LockedMe lockedMe = new LockedMe();
		lockedMe.AppWelcomeMessage();
		lockedMe.HomeOptions();
	}

	void AppWelcomeMessage() {
		StringBuilder builder = new StringBuilder();
		if (!LockedmeConstants.PROJECT_TITLE.isBlank()) {
			builder.append(String.format("%s%s", LockedmeConstants.PROJECT_TITLE, LockedmeConstants.NEW_LINE_CHAR));
		}
		if (!LockedmeConstants.PROJECT_SUB_TITLE.isBlank()) {
			builder.append(String.format("%s%s", LockedmeConstants.PROJECT_SUB_TITLE, LockedmeConstants.NEW_LINE_CHAR));
		}
		if (!LockedmeConstants.DEVELOPER_NAME.isBlank()) {
			builder.append(
					String.format("Devloper: %s%s", LockedmeConstants.DEVELOPER_NAME, LockedmeConstants.NEW_LINE_CHAR));
		}
		if (!LockedmeConstants.VERSION.isBlank()) {
			builder.append(String.format("Version: %s%s", LockedmeConstants.VERSION, LockedmeConstants.NEW_LINE_CHAR));
		}
		System.out.println(builder.toString());
	}

	void HomeOptions() {
		int ch;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(LockedmeConstants.NEW_LINE_CHAR);
			for (String option : LockedmeConstants.DISPLAY_OPTIONS) {
				System.out.println(option);
			}
			System.out.println(
					String.format("%s:%s", LockedmeConstants.ENTER_OPTION_CODE, LockedmeConstants.NEW_LINE_CHAR));
			ch = sc.nextInt();

			switch (ch) {
			case LockedmeConstants.DISPLAY_FILE_CODE:
				List<FileDetail> files = util.getFiles();
				for (FileDetail f : files) {
					System.out.println(String.format("%d%s%s", f.getId(), LockedmeConstants.TAB_CHAR, f.getFileName()));
				}
				break;
			case LockedmeConstants.OPERATE_FILE_CODE:
				OperationOptions();
				break;
			case LockedmeConstants.EXIT_CODE:
				System.out.println(
						String.format("%s:%s", LockedmeConstants.EXIT_MESSAGE, LockedmeConstants.NEW_LINE_CHAR));
				break;

			default:
				System.out.println(
						String.format("%s:%s", LockedmeConstants.DEFAULT_MESSAGE, LockedmeConstants.NEW_LINE_CHAR));
			}

		} while (ch != LockedmeConstants.OPERATE_FILE_CODE && ch != LockedmeConstants.EXIT_CODE);
		sc.close();
	}

	void OperationOptions() {
		int ch;
		Scanner sc = new Scanner(System.in);
		System.out.println(String.format("%s:%s", LockedmeConstants.OPERATE_OPTION, LockedmeConstants.NEW_LINE_CHAR));
		do {
			System.out.println(LockedmeConstants.NEW_LINE_CHAR);
			for (String option : LockedmeConstants.OPERATE_OPRATION) {
				System.out.println(option);
			}

			System.out.println(
					String.format("%s:%s", LockedmeConstants.ENTER_OPTION_CODE, LockedmeConstants.NEW_LINE_CHAR));
			ch = sc.nextInt();

			switch (ch) {
			case LockedmeConstants.ADD_FILE_CODE:
				String fileName;
				System.out.println(String.format("%s:%s", LockedmeConstants.FILENAME, LockedmeConstants.NEW_LINE_CHAR));
				fileName = sc.next();
				try {
					util.addFile(fileName);
				} catch (IOException e) {
					log.error("Failed to add file", e);
				}
				break;

			case LockedmeConstants.DELETE_FILE_CODE:
				String fileName1;
				System.out.println(String.format("%s:%s", LockedmeConstants.FILENAME, LockedmeConstants.NEW_LINE_CHAR));
				fileName1 = sc.next();
				util.deletFile(fileName1);
				break;

			case LockedmeConstants.SEARCH_FILE_CODE:
				String fileName2;
				System.out.println(String.format("%s:%s", LockedmeConstants.FILENAME, LockedmeConstants.NEW_LINE_CHAR));
				fileName2 = sc.next();
				if (util.search(fileName2)) {
					System.out.println(String.format("%s%s", LockedmeConstants.FILE_EXISTED_MESSAGE,
							LockedmeConstants.NEW_LINE_CHAR));
				} else {
					System.out.println(String.format("%s%s", LockedmeConstants.FILE_NOTEXISTED_MESSAGE,
							LockedmeConstants.NEW_LINE_CHAR));
				}

				break;

			case LockedmeConstants.BACK_HOME_CODE:
				HomeOptions();
				break;

			default:
				System.out.println(
						String.format("%s:%s", LockedmeConstants.DEFAULT_MESSAGE, LockedmeConstants.NEW_LINE_CHAR));
			}

		} while (ch != 4);
		sc.close();
	}

}
