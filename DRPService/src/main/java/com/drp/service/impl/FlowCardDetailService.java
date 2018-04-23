package com.drp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drp.pojo.FlowCardDetail;
import com.drp.repository.FlowCardDetailRepository;
import com.drp.service.IFlowCardDetailService;
import com.drp.util.StateAndMsg;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

/**
 * @author 刘江涛
 * @ClassName: FlowCardDetailService
 * @Description: 业务逻辑层实体：流向单详情
 * @date 2017年11月7日 上午10:41:44
 */
@Service
public class FlowCardDetailService implements IFlowCardDetailService {

    @Resource
    private FlowCardDetailRepository flowCardDetailRepository;

    @Override
    public FlowCardDetail add(FlowCardDetail flowCardDetail) {
        FlowCardDetail saveAndFlush = flowCardDetailRepository.saveAndFlush(flowCardDetail);
        if (saveAndFlush == null)
            return null;
        return saveAndFlush;
    }

    @Override
    public void delete(Integer id) {
        flowCardDetailRepository.delete(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        for (Integer id : ids) {
            flowCardDetailRepository.delete(id);
        }
    }

    @Override
    public FlowCardDetail update(FlowCardDetail flowCardDetail) {
        FlowCardDetail saveAndFlush = flowCardDetailRepository.saveAndFlush(flowCardDetail);
        if (saveAndFlush == null)
            return null;
        return saveAndFlush;
    }

    @Override
    public FlowCardDetail findOne(Integer id) {
        FlowCardDetail flowCardDetail = flowCardDetailRepository.findOne(id);
        if (flowCardDetail == null)
            return null;
        return flowCardDetail;
    }

    @Override
    public List<FlowCardDetail> findAll() {
        List<FlowCardDetail> flowCardDetails = flowCardDetailRepository.findAll();
        boolean empty = CollectionUtils.isEmpty(flowCardDetails);
        if (empty)
            return null;
        return flowCardDetails;
    }
}
