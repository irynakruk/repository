package com.weak.cache;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class WeakCache implements Map<String, Object> {

	private static final int MAX_SIZE_HARD_CACHE = 30;

	private List<String> hardCache = new LinkedList<String>();
	private Map<String, Object> weakCache = new WeakHashMap<String, Object>();

	private void addElemToHardCache(String element) {
		if (hardCache.size() < MAX_SIZE_HARD_CACHE) {
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

	@Override
	public int size() {
		return weakCache.size();
	}

	@Override
	public boolean isEmpty() {
		return weakCache.isEmpty();
	}

	@Override
	public boolean containsKey(java.lang.Object key) {
		return weakCache.containsKey(key);
	}

	@Override
	public boolean containsValue(java.lang.Object value) {
		return weakCache.containsValue(value);
	}

	@Override
	public Object get(java.lang.Object key) {
		return weakCache.get(key);
	}

	@Override
	public Object put(String key, Object value) {
		addElemToHardCache(key);
		return weakCache.put(key, value);
	}

	@Override
	public Object remove(java.lang.Object key) {
		hardCache.remove(key);
		return weakCache.remove(key);
	}

	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		weakCache.putAll(m);
		for(String key : m.keySet()){
			addElemToHardCache(key);
		}
	}

	@Override
	public void clear() {
		hardCache.clear();
		weakCache.clear();
	}

	@Override
	public Set<String> keySet() {
		return weakCache.keySet();
	}

	@Override
	public Collection<Object> values() {
		return weakCache.values();
	}

	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {		
		return weakCache.entrySet();
	}
}
