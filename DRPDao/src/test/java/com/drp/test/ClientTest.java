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

import com.drp.pojo.Client;
import com.drp.repository.ClientRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-base.xml")
@Transactional
@Rollback(value = false)
public class ClientTest extends BaseService<Client>{

	@Autowired
	private ClientRepository clientRepository ;
	
	@Test
	public void save() throws Exception {
//		System.out.println("1111");
		Client client = new Client();
		client.setId(1);
		client.setName("所有分销商");
		client.setIsClient("否");
		client.setIsLeaf("否");
		client.setCode("10000");
//		clientRepository.save(client);
		Client client2 = new Client(2,"华北区", "10001", "否","否",client);
//		clientRepository.save(client2);
		Client client3 = new Client(3,"北京区", "","否", "否",client2);
//		clientRepository.save(client3);
		Client client4 = new Client(4,"北京医药股份有限公司", "c1000", "是", "是",client3);
		clientRepository.save(client4);
	}
	
	/**
	 * 级联删除
	 * @throws Exception
	 */
	@Test
	public void delete() throws Exception {
		clientRepository.delete(7);
	}
	
	@Test
	public void findByUpperId() throws Exception {
		List<Client> client = clientRepository.queryByUpperId(1);
		System.out.println(client);
//		Client client2 = clientRepository.findOne(1);
//		System.out.println(client2);
		
	}
	
	@Test
	public void findLike() throws Exception {
		List<Client> client = clientRepository.queryLikeNoOrName("1");
		System.out.println(client);
//		Client client2 = clientRepository.findOne(1);
//		System.out.println(client2);
		
	}
	
	@Test
	public void update() throws Exception {
		clientRepository.updateClient("东北区", null, null, null, null, null, 3);
		System.out.println("我运行了");
	}
	
	@Test
	public void testPage() throws Exception {
		Page<Client> page =findByConditions(1, 3, clientRepository, "isLeaf", "是","id",3);
		System.out.println(page.getContent());
		System.out.println(page.getNumberOfElements());
	}
	/**
	 * 查找所有的区
	 * @throws Exception
	 */
	@Test
	public void findArea() throws Exception {
		List<Client> clients = clientRepository.queryArea();
		System.out.println(clients.size());
	}
	@Test
	public void findProvince() throws Exception {
		List<Client> clients = clientRepository.queryProvince();
		System.out.println(clients.size());
	}
}
