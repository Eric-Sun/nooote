package com.b13.nooote.utils.session;

public interface NoooteSession {
	
	public void set(String key,Object value);
	
	public Object get(String key);

}
