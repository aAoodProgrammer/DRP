package com.drp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drp.pojo.Menu;
import com.drp.repository.MenuRepository;
import com.drp.service.IMenuService;
import com.drp.util.StateAndMsg;

/**
 * @ClassName: MenuService
 * @Description: 业务逻辑层实体：菜单
 * @author 王春
 * @date 2017年11月7日 上午10:43:17
 * 
 */
@Service
public class MenuService implements IMenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Override
	public StateAndMsg add(Menu t) {
		if (t != null) {
			menuRepository.save(t);
			return new StateAndMsg(1, "添加成功！");
		} else {
			return new StateAndMsg(-1, "参数有误！");
		}
	}

	@Override
	public StateAndMsg update(Menu t) {
		if (t != null) {
			if (t.getId() != null) {
				menuRepository.save(t);
				return new StateAndMsg(1, "修改成功！");
			} else {
				return new StateAndMsg(-1, "Id不能为空！");
			}
		} else {
			return new StateAndMsg(-1, "参数有误！");
		}
	}

	@Override
	public void delete(List<Integer> ids) {
		for (Integer id : ids) {
			menuRepository.delete(id);
		}
	}

	@Override
	public Menu findById(Integer id) {
		return menuRepository.findOne(id);
	}

	@Override
	public List<Menu> findAll() {
		return menuRepository.findAll();
	}

}
