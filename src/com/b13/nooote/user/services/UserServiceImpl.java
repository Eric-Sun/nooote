package com.b13.nooote.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b13.nooote.daos.UserDAO;
import com.b13.nooote.utils.Md5Util;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userDAO;

	public long login(String userMail, String userPwd) {
		 
		String userPwdMd5 = Md5Util.MD5(userPwd);
		
		long userId = userDAO.exist(userMail,userPwdMd5);

		return userId;
	}

}
