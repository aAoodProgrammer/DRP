package com.drp.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.drp.pojo.Client;
import com.drp.pojo.Fiscal;
import com.drp.pojo.Inventory;
import com.drp.pojo.Item;
import com.drp.pojo.Menu;
import com.drp.repository.InventoryRepository;
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
public class InventoryTest extends BaseService<Menu>{
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Test
	public void save() throws Exception {
		Inventory inventory = new Inventory(1, 100, 0, 0, "未确认");
		Fiscal fiscal =new Fiscal();
		fiscal.setId(1);
		Item item = new Item();
		item.setId(1);
		Client client = new Client();
		client.setId(4);
		inventory.setFiscal(fiscal);
		inventory.setItem(item);
		inventory.setClient(client);
		inventoryRepository.save(inventory);
	}
	@Test
	public void findByClinetItem() throws Exception {
		List<Inventory> inventories =  inventoryRepository.findByClientIdAndItemId(4, 1);
		System.out.println(inventories.size());
	}
//	
}
