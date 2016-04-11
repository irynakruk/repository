package com.file.calc;

import java.util.Map;

public class Utils {

	public static synchronized void populateMap(Map<String, Integer> map,
			String name) {
		if (map.containsKey(name)) {
			int n = map.get(name);
			map.put(name, n++);
		} else {
			map.put(name, 1);
		}
	}

	public static synchronized long countValues(Map<String, Integer> map) {
		long n = 0L;
		for(Map.Entry<String, Integer> entry : map.entrySet()){
			n += entry.getValue();
		}
		return n;
	}
}
