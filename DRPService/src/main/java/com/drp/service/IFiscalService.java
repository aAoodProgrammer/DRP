package com.drp.service;

import com.drp.pojo.Fiscal;

import java.util.List;


/**
 * @author 刘江涛
 * @ClassName: IFiscalService
 * @Description:业务逻辑接口：审核
 * @date 2017年11月6日 下午4:37:50
 */
public interface IFiscalService {
    Fiscal add(Fiscal fiscal);

    void delete(Integer id);

    void deleteByIds(List<Integer> ids);

    Fiscal update(Fiscal fiscal);

    Fiscal findOne(Integer id);

    List<Fiscal> findAll();
}
