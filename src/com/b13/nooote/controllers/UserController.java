package com.b13.nooote.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.b13.nooote.core.BaseControllerDTO;
import com.b13.nooote.user.services.UserService;
import com.b13.nooote.utils.ResponseWritter;
import com.b13.nooote.utils.session.SessionUtil;
/**
 * 用户相关的http接口
 * @author Eric
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userServ;
	
	/**
	 * 登录方法 <p>
	 * 传入的参数为：
	 * <pre>
	 * userMail	用户的邮箱 *
	 * userPwd	用户账号的 *
	 * </pre>
	 * 返回值
	 * <pre>
	 * {
	 * 	"userId":1	用户的ID
	 * }
	 * </pre>
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		
		String userMail = req.getParameter("userMail");
		String userPwd = req.getParameter("userPwd");
		
		long userId = userServ.login(userMail, userPwd);
		
		class UserLoginDTO extends BaseControllerDTO{ 
			private long userId;
			public long getUserId() {
				return userId;
			}

			public void setUserId(long userId) {
				this.userId = userId;
			}
		}
		UserLoginDTO d = new UserLoginDTO();
		d.userId = userId;
		if( d.userId == -1)
			d.setResult(1);
		else
			// set session
			new SessionUtil(req).set("userId", userId);
//			req.getSession().setAttribute("userId", userId);
		new ResponseWritter(resp).write(JSON.toJSONString(d)).end();
		return null;
	}
	
}

