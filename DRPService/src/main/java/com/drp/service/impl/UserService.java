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
        return userRepository.findAll();
    }


    public User login(String userName) {
        if (userName != null) {
            User user = userRepository.findByUserName(userName);
            if (null != user)
                return user;
            return null;
        }
        return null;
    }
}