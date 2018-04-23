package com.drp.service;

import com.drp.pojo.FlowCardDetail;

import java.util.List;

/** 
* @ClassName: IFlowCardDetailService 
* @Description: 业务逻辑接口：流向单详情
* @author 刘江涛
* @date 2017年11月6日 下午4:40:20 
*  
*/
public interface IFlowCardDetailService {
    FlowCardDetail add(FlowCardDetail flowCardDetail);

    void delete(Integer id);

    void deleteByIds(List<Integer> ids);

    FlowCardDetail update(FlowCardDetail flowCardDetail);

    FlowCardDetail findOne(Integer id);

    List<FlowCardDetail> findAll();
}
