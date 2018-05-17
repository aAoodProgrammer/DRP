package com.drp.service;

import com.drp.pojo.EndClient;

import java.util.List;

/** 
* @ClassName: IEndClientService 
* @Description: 业务逻辑层接口：终端客户
* @author 刘江涛
* @date 2017年11月6日 下午4:37:27 
*  
*/
public interface IEndClientService {
    EndClient add(EndClient endClient);

    void delete(Integer id);

    void deleteByIds(List<Integer> ids);

    EndClient update(EndClient endClient);

    EndClient findOne(Integer id);

    List<EndClient> findAll();

}
