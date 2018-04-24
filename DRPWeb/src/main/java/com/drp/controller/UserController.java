package com.drp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.drp.pojo.Inventory;
import com.drp.pojo.User;
import com.drp.service.IUserService;

import com.drp.util.BasePage;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        return "login";
    }

    /**
     * 查询所有
     */
    @RequestMapping("/user_maint.action")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.findAll();
        System.out.println(users);
        modelAndView.addObject("users", users);
        modelAndView.setViewName("systemManager/user_maint");
        return modelAndView;
    }

}
