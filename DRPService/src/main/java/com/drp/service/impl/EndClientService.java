package com.drp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.drp.pojo.EndClient;
import com.drp.repository.EndClientRepository;
import com.drp.service.IEndClientService;
import com.drp.util.StateAndMsg;

/** 
* @ClassName: EndClientService 
* @Description: 业务逻辑层实体：终端客户
* @author 王春
* @date 2017年11月7日 上午10:40:28 
*  
*/
@Service
public class EndClientService implements IEndClientService{

	@Resource
	private EndClientRepository endClientRepository ;
	@Override
	public StateAndMsg add(EndClient t) {
		if(t!=null) {
			endClientRepository.save(t);
			return new StateAndMsg(1, "添加成功！");
		}else {
			return new StateAndMsg(-1,"参数有误！");
		}
	}

	@Override
	public StateAndMsg update(EndClient t) {
		if(t!=null) {
			if(t.getId()!=null) {
				endClientRepository.save(t);
				return new StateAndMsg(1, "修改成功！");
			}else {
				return new StateAndMsg(-1, "Id不能为空！");
			}
		}else {
			return new StateAndMsg(-1,"参数有误！");
		}
	}

	@Override
	public void delete(List<Integer> ids) {
		for (Integer id : ids) {
			endClientRepository.delete(id);
		}
	}

	@Override
	public EndClient findById(Integer id) {
		return endClientRepository.findById(id);
	}


	@Override
	public List<EndClient> findAll() {
		
		return endClientRepository.findAll();
	}
	
	
	
}
