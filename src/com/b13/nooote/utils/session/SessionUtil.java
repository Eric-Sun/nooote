package com.b13.nooote.utils.session;

import javax.servlet.http.HttpServletRequest;

/**
 * nooote中的session获取类，用于区分不同的session，存储方式
 * 暂时使用httpsession作为session存储方式
 * @author Eric
 *
 */
public class SessionUtil{
	
	NoooteSession sessionController = null;
	
	public SessionUtil(HttpServletRequest req){
		sessionController = new HttpSessionImpl(req);
	}
	
	public Object get(String key ){
		return sessionController.get(key);
	}
	
	public void set(String key,Object value){
		sessionController.set(key,value);
	}

}
