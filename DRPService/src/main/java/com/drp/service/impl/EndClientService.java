package com.drp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.drp.pojo.EndClient;
import com.drp.repository.EndClientRepository;
import com.drp.service.IEndClientService;
import com.drp.util.StateAndMsg;
import org.springframework.util.CollectionUtils;

/**
 * @author 刘江涛
 * @ClassName: EndClientService
 * @Description: 业务逻辑层实体：终端客户
 * @date 2017年11月7日 上午10:40:28
 */
@Service
public class EndClientService implements IEndClientService {

    @Resource
    private EndClientRepository endClientRepository;

    @Override
    public EndClient add(EndClient endClient) {
        EndClient saveAndFlush = endClientRepository.saveAndFlush(endClient);
        if (saveAndFlush == null)
            return null;
        return saveAndFlush;
    }

    @Override
    public void delete(Integer id) {
        endClientRepository.delete(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        for (Integer id : ids) {
            endClientRepository.delete(id);
        }
    }

    @Override
    public EndClient update(EndClient endClient) {
        EndClient saveAndFlush = endClientRepository.saveAndFlush(endClient);
        if (saveAndFlush == null)
            return null;
        return saveAndFlush;
    }

    @Override
    public EndClient findOne(Integer id) {
        EndClient endClient = endClientRepository.findOne(id);
        if (endClient == null)
            return null;
        return endClient;
    }

    @Override
    public List<EndClient> findAll() {
        List<EndClient> endClients = endClientRepository.findAll();
        boolean empty = CollectionUtils.isEmpty(endClients);
        if (empty)
            return null;
        return endClients;
    }
}
