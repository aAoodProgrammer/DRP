package com.drp.service;

import com.drp.pojo.User;

/**
 * 
* @ClassName: IUserService 
* @Description: 业务逻辑层：
* @author 刘江涛
* @date 2017年11月1日 下午2:23:01 
*
 */
public interface IUserService extends IBaseService<User>{
	//登录
	User login(String uName);
	//修改密码
	Object alterPassword(Integer uId,String password,String newPassword);

}
