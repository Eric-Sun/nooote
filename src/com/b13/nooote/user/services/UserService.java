package com.b13.nooote.user.services;


public interface UserService {

	/**
	 * �жϵ�¼�Ƿ�ɹ�
	 * @param userMail
	 * @param userPwd
	 * @return
	 */
	public long login(String userMail,String userPwd);
	
}
