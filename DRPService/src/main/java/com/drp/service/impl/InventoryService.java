package com.drp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drp.pojo.Inventory;
import com.drp.repository.InventoryRepository;
import com.drp.service.IInventoryService;
import com.drp.util.StateAndMsg;

/**
 * 
 * @ClassName: InventoryService
 * @Description: 业务逻辑层实体：库存管理
 * @author 王春
 * @date 2017年11月1日 下午2:41:03
 *
 */
@Service
public class InventoryService implements IInventoryService {

	@Resource
	private InventoryRepository inventoryRepository;

	public List<Inventory> find() {
//		return inventoryRepository.findByClientIdAndItemId(7, 1);
		return inventoryRepository.findAll();
	}
	
	@Override
	public StateAndMsg add(Inventory t) {
		if (t != null) {
			inventoryRepository.save(t);
			return new StateAndMsg(1, "添加成功");

		} else {
			return new StateAndMsg(-1, "参数有误！");
		}
	}

	@Override
	public StateAndMsg update(Inventory t) {
		if (t != null) {
			if (t.getId() != null) {
				inventoryRepository.save(t);
				return new StateAndMsg(1, "修改成功!");
			} else {
				return new StateAndMsg(-1, "Id为空!");
			}
		} else {
			return new StateAndMsg(-1, "参数有误！");
		}
	}

	@Override
	public void delete(List<Integer> ids) {
		for (Integer id : ids) {
			inventoryRepository.delete(id);
		
		}
	}

	@Override
	public Inventory findById(Integer id) {
		return inventoryRepository.findOne(id);
	}

	@Override
	public List<Inventory> findByConditions(Integer pageNo, Integer pageSize, Object... objects) {
		return inventoryRepository.findByConditions(pageNo, pageSize, objects);
	}

	@Override
	public List<Inventory> findAll() {
		return inventoryRepository.findAll();
	}

	public List<Inventory> pageByClientId(Integer clientId,Integer itemId,Integer currentPage) {
		Integer pageSize = 10;
		return inventoryRepository.pageByClientId(clientId,itemId,currentPage, 10);
		
	}
}
