package com.drp.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.drp.pojo.User;
import com.drp.repository.UserRepository;

/** 
* @ClassName: UserRepository 
* @Description: 用户dao层方法的测试
* @author 小灰灰
* @date 2017年11月1日 下午6:00:01 
*  
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-base.xml")
@Transactional
@Rollback(value = false)
public class UserRepositoryTest extends BaseService<User>{

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 添加用户
	 */
	@Test
	public void testSave() {
//		User user = new User();
//		user.setUsername("admin");
//		user.setUserPassword("123456");
//		user.setUserCode("admin111");
//		System.out.println(userRepository.save(user));
		User user = new User();
		user.setUsername("xixi");
		user.setUserPassword("123456");
		user.setCreateDate(new Date());
		user.setUserCode("U10001");
		user.setUserTel("13322334455");
		user.setUserEmail("10001110.qq.com");
		System.out.println(userRepository.save(user));
	}
	/**
	 * 用户维护 修改用户信息
	 */
	@Test
	public void testUpdateUser(){
		User user = new User(3,"haha","123456","13344556677","12345@qq.com","u1001",new Date());
		userRepository.updateUser(user.getUsername(),user.getUserPassword(),
			user.getUserTel(),user.getUserEmail(),user.getuId());
//		System.out.println(user);
	}
	/**
	 * 用户登陆    通过用户名查找
	 */
	@Test
	public void testFindByUsername(){
//		User user = userRepository.findByUsername("xixi");
//		System.out.println(user);
	}
	/**
	 * 修改密码
	 */
	@Test
	public void updatePassword() throws Exception {
		userRepository.updateUserPassword("admin123", 1);
	}
	/**
	 * 删除 用户 通过id
	 */
	@Test 
	public void testDelete(){
		Collection<User> ids = new ArrayList<User>();
		User user = new User();
		ids.add(user);
		ids.add(user);
		userRepository.delete(ids);
	}
	/**
	 * 分页  查找所有
	 * pageNo 查找那一页的数据
	 * pageSize 查多少条
	 */
	@Test
	public void testFindByConditions(){
		int pageNo = 1;
		Integer pageSize = 3;
		Page<User> page = findByConditions(pageNo, pageSize, userRepository);
		System.out.println(page.getContent());
	}
}
