package com.drp.service.impl;

import com.drp.pojo.Item;
import com.drp.repository.ItemRepository;
import com.drp.service.IItemService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 刘江涛
 * @ClassName: ItemService
 * @Description: 业务逻辑层实体：物料
 * @date 2017年11月1日 下午2:41:48 s
 */
@Service
public class ItemService implements IItemService {

    @Resource
    private ItemRepository itemRepository;

    @Override
    public Item add(Item item) {
        Item saveAndFlush = itemRepository.saveAndFlush(item);
        if (saveAndFlush == null)
            return null;
        return saveAndFlush;
    }

    @Override
    public void delete(Integer id) {
        itemRepository.delete(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        for (Integer id : ids) {
            itemRepository.delete(id);
        }
    }

    @Override
    public Item update(Item item) {
        Item saveAndFlush = itemRepository.saveAndFlush(item);
        if (saveAndFlush == null)
            return null;
        return saveAndFlush;
    }

    @Override
    public Item findOne(Integer id) {
        Item item = itemRepository.findOne(id);
        if (item == null)
            return null;
        return item;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = itemRepository.findAll();
        boolean empty = CollectionUtils.isEmpty(items);
        if (empty)
            return null;
        return items;
    }

}
