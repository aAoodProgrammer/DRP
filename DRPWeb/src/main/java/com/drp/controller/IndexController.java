package com.drp.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.drp.pojo.User;

@Controller
public class IndexController {

    /**
     * @param model
     * @return
     */
    @RequestMapping( "first.action" )
    public String first(Model model) {
        //按照原来的做法我们是不是需要将我们的用户名和菜单新新存储到我们的域对象里面去
        //获取用户信息放到我们的域对象
        //第一步:获取我们的主体
        Subject subject = SecurityUtils.getSubject();
        //第二步:通过主体获取我们的用户信息
        User activeUser = (User) subject.getPrincipal();
        //将数据放置到我们的域对象
        model.addAttribute("activeUser", activeUser);
        return "/main.html";
    }

    /**
     * 编写了一个授权的测试方法
     *
     * @return String
     * @Title: authrization
     * @Description: TODO
     */
    @RequestMapping( "bobo.action" )
    public String authrization() {
        return "/first.action";
    }
}
