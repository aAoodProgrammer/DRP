package com.drp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drp.pojo.Fiscal;
import com.drp.repository.FiscalRepository;
import com.drp.service.IFiscalService;
import com.drp.util.StateAndMsg;

/**
 * @ClassName: FiscalService
 * @Description:业务逻辑层实体：审核
 * @author 王春
 * @date 2017年11月7日 上午10:40:56
 * 
 */
@Service
public class FiscalService implements IFiscalService {
	@Autowired
	private FiscalRepository fiscalRepository = null;

	@Override
	public StateAndMsg add(Fiscal t) {
		if (t != null) {
			fiscalRepository.save(t);
			return new StateAndMsg(1, "添加成功！");
		} else {
			return new StateAndMsg(-1, "参数有误！");
		}
	}

	@Override
	public StateAndMsg update(Fiscal t) {
		if (t != null) {
			if (t.getId() != null) {
				return new StateAndMsg(1, "修改成功！");
			} else {
				return new StateAndMsg(-1, "参数有误！");
			}

		} else {
			return new StateAndMsg(-1, "参数有误！");
		}
	}

	@Override
	public void delete(List<Integer> ids) {
		for (Integer id : ids) {
			fiscalRepository.delete(id);
		}
	}

	@Override
	public Fiscal findById(Integer id) {
		return fiscalRepository.findOne(id);
	}


	@Override
	public List<Fiscal> findAll() {
		return fiscalRepository.findAll();
	}

}
