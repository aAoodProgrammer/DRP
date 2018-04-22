package com.drp.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.drp.pojo.*;
import com.drp.service.IUserService;

@Controller
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    @Override
    public String getName() {
        return "customRealm";
    }

    // 支持什么类型的token
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // 从token中 获取用户身份信息
        String username = (String) token.getPrincipal();
        System.out.println(1111);
        // 拿username从数据库中查询
        User activeUser = userService.login(username);

        System.out.println("数据库查出的用户信息：" + activeUser);

        // 如果查询不到则返回null
        if (null == activeUser) {// 这里模拟查询不到
            return null;
        }
        // 因为用户登陆之后要将用户名显示出来 所以这里就不能够传递 用户名了而是将整个用户对象给传进去
        // 返回认证信息由父类AuthenticatingRealm进行认证
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                activeUser,
                activeUser.getUserPassword(),
                getName());
        return simpleAuthenticationInfo;
    }

    // 授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取身份信息
        User activeUser = (User) principals.getPrimaryPrincipal();

        // 根据用户id从数据库中查询权限数据
        // ....这里使用静态数据模拟
        List<String> permissions = new ArrayList<String>();
        permissions.add("user:create");
        permissions.add("user:update");

        // 将权限信息封闭为AuthorizationInfo
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (String permission : permissions) {
            simpleAuthorizationInfo.addStringPermission(permission);
        }
        return simpleAuthorizationInfo;
    }

}
