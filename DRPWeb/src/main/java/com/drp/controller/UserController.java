package com.drp.controller;

import com.drp.dto.FlowCardDto;
import com.drp.dto.UserDto;
import com.drp.pojo.FlowCardMain;
import com.drp.pojo.User;
import com.drp.service.IUserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 刘江涛
 * @ClassName: UserController
 * @Description: 用户控制层
 * @date 2017年11月1日 下午2:36:15
 */

@Controller
public class UserController implements Serializable {

    @Resource
    private IUserService userService;

    @RequestMapping("login.action")
    public String login(HttpServletRequest request, User user) {
        userService.login(user.getUserName());
        // 获取我们的错误信息
        request.getAttribute("shiroLoginFailure");
        return "login";
    }

    @RequestMapping("/findAll.action")
    @ResponseBody
    public String findAll() {
        List<User> users = userService.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            Date createDate = user.getCreateDate();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createTime = format.format(createDate);
            userDtoList.add(new UserDto(user.getuId(), user.getUserCode(), user.getUserName(), user.getUserTel(), user.getUserEmail(), createTime));
        }
        JSONArray jsonArray = JSONArray.fromObject(userDtoList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userDtoList", jsonArray);
        return jsonObject.toString();
    }

    @RequestMapping("/add.action")
    public String add(User user) {
        String userPassword = user.getUserPassword();
        Md5Hash md5Hash = new Md5Hash(userPassword, "drp", 10);
        userPassword = md5Hash.toString();
        user.setUserPassword(userPassword);
        user.setCreateDate(new Date());
        User add = userService.add(user);
        if (add == null) {
            return null;
        }
        return "systemManager/user_maint";
    }

    @RequestMapping("/update.action")
    public String update(User user) {
        Integer id = user.getuId();
        User byUserCode = userService.findOne(id);
        byUserCode.setUserName(user.getUserName());
        byUserCode.setUserTel(user.getUserTel());
        byUserCode.setUserEmail(user.getUserEmail());
        byUserCode.setUserCode(user.getUserCode());
        User update = userService.update(byUserCode);
        if (update == null)
            return null;
        return "systemManager/user_maint";
    }

    @RequestMapping("/deleteUser.action")
    @ResponseBody
    public void delete(@RequestParam(value = "ids", required = false) String ids) {
        System.out.println(ids);
        if (ids.contains("-")) {
            String[] idArray = ids.split("-");
            for (String id : idArray) {
                userService.delete(Integer.parseInt(id));
            }
        } else {
            userService.delete(Integer.parseInt(ids));
        }
    }

    @RequestMapping("/user_findOne.action")
    @ResponseBody
    public Integer findOne(@RequestParam("ids") String ids, HttpServletRequest request) {
        if (ids.length() == 0) {
            return 0;
        }
        if (ids.contains("-")) {
            return 1;
        }
        if (!ids.contains("-")) {
            HttpSession session = request.getSession();
            User user = userService.findOne(Integer.parseInt(ids));
            Date createDate = user.getCreateDate();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createTime = format.format(createDate);
            UserDto userDto = new UserDto(user.getuId(), user.getUserCode(), user.getUserName(), user.getUserTel(), user.getUserEmail(), createTime);
            session.setAttribute("userDto", userDto);
            return 3;
        }
        return null;
    }

}
