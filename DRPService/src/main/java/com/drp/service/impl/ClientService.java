package com.drp.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.drp.dto.CategoryDto;
import com.drp.pojo.Category;
import com.drp.pojo.Client;
import com.drp.repository.CategoryRepository;
import com.drp.repository.ClientRepository;
import com.drp.service.IClientService;
import org.springframework.util.CollectionUtils;

/**
 * @author 刘江涛
 * @ClassName: ClientService
 * @Description: 业务逻辑层实体：分销商
 * @date 2017年11月1日 下午2:40:11
 */
@Service
public class ClientService implements IClientService {

    @Resource
    private ClientRepository clientRepository;

    @Resource
    private CategoryRepository categoryRepository;

    @Override
    public Client add(Client client) {
        Client saveAndFlush = clientRepository.saveAndFlush(client);
        if (saveAndFlush == null)
            return null;
        return saveAndFlush;
    }

    @Override
    public void delete(Integer id) {
        clientRepository.delete(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        for (Integer id : ids) {
            clientRepository.delete(id);
        }
    }

    @Override
    public Client update(Client client) {
        Client saveAndFlush = clientRepository.saveAndFlush(client);
        if (saveAndFlush == null)
            return null;
        return saveAndFlush;
    }

    @Override
    public Client findOne(Integer id) {
        Client client = clientRepository.findOne(id);
        if (client == null)
            return null;
        return client;
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = clientRepository.findAll();
        boolean empty = CollectionUtils.isEmpty(clients);
        if (empty)
            return null;
        return clients;
    }

    /**
     * 用于生成jsp页面的饼状图
     *
     * @return
     */
    public List<CategoryDto> findByClientLevel() {
        List<Category> categories = categoryRepository.findCategoryByCategory(1);
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category : categories) {
            Object ob = clientRepository.findByCategory(category.getId());
            CategoryDto categoryDtoTemp = new CategoryDto();
            categoryDtoTemp.setNum(Integer.parseInt(ob.toString()));
            categoryDtoTemp.setName(category.getName());
            categoryDtos.add(categoryDtoTemp);
        }
        return categoryDtos;
    }
}
