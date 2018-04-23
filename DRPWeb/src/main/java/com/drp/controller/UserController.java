package com.drp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.drp.pojo.User;
import com.drp.service.IUserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 刘江涛
 * @ClassName: UserController
 * @Description: 用户控制层
 * @date 2017年11月1日 下午2:36:15
 */

@Controller
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("login.action")
    public String login(HttpServletRequest request, User user) {
        User user2 = userService.login(user.getUserName());
        System.out.println("2222:" + user2);

        // 获取我们的错误信息
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        System.out.println(exceptionClassName);
        return "login.jsp";
    }

}
