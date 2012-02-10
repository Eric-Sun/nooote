package com.b13.nooote.daos;

public interface UserDAO {
	
	/**
	 * 检测是否存在该用户，如果存在返回id
	 * @param uesrMail
	 * @return 
	 */
	public long exist(String userMail,String userPwd);

}
