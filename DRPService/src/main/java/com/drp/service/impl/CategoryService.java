package com.drp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drp.pojo.Category;
import com.drp.repository.CategoryRepository;
import com.drp.service.ICategoryService;
import com.drp.util.StateAndMsg;

import java.util.List;

/**
 * @ClassName: CategoryService
 * @Description: 业务逻辑层实体：静态字典
 * @author 王春
 * @date 2017年11月7日 上午10:37:35
 * 
 */
@Service
public class CategoryService implements ICategoryService {
	@Autowired
	private CategoryRepository categoryRepository = null;

	@Override
	public StateAndMsg add(Category t) {
		if (t != null) {
			categoryRepository.save(t);
			return new StateAndMsg(1, "添加成功！");
		} else {
			return new StateAndMsg(-1, "参数有误！");
		}
	}

	@Override
	public void delete(List<Integer> ids) {

	}


	@Override
	public StateAndMsg update(Category t) {
		if (t != null) {
			if (t.getId() != null) {
				categoryRepository.save(t);
				return new StateAndMsg(1, "修改成功！");
			} else {
				return new StateAndMsg(-1, "Id不能为空！");
			}
		} else {
			return new StateAndMsg(-1, "参数有误！");
		}
	}

	@Override
	public Category findById(Integer id) {
		return null;
	}

	@Override
	public List<Category> findAll() {
		return null;
	}

}
