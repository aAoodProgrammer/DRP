package com.drp.service.impl;

import org.springframework.stereotype.Service;

import com.drp.pojo.Category;
import com.drp.repository.CategoryRepository;
import com.drp.service.ICategoryService;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 刘江涛
 * @ClassName: CategoryService
 * @Description: 业务逻辑层实体：静态字典
 * @date 2017年11月7日 上午10:37:35
 */
@Service
public class CategoryService implements ICategoryService {

    @Resource
    private CategoryRepository categoryRepository;


    @Override
    public Category add(Category category) {
        Category saveAndFlush = categoryRepository.saveAndFlush(category);
        if (saveAndFlush == null)
            return null;
        return saveAndFlush;
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.delete(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        for (Integer id : ids) {
            categoryRepository.delete(id);
        }
    }

    @Override
    public Category update(Category category) {
        Category saveAndFlush = categoryRepository.saveAndFlush(category);
        if (saveAndFlush == null)
            return null;
        return saveAndFlush;
    }

    @Override
    public Category findOne(Integer id) {
        Category category = categoryRepository.findOne(id);
        if (category == null)
            return null;
        return category;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = categoryRepository.findAll();
        boolean empty = CollectionUtils.isEmpty(categories);
        if (empty)
            return null;
        return categories;
    }
}
