package com.drp.service.impl;

import java.util.List;

import com.drp.util.BasePage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.drp.pojo.User;

import com.drp.repository.UserRepository;
import com.drp.service.IUserService;
import com.drp.util.Encryption;
import com.drp.util.StateAndMsg;

import javax.annotation.Resource;

/**
 * @author 刘江涛
 * @ClassName: UserService
 * @Description: 业务逻辑层实体：用户
 * @date 2017年11月1日 下午2:46:06
 */
@Service
public class UserService implements IUserService {

    @Resource
    private UserRepository userRepository;

    private StateAndMsg judge(User user) {
        if (user == null) {
            return new StateAndMsg(-1, "参数有误！");
        }
        if (user.getUserCode() == null) {
            return new StateAndMsg(-1, "用户代码不能为空！");
        }
        if (user.getUserName() == null) {
            return new StateAndMsg(-1, "用户名不能为空！");
        }
        if (user.getUserPassword() == null) {
            return new StateAndMsg(-1, "密码不能为空！");
        }

//		if (userRepository.findByUserCode(user.getUserCode()) != null) {
//			return new StateAndMsg(-1, "用户代码已存在！");
//		}
        if (userRepository.findByUserName(user.getUserName()) != null) {
            return new StateAndMsg(-1, "用户名已存在！");
        }
        if (userRepository.findByUserTel(user.getUserTel()) != null) {
            return new StateAndMsg(-1, "用户手机已存在！");
        }
        if (userRepository.findByUserEmail(user.getUserEmail()) != null) {
            return new StateAndMsg(-1, "用户邮箱已存在！");
        }
        return null;

    }

    @Override
    public User add(User user) {
        User saveAndFlush = userRepository.saveAndFlush(user);
        if (saveAndFlush == null)
            return null;
        return saveAndFlush;
    }

    @Override
    public void delete(Integer id) {
        userRepository.delete(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        for (Integer id : ids) {
            userRepository.delete(id);
        }
    }

    @Override
    public User update(User user) {
        User saveAndFlush = userRepository.saveAndFlush(user);
        if (saveAndFlush == null)
            return null;
        return saveAndFlush;
    }

    @Override
    public User findOne(Integer id) {
        User user = userRepository.findOne(id);
        if (user == null)
            return null;
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }


    public User login(String userName) {
        if (userName != null) {
            User user = userRepository.findByUserName(userName);
            if (null != user) {
                return user;
            }
            return null;
        }
        return null;
    }

    public StateAndMsg alterPassword(Integer uId, String password, String newPassword) {
        User user = userRepository.findOne(uId);
        if (password != null && newPassword != null) {
            if (Encryption.EncoderByMd5(password).equals(user.getUserPassword())) {
                userRepository.updateUserPassword(Encryption.EncoderByMd5(newPassword), uId);
                return new StateAndMsg(1, "密码修改成功！");
            } else {
                return new StateAndMsg(-1, "原始密码不匹配！");
            }
        } else {
            return new StateAndMsg(-1, "输入信息有误！");
        }

    }

}