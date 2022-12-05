package com.Lockedme;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.Lockedme.constants.LockedmeConstants;
import com.Lockedme.models.OperationResponse;

public class FileUtil {
	static int count = 0;
	List<FileDetail> files = new ArrayList<>();
	private String rootPath;

	public FileUtil(String _rootPath) {
		this.rootPath = _rootPath;
	}

	public List<FileDetail> getFiles() {
		File f = new File(this.rootPath);
		if (this.files != null) {
			this.files.clear();
		} else {
			this.files = new ArrayList<>();
		}
		count = 0;
		String[] fs = f.list();
		if (fs == null) {
			return null;
		}
		for (String file : fs) {
			count++;
			FileDetail fetchedFile = new FileDetail(count, file);
			files.add(fetchedFile);
		}
		return files;
	}

	public void addFile(String fileName) throws IOException {
		File f = new File(this.rootPath + fileName + ".txt");
		f.createNewFile();
	}

	public OperationResponse deletFile(String fileName) {
		boolean isDeleted = false;
		OperationResponse result = new OperationResponse();
		files = getFiles();
		if (files == null) {
			result.setSuccess(false);
			result.setMessage(LockedmeConstants.PATH_NOTEXIST_MESSAGE);
		} else if (files.isEmpty()) {
			result.setSuccess(false);
			result.setMessage(LockedmeConstants.FOLDER_EMPTY_MESSAGE);
		} else {
			for (FileDetail file : files) {
				if (file.getFileName().startsWith(fileName)) {
					File f = new File(this.rootPath + file.getFileName());
					f.delete();
					isDeleted = true;
					break;
				}
			}

			result.setSuccess(isDeleted);
			if (isDeleted) {
				result.setMessage(LockedmeConstants.DELETE_MESSAGE);
			} else {
				result.setMessage(LockedmeConstants.FILE_NOTEXISTED_MESSAGE);
			}
		}

		return result;
	}

	public OperationResponse search(String filName) {
		boolean isIdentified = false;
		OperationResponse result = new OperationResponse();
		files = getFiles();
		if (files == null) {
			result.setSuccess(false);
			result.setMessage(LockedmeConstants.PATH_NOTEXIST_MESSAGE);
		} else if (files.isEmpty()) {
			result.setSuccess(false);
			result.setMessage(LockedmeConstants.FOLDER_EMPTY_MESSAGE);
		} else {
			for (FileDetail file : files) {
				if (file.getFileName().startsWith(filName)) {
					isIdentified = true;
					break;
				}
			}

			result.setSuccess(isIdentified);
			if (isIdentified) {
				result.setMessage(LockedmeConstants.FILE_EXISTED_MESSAGE);
			} else {
				result.setMessage(LockedmeConstants.FILE_NOTEXISTED_MESSAGE);
			}
		}

		return result;
	}

}
