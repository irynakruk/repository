package com.file.calc;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FilesCalculatorNoMultithreading implements FilesCalculator{
	private static final String DIR_PATH = "D:\\";

	private static Map<String, Integer> filesMap = new HashMap<>();
	private static Map<String, Integer> foldersMap = new HashMap<>();

	public static void main(String[] args) {
		File startDir = new File(DIR_PATH);

		FilesCalculatorNoMultithreading calculator = new FilesCalculatorNoMultithreading();
		calculator.calculateDirectoryContent(startDir);

		System.out.println("\nTotal files number\t" + filesMap.values().stream().mapToInt(Integer::intValue).sum());
		System.out.println("Distinct files number\t" + filesMap.size());
		
		System.out.println("\nTotal folders number\t" + foldersMap.values().stream().mapToInt(Integer::intValue).sum());
		System.out.println("Distinct folders number\t" + foldersMap.size());
	}

	public void calculateDirectoryContent(File dir) {
		File[] files = dir.listFiles();
		if (files == null) {
			return;
		}
		for (File file : files) {
			if (file.isDirectory()) {
				populateMap(foldersMap, file.getName());
				System.out.println("Folder\t" + file.getAbsolutePath());
				calculateDirectoryContent(file);
			} else {
				populateMap(filesMap, file.getName());
				System.out.println("File\t" + file.getAbsolutePath());
			}
		}
	}
	
	public static void populateMap(Map<String, Integer> map,
			String name) {
		if (map.containsKey(name)) {
			int n = map.get(name);
			map.put(name, ++n);
		} else {
			map.put(name, 1);
		}
	}
}
