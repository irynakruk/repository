package com.weak.cache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class Main {

	private static final int MAX_SIZE_OF_ELEMENTS = 100;

	private static final String FILE_PATH = "D:\\pdp\\test\\";

	public static void main(String[] args) {
		WeakCache weakCache = new WeakCache();
		// Main.createFiles();
		Main.populateCache(weakCache);
	}

	public static void populateCache(WeakCache cache) {
		Random random = new Random();
		for (int i = 0; i < MAX_SIZE_OF_ELEMENTS; i++) {
			String fileName = String.valueOf(random
					.nextInt(MAX_SIZE_OF_ELEMENTS) + 1);
			try (RandomAccessFile file = new RandomAccessFile(FILE_PATH
					+ fileName, "r")) {
				byte[] bytes = new byte[(int) file.length()];
				file.read(bytes);
				cache.put(fileName, bytes);
				System.out.println(cache);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void createFiles() {
		for (int i = 1; i <= MAX_SIZE_OF_ELEMENTS; i++) {
			File file = new File(FILE_PATH + i);
			try {
				if (file.createNewFile()) {
					System.out.println("file created");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
