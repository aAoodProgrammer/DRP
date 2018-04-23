package com.drp.service;

import com.drp.pojo.Category;

import java.util.List;

/**
 * @author 刘江涛
 * @ClassName: ICategoryService
 * @Description: 业务逻辑接口：静态字典
 * @date 2017年11月6日 下午4:35:23
 */
public interface ICategoryService {

    Category add(Category category);

    void delete(Integer id);

    void deleteByIds(List<Integer> ids);

    Category update(Category category);

    Category findOne(Integer id);

    List<Category> findAll();

}
