package com.drp.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.drp.pojo.EndClient;
import com.drp.repository.EndClientRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-base.xml")
@Transactional
@Rollback(value = false)
public class EndClientTest extends BaseService<EndClient>{

	@Autowired
	private EndClientRepository EndClientRepository;
	
	@Test
	public void save() throws Exception {
		EndClient endClient = new EndClient();
		endClient.setId(5);
		endClient.setName("所有终端分销商");
		endClient.setIsEndClient("是");
		endClient.setIsLeaf("是");
		endClient.setCode("10000");
		EndClientRepository.save(endClient);
		EndClient endClient2 = new EndClient(2,"华北区", "", "是", "否");
		EndClient endClient3 = new EndClient(3,"北京区", "", "是", "否");
		EndClient endClient4 = new EndClient(4,"北京医药股份有限公司", "c1000", "是", "是");
		EndClientRepository.save(endClient4);
	}
	/**
	 * 级联删除
	 * @throws Exception
	 */
	@Test
	public void delete() throws Exception {
		EndClientRepository.delete(7);
	}
	
	@Test
	public void findByUpperId() throws Exception {
		List<EndClient> endClients = EndClientRepository.queryByUpperId(1);
		System.out.println(endClients);
//		EndClient endClient = EndClientRepository.findOne(1);
//		System.out.println(endClient);
		
	}
	
	@Test
	public void update() throws Exception {
		EndClientRepository.updateEndClient("东北区", null, null, null, null, null, 3);
		System.out.println("我运行了");
	}
}
