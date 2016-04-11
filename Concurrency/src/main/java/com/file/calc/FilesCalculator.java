package com.file.calc;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FilesCalculator {
	private static final String DIR_PATH = "D:\\";

	private static Map<String, Integer> filesMap = new HashMap<>();
	private static Map<String, Integer> foldersMap = new HashMap<>();

	public static void main(String[] args) {
		File startDir = new File(DIR_PATH);

		calculateDirectoryContent(startDir);

		System.out.println("\nTotal files number\t" + Utils.countValues(filesMap));
		System.out.println("\nDistinct files number\t" + filesMap.size());
		
		System.out.println("\nTotal folders number\t" + Utils.countValues(foldersMap));
		System.out.println("\nDistinct folders number\t" + foldersMap.size());
	}

	public static void calculateDirectoryContent(File dir) {
		File[] files = dir.listFiles();
		if (files == null) {
			return;
		}
		for (File file : files) {
			if (file.isDirectory()) {
				Utils.populateMap(foldersMap, file.getName());
				System.out.println("Folder\t" + file.getAbsolutePath());
				calculateDirectoryContent(file);
			} else {
				Utils.populateMap(filesMap, file.getName());
				System.out.println("File\t" + file.getAbsolutePath());
			}
		}
	}

	
}
