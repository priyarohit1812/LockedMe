package com.Lockedme;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.Lockedme.constants.LockedmeConstants;

public class LockedMe {

	FileUtil util = new FileUtil();

	public static void main(String[] args) {
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
				System.out.println("Good Bye!");
				break;

			default:
				System.out.println("Wrong choice, Enter correct option ");
			}

		} while (ch != LockedmeConstants.OPERATE_FILE_CODE && ch != LockedmeConstants.EXIT_CODE);
		sc.close();
	}

	void OperationOptions() {
		int ch;
		Scanner sc = new Scanner(System.in);
		System.out.println("\n Available options: ");
		do {
			System.out.println("1.Add file");
			System.out.println("2.Delete file");
			System.out.println("3.Search file");
			System.out.println("4.Back");
			System.out.println("Enter the choice:\n");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				String fileName;
				System.out.println("Enter the filename");
				fileName = sc.next();
				try {
					util.addFile(fileName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 2:
				String fileName1;
				System.out.println("Enter the filename");
				fileName1 = sc.next();
				util.deletFile(fileName1);
				break;

			case 3:
				String fileName2;
				System.out.println("Enter the filename");
				fileName2 = sc.next();
				if (util.search(fileName2)) {
					System.out.println("File is existed");
				} else {
					System.out.println("File is not existed");
				}

				break;

			case 4:
				HomeOptions();
				break;

			default:
				System.out.println("Wrong choice, Enter correct option ");
			}

		} while (ch != 4);
		sc.close();
	}

}
