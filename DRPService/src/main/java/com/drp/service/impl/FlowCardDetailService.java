package com.drp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drp.pojo.FlowCardDetail;
import com.drp.repository.FlowCardDetailRepository;
import com.drp.service.IFlowCardDetailService;
import com.drp.util.StateAndMsg;

/** 
* @ClassName: FlowCardDetailService 
* @Description: 业务逻辑层实体：流向单详情
* @author 王春
* @date 2017年11月7日 上午10:41:44 
*  
*/
@Service
public class FlowCardDetailService implements IFlowCardDetailService{
	@Autowired
	private FlowCardDetailRepository flowCardDetailRepository=null;
	@Override
	public StateAndMsg add(FlowCardDetail t) {
		if(t!=null) {
			flowCardDetailRepository.save(t);
			return new StateAndMsg(-1, "参数有误！");
		}else {
			return new StateAndMsg(-1, "参数有误！");
		}
	}

	@Override
	public StateAndMsg update(FlowCardDetail t) {
		if(t!=null) {
			if(t.getId()!=null) {
				flowCardDetailRepository.save(t);
				return new StateAndMsg(1, "修改成功！");
			}else {
					return new StateAndMsg(-1, "参数有误！");
			}
		}else {
			return new StateAndMsg(-1, "参数有误！");
		}
	}

	@Override
	public void delete(List<Integer> ids) {
		for (Integer id : ids) {
			flowCardDetailRepository.delete(id);
		}
	}

	@Override
	public FlowCardDetail findById(Integer id) {
		return flowCardDetailRepository.findOne(id);
	}

	@Override
	public List<FlowCardDetail> findByConditions(Integer pageNo, Integer pageSize, Object... objects) {
		return flowCardDetailRepository.findByConditions(pageNo, pageSize, objects);
	}

	@Override
	public List<FlowCardDetail> findAll() {
		return flowCardDetailRepository.findAll();
	}
	
}
