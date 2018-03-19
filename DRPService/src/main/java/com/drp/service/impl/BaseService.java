package com.drp.service.impl;


import java.io.Serializable;
import java.util.List;

import com.drp.service.IBaseService;
import com.drp.util.StateAndMsg;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 王春
 * @ClassName: BaseService
 * @Description: 业务逻辑层实体：基类
 * @date 2017年11月7日 下午1:46:22
 */
public class BaseService<T extends Serializable> implements IBaseService<T> {

    @Override
    public Object add(T t) {
        return null;
    }

    @Override
    public Object update(T t) {
        return null;
    }

    @Override
    public T findById(Integer id) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public void delete(List ids) {

    }
}
