package com.drp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drp.pojo.FlowCardMain;
import com.drp.repository.FlowCardMainRepository;
import com.drp.service.IFlowCardMainService;
import com.drp.util.StateAndMsg;

/** 
* @ClassName: FlowCardMainService 
* @Description: 业务逻辑层实体：流向单
* @author 王春
* @date 2017年11月7日 上午10:42:04 
*  
*/
@Service
public class FlowCardMainService implements IFlowCardMainService{

	@Resource
	FlowCardMainRepository flowCardMainRepository;

	@Override
	public StateAndMsg add(FlowCardMain t) {
		if(t!=null) {
			if(t.getClient()!=null) {
			if(t.getFlowCardDetails()!=null) {
				flowCardMainRepository.save(t);
				return new StateAndMsg(-1, "详情不能为空");
			}else {
				return new StateAndMsg(-1, "详情不能为空");
			}
		}else {
			return new StateAndMsg(-1, "供方分销商不能为空");
		}
		}else {
			return new StateAndMsg(-1,"参数有误！");
		}
		
	}

	@Override
	public StateAndMsg update(FlowCardMain t) {
		if(t!=null) {
		if(t.getId()!=null) {
			if(t.getClient()!=null) {
				if(t.getFlowCardDetails()!=null) {
					flowCardMainRepository.save(t);
					return new StateAndMsg(-1, "详情不能为空");
				}else {
					return new StateAndMsg(-1, "详情不能为空");
				}
			}else {
				return new StateAndMsg(-1, "供方分销商不能为空");
			}
		}else {
			return new StateAndMsg(-1, "流向表id不能为空");
		}	
		}else {
			return new StateAndMsg(-1,"参数有误！");
		}
		
	}

	@Override
	public void delete(List<Integer> ids) {
		for (Integer id : ids) {
			flowCardMainRepository.delete(id);
		}
	}

	@Override
	public FlowCardMain findById(Integer id) {
		return flowCardMainRepository.findOne(id);
	}

	@Override
	public List<FlowCardMain> findByConditions(Integer pageNo, Integer pageSize, Object... objects) {
		return flowCardMainRepository.findByConditions(pageNo, pageSize, objects);
	}

	@Override
	public List<FlowCardMain> findAll() {
		return flowCardMainRepository.findAll();
	}
	
	
}