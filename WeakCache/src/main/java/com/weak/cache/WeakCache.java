package com.weak.cache;

import java.util.List;
import java.util.Map;

public class WeakCache {	

	private static final int MAX_SIZE_HARD_CACHE = 30;

	private List<String> hardCache;
	private Map<String, byte[]> weakCache;	

	public WeakCache(List<String> hardCache, Map<String, byte[]> weakCache) {
		super();
		this.hardCache = hardCache;
		this.weakCache = weakCache;
	}

	public List<String> getHardCache() {
		return hardCache;
	}

	public Map<String, byte[]> getWeakCache() {
		return weakCache;
	}
	
	public void addElemToHardCache(String element){
		if(hardCache.size()<MAX_SIZE_HARD_CACHE){
			hardCache.add(element);
		} else {
			hardCache.remove(0);
			hardCache.add(element);
		}
	}

	@Override
	public String toString() {
		return "WeakCache [hardCache=" + hardCache + ", weakCache=" + weakCache
				+ "]";
	}
}
