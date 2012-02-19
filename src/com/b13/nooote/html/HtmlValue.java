package com.b13.nooote.html;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HtmlValue implements Map<String,String> {
	
	HashMap<String, String> map = null;
	
	public HtmlValue(){
		map = new HashMap<String, String>();
	}

	public void clear() {
		map.clear();
	}

	public boolean containsKey(Object key) {
		
		return map.containsKey(key);
	}

	public boolean containsValue(Object value) {
		
		return map.containsValue(value);
	}

	public Set<java.util.Map.Entry<String, String>> entrySet() {
		
		return map.entrySet();
	}

	public String get(Object key) {
		
		return map.get(key);
	}

	public boolean isEmpty() {
		
		return map.isEmpty();
	}

	public Set<String> keySet() {
		
		return map.keySet();
	}

	public String put(String key, String value) {
		
		return map.put(key, value);
	}

	public void putAll(Map<? extends String, ? extends String> m) {
		map.putAll(m);
	}

	public String remove(Object key) {
		
		return map.remove(key);
	}

	public int size() {
		
		return map.size();
	}

	public Collection<String> values() {
		
		return map.values();
	}

}
