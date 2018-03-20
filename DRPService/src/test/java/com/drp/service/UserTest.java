package com.drp.service;


import org.springframework.beans.factory.annotation.Autowired;


/** 
* @ClassName: UserTest 
* @Description: 控制测试类：用户
* @author 刘江涛
* @date 2017年11月1日 下午6:53:24 
*  
*/
public class UserTest {
	@Autowired
	private static IUserService userService=null;
	public static void main(String[] args) {
		//Object users = userService.login("asdasd", "asdasda");
		System.out.println("asdsad");
	}

}
