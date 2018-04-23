package com.drp.service;

import com.drp.pojo.FlowCardMain;

import java.util.List;

/** 
* @ClassName: IFlowCardMainService 
* @Description: 业务逻辑接口：流向单
* @author 刘江涛
* @date 2017年11月6日 下午4:40:49 
*  
*/
public interface IFlowCardMainService {
    FlowCardMain add(FlowCardMain flowCardMain);

    void delete(Integer id);

    void deleteByIds(List<Integer> ids);

    FlowCardMain update(FlowCardMain flowCardMain);

    FlowCardMain findOne(Integer id);

    List<FlowCardMain> findAll();
}
