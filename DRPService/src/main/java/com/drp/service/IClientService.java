package com.drp.service;

import java.util.List;

import com.drp.dto.CategoryDto;
import com.drp.pojo.Client;
import com.drp.util.StateAndMsg;

/**
 * @author 刘江涛
 * @ClassName: IClientService
 * @Description: 业务逻辑接口：分销商
 * @date 2017年11月1日 下午2:17:54
 */
public interface IClientService {

    Client add(Client client);

    void delete(Integer id);

    void deleteByIds(List<Integer> ids);

    Client update(Client client);

    Client findOne(Integer id);

    List<Client> findAll();

    /**
     * 用于生成jsp页面的饼状图
     *
     * @return
     */
    List<CategoryDto> findByClientLevel();

}
