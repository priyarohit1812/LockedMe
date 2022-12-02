package com.Lockedme;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	static int count = 0;
	List<FileDetail> files = new ArrayList<>();

	public List<FileDetail> getFiles() {
		File f = new File("F:\\FileIO\\Lockedme");
		if (this.files != null) {
			this.files.clear();
		} else {
			this.files = new ArrayList<>();
		}
		count = 0;
		String[] fs = f.list();
		for (String file : fs) {
			count++;
			FileDetail fetchedFile = new FileDetail(count, file);
			files.add(fetchedFile);
		}
		return files;
	}

	public void addFile(String fileName) throws IOException {
		File f = new File("F:\\FileIO\\Lockedme\\" + fileName + ".txt");
		f.createNewFile();
	}

	public boolean deletFile(String fileName) {
		boolean isDeleted = false;
		files = getFiles();
		for (FileDetail file : files) {
			if (file.getFileName().startsWith(fileName)) {
				File f = new File("F:\\FileIO\\Lockedme\\" + file.getFileName());
				f.delete();
				isDeleted = true;
				break;
			}
		}
		return isDeleted;
	}

	public boolean search(String filName) {
		boolean isIdentified = false;
		files = getFiles();
		for (FileDetail file : files) {
			if (file.getFileName().startsWith(filName)) {
				isIdentified = true;
				break;
			}
		}
		return isIdentified;
	}
	
	
}
