package com.Lockedme;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LockedMe {

	FileUtil util = new FileUtil();
	

	public static void main(String[] args) {
		LockedMe lockedMe = new LockedMe();
		lockedMe.DisplayMessage();
		lockedMe.HomeOptions();
	}
	
	void DisplayMessage(){
		System.out.println("\n LockedMe.com \n File Management \n Devloper: Priya \n Version 1.0.0.0 \n");
	}
	

	void HomeOptions() {
		int ch;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n");
			System.out.println("1.Display file");
			System.out.println("2.Operate file");
			System.out.println("3.Exit");
			System.out.println("Enter the choice:\n");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				List<FileDetail> files = util.getFiles();
				for (FileDetail f : files)
					System.out.println(f.getId() + "\t" + f.getFileName());
				break;
			case 2:
				System.out.println("\n Available options: ");
				OperationOptions();
				break;
			case 3:
				System.out.println("Good Bye!");
				break;

			default:
				System.out.println("Wrong choice, Enter correct option ");
			}

		} while (ch != 3 && ch!=2);
		sc.close();
	}

	void OperationOptions() {
		int ch;
		Scanner sc = new Scanner(System.in);
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
				if(util.search(fileName2)){
					System.out.println("File is existed");
				}
				else {
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
