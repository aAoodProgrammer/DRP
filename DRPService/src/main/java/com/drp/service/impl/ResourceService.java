package com.drp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drp.pojo.Resource;
import com.drp.repository.ResourceRepository;
import com.drp.service.IResourceService;
import com.drp.util.StateAndMsg;

/**
 * @ClassName: ResourceService
 * @Description: 业务逻辑层实体：资源
 * @author 王春
 * @date 2017年11月7日 上午10:43:38
 * 
 */
@Service
public class ResourceService implements IResourceService {

	@Autowired
	private ResourceRepository resourceRepository;

	@Override
	public StateAndMsg add(Resource t) {
		if (t != null) {
			resourceRepository.save(t);
			return new StateAndMsg(1, "添加成功!");

		} else {
			return new StateAndMsg(-1, "参数有误！");
		}
	}

	@Override
	public StateAndMsg update(Resource t) {
		if (t != null) {
			if (t.getId() != null) {
				resourceRepository.save(t);
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
			resourceRepository.delete(id);
		}
	}

	@Override
	public Resource findById(Integer id) {
		return resourceRepository.findOne(id);
	}

	@Override
	public List<Resource> findByConditions(Integer pageNo, Integer pageSize, Object... objects) {
		return resourceRepository.findByConditions(pageNo, pageSize, objects);
	}

	@Override
	public List<Resource> findAll() {
		return resourceRepository.findAll();
	}

}
