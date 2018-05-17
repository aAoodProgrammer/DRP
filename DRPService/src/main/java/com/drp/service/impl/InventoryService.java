package com.drp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.drp.pojo.Inventory;
import com.drp.repository.InventoryRepository;
import com.drp.service.IInventoryService;
import org.springframework.util.CollectionUtils;

/**
 * @author 刘江涛
 * @ClassName: InventoryService
 * @Description: 业务逻辑层实体：库存管理
 * @date 2017年11月1日 下午2:41:03
 */
@Service
public class InventoryService implements IInventoryService {

    @Resource
    private InventoryRepository inventoryRepository;


    @Override
    public Inventory add(Inventory inventory) {
        Inventory saveAndFlush = inventoryRepository.saveAndFlush(inventory);
        if (saveAndFlush == null)
            return null;
        return saveAndFlush;
    }

    @Override
    public void delete(Integer id) {
        inventoryRepository.delete(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        for (Integer id : ids) {
            inventoryRepository.delete(id);
        }
    }

    @Override
    public Inventory update(Inventory inventory) {
        Inventory saveAndFlush = inventoryRepository.saveAndFlush(inventory);
        if (saveAndFlush == null)
            return null;
        return saveAndFlush;
    }

    @Override
    public Inventory findOne(Integer id) {
        Inventory inventory = inventoryRepository.findOne(id);
        if (inventory == null)
            return null;
        return inventory;
    }

    @Override
    public List<Inventory> findAll() {
        List<Inventory> inventories = inventoryRepository.findAll();
        boolean empty = CollectionUtils.isEmpty(inventories);
        if (empty)
            return null;
        return inventories;
    }
}
