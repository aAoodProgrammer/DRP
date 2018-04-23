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
 * @author 刘江涛
 * @ClassName: FlowCardMainService
 * @Description: 业务逻辑层实体：流向单
 * @date 2017年11月7日 上午10:42:04
 */
@Service
public class FlowCardMainService implements IFlowCardMainService {

    @Resource
    private FlowCardMainRepository flowCardMainRepository;


    @Override
    public FlowCardMain add(FlowCardMain flowCardMain) {
        FlowCardMain saveAndFlush = flowCardMainRepository.saveAndFlush(flowCardMain);
        if (saveAndFlush == null)
            return null;
        return saveAndFlush;
    }

    @Override
    public void delete(Integer id) {
        flowCardMainRepository.delete(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        for (Integer id : ids) {
            flowCardMainRepository.delete(id);
        }
    }


    @Override
    public FlowCardMain update(FlowCardMain flowCardMain) {
        FlowCardMain saveAndFlush = flowCardMainRepository.saveAndFlush(flowCardMain);
        if (saveAndFlush == null)
            return null;
        return saveAndFlush;
    }

    @Override
    public FlowCardMain findOne(Integer id) {
        FlowCardMain flowCardMain = flowCardMainRepository.findOne(id);
        if (flowCardMain == null)
            return null;
        return flowCardMain;
    }

    @Override
    public List<FlowCardMain> findAll() {
        List<FlowCardMain> flowCardMains = flowCardMainRepository.findAll();
        if (flowCardMains == null)
            return null;
        return flowCardMains;
    }
}