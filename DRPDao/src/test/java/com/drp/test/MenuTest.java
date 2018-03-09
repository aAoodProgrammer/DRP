package com.drp.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.drp.pojo.Menu;
import com.drp.repository.MenuRepository;

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
public class MenuTest extends BaseService<Menu>{
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Test
	public void saveMenu() throws Exception {
		Menu menu1 = new Menu(1, "基本数据管理", 1, null, null, null);
		Menu menu2 = new Menu(2, "用户管理", 2, menu1, null, null);
		Menu menu3 = new Menu(3, "系统登录", 2, menu1, null, null);
		Menu menu4 = new Menu(4, "角色维护", 2, menu1, null, null);
//		Resource resource1 = new Resource(1, "添加用户", "saveUser.action", null);
//		Resource resource2 = new Resource(2, "删除用户", "deleteUser.action", null);
//		Resource resource3 = new Resource(3, "更新用户", "updateUser.action", null);
//		Resource resource4 = new Resource(4, "查找用户", "findUser.action", null);
//		Set<Resource> resources = menu2.getResources();
//		resources.add(resource1);
//		resources.add(resource2);
//		resources.add(resource3);
//		resources.add(resource4);
		menuRepository.save(menu1);
		menuRepository.save(menu2);
		menuRepository.save(menu3);
		menuRepository.save(menu4);
		
	}
	@Test
	public void deleteMenu() throws Exception {
		menuRepository.delete(3);
	}
	@Test
	public void updateMenu() throws Exception {
		Menu menu = new Menu(1, "数据管理", 1, null, null, null);
//		menuRepository.update(menu.getName(), menu.getId());
//		Menu menu2 = new Menu(2, "用户数据管理", 1, null, null, null);
//		menuRepository.update(menu2.getName(), menu2.getId());
	
	}
	@Test
	public void findMenu() throws Exception {
		List<Menu> menus = menuRepository.findByUpperId(1);
		System.out.println(menus);
	}
	
	@Test
	public void findLikeName() throws Exception {
		List<Menu> menus = menuRepository.findLikeName("用户");
		System.out.println(menus);
	}
	
	/**
	 * 分页  查找所有
	 * pageNo 查找那一页的数据
	 * pageSize 查多少条
	 */
	@Test
	public void testFindByConditions(){
		int pageNo = 1;
		Integer pageSize = 10;
		Page<Menu> page = findByConditions(pageNo, pageSize, menuRepository);
		System.out.println(page.getContent());
	}
}
