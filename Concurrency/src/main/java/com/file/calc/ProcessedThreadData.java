package com.file.calc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ProcessedThreadData {

	private Map<String, AtomicInteger> filesMap = new HashMap<>();
	private Map<String, AtomicInteger> foldersMap = new HashMap<>();

	private List<String> foldersDir = new LinkedList<>();

	public Map<String, AtomicInteger> getFilesMap() {
		return filesMap;
	}

	public void setFilesMap(Map<String, AtomicInteger> filesMap) {
		this.filesMap = filesMap;
	}

	public Map<String, AtomicInteger> getFoldersMap() {
		return foldersMap;
	}

	public void setFoldersMap(Map<String, AtomicInteger> foldersMap) {
		this.foldersMap = foldersMap;
	}

	public List<String> getFoldersDir() {
		return foldersDir;
	}

	public void setFoldersDir(List<String> foldersDir) {
		this.foldersDir = foldersDir;
	}
	
	public void populateFilesMap(String name) {
		populateMap(this.filesMap, name);
	}
	
	public void populateFoldersMap(String name) {
		populateMap(this.foldersMap, name);
	}
	
	private void populateMap(Map<String, AtomicInteger> map,
			String name) {
		if (map.containsKey(name)) {
			AtomicInteger n = map.get(name);
			n.set(n.incrementAndGet());
			map.put(name, n);
		} else {
			map.put(name, new AtomicInteger(1));
		}
	}
}
