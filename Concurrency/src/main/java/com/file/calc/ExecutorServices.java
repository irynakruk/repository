package com.file.calc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorServices {
	private static final String DIR_PATH = "D:\\";

	private static final int NTHREDS = 10;

	private static Map<String, AtomicInteger> filesMap = new HashMap<>();
	private static Map<String, AtomicInteger> foldersMap = new HashMap<>();

	private static List<String> foldersDir = new LinkedList<>();

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
		FilesCalculatorThread calcThread = new FilesCalculatorThread(DIR_PATH);
		Future<ProcessedThreadData> future = executor.submit(calcThread);

		try {
			ProcessedThreadData data = future.get();
			filesMap.putAll(data.getFilesMap());
			foldersMap.putAll(data.getFoldersMap());
			foldersDir.addAll(data.getFoldersDir());

			while(!foldersDir.isEmpty()){
				processExecutors(executor);
			}	
			
			System.out.println("\nTotal files number\t" + filesMap.values().stream().mapToInt(AtomicInteger::intValue).sum());
			System.out.println("Distinct files number\t" + filesMap.size());
			
			System.out.println("\nTotal folders number\t" + foldersMap.values().stream().mapToInt(AtomicInteger::intValue).sum());
			System.out.println("Distinct folders number\t" + foldersMap.size());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		executor.shutdown();
		System.out.println("\nFinished all threads");
	}
	
	public static void processExecutors(ExecutorService executor) throws InterruptedException, ExecutionException{
		List<Future<ProcessedThreadData>> list = new ArrayList<Future<ProcessedThreadData>>();
		for (String dir : foldersDir) {
			FilesCalculatorThread callable = new FilesCalculatorThread(dir);
			Future<ProcessedThreadData> submit = executor.submit(callable);
			list.add(submit);
		}
		foldersDir.clear();
		
		for(Future<ProcessedThreadData> f : list){
			ProcessedThreadData data = f.get();
			mergeData(filesMap, data.getFilesMap());
			mergeData(foldersMap, data.getFoldersMap());
			foldersDir.addAll(data.getFoldersDir());
		}
	}
	
	public static void mergeData(Map<String, AtomicInteger> mainMap ,Map<String, AtomicInteger> map){
		for(Map.Entry<String, AtomicInteger> entry : map.entrySet()){
			if(mainMap.containsKey(entry.getKey())){
				AtomicInteger n = mainMap.get(entry.getKey());
				mainMap.get(entry.getKey()).set(n.addAndGet(entry.getValue().get()));
			} else{
				mainMap.put(entry.getKey(), entry.getValue());				
			}
		}
	}
}
