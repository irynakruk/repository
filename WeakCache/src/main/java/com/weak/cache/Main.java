package com.weak.cache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.Random;
import java.util.WeakHashMap;

public class Main {

	private static final int MAX_SIZE_OF_ELEMENTS = 100;

	private static final String FILE_PATH = "D:\\pdp\\test\\";

	public static void main(String[] args) {
		WeakCache weakCache = new WeakCache(new LinkedList<String>(),
				new WeakHashMap<String, byte[]>());
		//Main.createFiles();
		Main.populateCache(weakCache);
	}

	public static void populateCache(WeakCache cache) {
		Random random = new Random();
		while (true) {
			String fileName = String.valueOf(random.nextInt(MAX_SIZE_OF_ELEMENTS + 1));
			try (RandomAccessFile file = new RandomAccessFile(FILE_PATH
					+ fileName, "r")) {
				cache.addElemToHardCache(fileName);
				byte[] bytes = new byte[(int) file.length()];
				file.read(bytes);
				cache.getWeakCache().put(fileName, bytes);
				System.out.println(cache);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void createFiles() {
		for (int i = 1; i <= 100; i++) {
			File file = new File(FILE_PATH + i);
			try {
				if(file.createNewFile()){
					System.out.println("file created");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
