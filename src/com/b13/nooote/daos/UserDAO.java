package com.b13.nooote.daos;

public interface UserDAO {
	
	/**
	 * ����Ƿ���ڸ��û���������ڷ���id
	 * @param uesrMail
	 * @return 
	 */
	public long exist(String userMail,String userPwd);

}
