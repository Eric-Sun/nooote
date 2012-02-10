package com.b13.nooote.user.services;


public interface UserService {

	/**
	 * ÅÐ¶ÏµÇÂ¼ÊÇ·ñ³É¹¦
	 * @param userMail
	 * @param userPwd
	 * @return
	 */
	public long login(String userMail,String userPwd);
	
}
