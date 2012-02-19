package com.b13.nooote.utils.session;

import javax.servlet.http.HttpServletRequest;

public class HttpSessionImpl implements NoooteSession {
	
	HttpServletRequest req;
	
	public HttpSessionImpl(HttpServletRequest req){
		this.req = req;
	}

	public Object get(String key) {
		
		Object o =  req.getSession().getAttribute(key);
//		req = null;
		return o;
	}

	public void set(String key, Object value) {
		
		req.getSession().setAttribute(key, value);
//		req = null;
	}

}
