package com.drp.service;

import com.drp.pojo.Item;

import java.util.List;

/**
 * @author 刘江涛
 * @ClassName: IItemService
 * @Description: 业务逻辑层：物料
 * @date 2017年11月1日 下午2:22:05
 */
public interface IItemService {
    Item add(Item item);

    void delete(Integer id);

    void deleteByIds(List<Integer> ids);

    Item update(Item item);

    Item findOne(Integer id);

    List<Item> findAll();
    /**
     * 图片管理
     * @param file
     */
    //public void imgManage(MultipartFile file);

}
