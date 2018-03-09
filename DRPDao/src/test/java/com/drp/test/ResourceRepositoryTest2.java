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
import com.drp.pojo.Resource;
import com.drp.repository.ResourceRepository;

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
public class ResourceRepositoryTest2 extends BaseService<Resource>{
	
	@Autowired
	private ResourceRepository resourceRepository;
	
	@Test 
	public void saveResource(){
		Menu menu2 = new Menu(2, "用户管理", 1, null, null, null);
//		Resource resource1 = new Resource(1, "添加用户", "saveUser.action", menu2);
//		Resource resource2 = new Resource(2, "删除用户", "deleteUser.action", menu2);
//		Resource resource3 = new Resource(3, "更新用户", "updateUser.action", menu2);
//		Resource resource4 = new Resource(4, "查找用户", "findUser.action", menu2);
//		resourceRepository.save(resource1);
//		resourceRepository.save(resource2);
//		resourceRepository.save(resource3);
//		resourceRepository.save(resource4);
		Resource resource5 = new Resource(5, "111用户", "111.action", menu2);
		resourceRepository.save(resource5);
		
	
	}
	@Test 
	public void deleteResource(){
		resourceRepository.delete(6);
	}
	
	@Test 
	public void updateResource(){
		Menu menu2 = new Menu();
		menu2.setId(3);
		resourceRepository.save(new Resource(6, "修改密码", "http://.../resource", menu2) );
	
	}
	@Test 
	public void findResource(){
		List<Resource> resources = resourceRepository.findByMenuId(2);
		System.out.println(resources);
	}
	
	@Test
	public void testFindByConditions(){
		int pageNo = 1;
		Integer pageSize = 10;
		Page<Resource> page = findByConditions(pageNo, pageSize, resourceRepository);
		System.out.println(page.getContent());
	}
}
