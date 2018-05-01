package com.drp.service;

import com.drp.pojo.User;

import java.util.List;

/**
 * @author 刘江涛
 * @ClassName: IUserService
 * @Description: 业务逻辑层：
 * @date 2017年11月1日 下午2:23:01
 */
public interface IUserService {
    User add(User user);

    void delete(Integer id);

    void deleteByIds(List<Integer> ids);

    void deleteAllByUserCode(String userCode);

    User update(User user);

    User findOne(Integer id);

    List<User> findAll();

    //登录
    User login(String uName);

    //修改密码
    Object alterPassword(Integer uId, String password, String newPassword);

    User findByUserCode(String userCode);

}
