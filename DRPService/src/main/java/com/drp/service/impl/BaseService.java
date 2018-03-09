package com.drp.service.impl;


import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.drp.repository.BaseRepository;
import com.drp.service.IBaseService;
import com.drp.util.StateAndMsg;

/** 
* @ClassName: BaseService 
* @Description: 业务逻辑层实体：基类
* @author 王春
* @date 2017年11月7日 下午1:46:22 
*  
*/
public abstract class BaseService<T extends Serializable> implements IBaseService<T> {
 
	@Resource
	private BaseRepository<T, Integer> baseRepository ;
	
	public StateAndMsg add(T t) {
		if(null!=t) {
			baseRepository.save(t);
			return new StateAndMsg(1, "添加成功！");
		}
		return new StateAndMsg(-1, "添加失败！");
	}

	public void delete(List<Integer> ids) {
		if(null!=ids) {
			for(Integer id:ids) {
			baseRepository.delete(id);
			}
		}
	}

	public StateAndMsg update(T t) {
		if(t!=null) {
			baseRepository.save(t);
			return new StateAndMsg(1, "修改成功！");
		}
		return new StateAndMsg(-1, "修改修改！");
	}

	public T findById(Integer id) {
		if(null!=id) {
			T t= baseRepository.findOne(id);
			return t;
		}
		return null;
	}

	public List<T> findByConditions(Integer pageNo, Integer pageSize, final Object... objects) {
		if(pageNo!=null&&pageSize!=null) {
			List<T> list=baseRepository.findByConditions(pageNo, pageSize, objects);
			return list;
		}
		return null;
	}
	public List<T> findAll(){
		List<T> list=baseRepository.findAll();
		return list;
		
	}
}
