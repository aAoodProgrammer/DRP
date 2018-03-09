package com.drp.test;

import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.drp.pojo.Menu;
import com.drp.pojo.Role;
import com.drp.pojo.User;
import com.drp.repository.RoleRepository;
import com.drp.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-base.xml")
@Transactional
@Rollback(value = false)
public class RoleRepositoryTest {
	
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	}

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * 测试更新角色
	 */
	@Test
	public void saveRole() {
		Role role = new Role();
		role.setId(1);
		role.setName("系统管理员");
		Set<User> users = role.getUsers();
		User user = new User();
		user.setuId(1);
		users.add(user);
		Set<Menu> menus = role.getMenus();
		Menu menu = new Menu();
		menu.setId(1);
		menus.add(menu);
		roleRepository.save(role);
	}
	/**
	 * 测试更新角色
	 */
	@Test
	public void deleteRole() {
		roleRepository.delete(2);
	}
	/**
	 * 测试更新角色
	 */
	@Test
	public void UpdateRole() {
		Role role = new Role();
		role.setId(1);
		role.setName("系统管理员");
		roleRepository.save(role);
	}
	/**
	 * 测试更新角色
	 */
	@Test
	public void findRole() {
		
	}

}
