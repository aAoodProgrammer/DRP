package com.drp.controller;

import javax.servlet.http.HttpServletRequest;

import com.drp.pojo.User;
import com.drp.service.IUserService;
import com.drp.service.impl.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @ClassName: UserController
 * @Description: 用户控制层
 * @author 刘江涛
 * @date 2017年11月1日 下午2:36:15
 *
 */

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService  = null;

	@RequestMapping("login.action")
	public String login(HttpServletRequest request, User user) {
		User user2 = userService.login(user.getUsername());
		System.out.println("2222:"+user2);
		// 获取我们的错误信息
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		System.out.println(exceptionClassName);
		return "login.jsp";
	}
	
}
