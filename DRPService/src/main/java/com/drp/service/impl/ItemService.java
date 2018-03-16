package com.drp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drp.pojo.Item;
import com.drp.repository.ItemRepository;
import com.drp.service.IItemService;
import com.drp.util.StateAndMsg;

/**
 * 
 * @ClassName: ItemService
 * @Description: 业务逻辑层实体：物料
 * @author 王春
 * @date 2017年11月1日 下午2:41:48 s
 */
@Service
public class ItemService implements IItemService {

	@Resource
	private ItemRepository itemRepository;

	@Override
	public StateAndMsg add(Item t) {
		if (t != null) {
			if (t.getCode() != null) {
				if (t.getName() != null) {
					if (t.getItemType() != null) {
						if (t.getUnitType() != null) {
							itemRepository.save(t);
							return new StateAndMsg(1, "物料添加成功!");
						} else {
							return new StateAndMsg(-1, "物料类别不能为空!");
						}
					} else {
						return new StateAndMsg(-1, "物料类别不能为空!");
					}
				} else {
					return new StateAndMsg(-1, "物料名称不能为空!");
				}
			} else {
				return new StateAndMsg(-1, "物料代码不能为空!");
			}
		} else {
			return new StateAndMsg(-1, "参数有误！");
		}

	}

	@Override
	public StateAndMsg update(Item t) {
		if (t != null) {
			if (t.getId() != null) {
				if (t.getCode() != null) {
					if (t.getName() != null) {
						if (t.getItemType() != null) {
							if (t.getUnitType() != null) {
								itemRepository.save(t);
								return new StateAndMsg(1, "物料添加成功!");
							} else {
								return new StateAndMsg(-1, "物料类别不能为空!");
							}
						} else {
							return new StateAndMsg(-1, "物料类别不能为空!");
						}
					} else {
						return new StateAndMsg(-1, "物料名称不能为空!");
					}
				} else {
					return new StateAndMsg(-1, "物料代码不能为空!");
				}
			} else {
				return new StateAndMsg(-1, "物料Id不能为空!");
			}
		} else {
			return new StateAndMsg(-1, "参数有误！");
		}

	}

	@Override
	public void delete(List<Integer> ids) {
		for (Integer id : ids) {
			itemRepository.delete(id);
		}
	}

	@Override
	public Item findById(Integer id) {
		return itemRepository.findOne(id);
	}


	@Override
	public List<Item> findAll() {
		return itemRepository.findAll();
	}

}
