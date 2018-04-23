package com.drp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.drp.pojo.Fiscal;
import com.drp.repository.FiscalRepository;
import com.drp.service.IFiscalService;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

/**
 * @author 刘江涛
 * @ClassName: FiscalService
 * @Description:业务逻辑层实体：审核
 * @date 2017年11月7日 上午10:40:56
 */
@Service
public class FiscalService implements IFiscalService {

    @Resource
    private FiscalRepository fiscalRepository;

    @Override
    public Fiscal add(Fiscal fiscal) {
        Fiscal saveAndFlush = fiscalRepository.saveAndFlush(fiscal);
        if (saveAndFlush == null)
            return null;
        return saveAndFlush;
    }

    @Override
    public void delete(Integer id) {
        fiscalRepository.delete(id);
    }

    public void deleteByIds(List<Integer> ids) {
        for (Integer id : ids) {
            fiscalRepository.delete(id);
        }
    }

    @Override
    public Fiscal update(Fiscal fiscal) {
        Fiscal saveAndFlush = fiscalRepository.saveAndFlush(fiscal);
        if (saveAndFlush == null)
            return null;
        return saveAndFlush;
    }

    @Override
    public Fiscal findOne(Integer id) {
        Fiscal fiscal = fiscalRepository.findOne(id);
        if (fiscal == null)
            return null;
        return fiscal;
    }

    @Override
    public List<Fiscal> findAll() {
        List<Fiscal> fiscals = fiscalRepository.findAll();
        boolean empty = CollectionUtils.isEmpty(fiscals);
        if (empty)
            return null;
        return fiscals;
    }
}
