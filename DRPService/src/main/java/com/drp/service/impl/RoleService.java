package com.drp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.drp.pojo.Role;
import com.drp.repository.RoleRepository;
import com.drp.service.IRoleService;
import com.drp.util.StateAndMsg;

/**
 * @ClassName: RoleService
 * @Description: 业务逻辑层实体：角色
 * @author 王春
 * @date 2017年11月7日 上午10:44:11
 * 
 */
@Service
public class RoleService implements IRoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public StateAndMsg add(Role role) {
		StateAndMsg stateAndMsg = judge(role);
		if (stateAndMsg == null) {
			roleRepository.save(role);
			return stateAndMsg;
		}
		return stateAndMsg;
	}

	private StateAndMsg judge(Role role) {
		if (role != null) {
			return new StateAndMsg(-1, "参数有误！");
		}
		return null; 
	}

	@Override
	public StateAndMsg update(Role role) {
		if (role != null) {
			if (role.getId() != null) {
				roleRepository.save(role);
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
			roleRepository.delete(id);
		}
	}

	@Override
	public Role findById(Integer id) {
		return roleRepository.findOne(id);
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

}
