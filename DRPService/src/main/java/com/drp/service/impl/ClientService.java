package com.drp.service.impl;
/**
 * 
* @ClassName: ClientService 
* @Description: 业务逻辑层实体：分销商
* @author 刘江涛
* @date 2017年11月1日 下午2:40:11 
*
 */

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
import com.drp.util.StateAndMsg;
@Service
public class ClientService implements IClientService{

	@Resource
	private ClientRepository clientRepository;
	
	@Resource
	private CategoryRepository categoryRepository;
	
	@Override
	public StateAndMsg update(Client t) {
		if(t!=null) {
		if(t.getId()!=null) {
			if(t.getCode()!=null) {
				if(t.getName()!=null) {
					if(t.getLevel()!=null) {
						clientRepository.save(t);
						return new StateAndMsg(1,"分销商添加成功！");
					}else {
						return new StateAndMsg(-1,"分销商类型不能为空！");
					}
				}else {
					return new StateAndMsg(-1,"分销商名称不能为空！");
				}
			}else {
				return new StateAndMsg(-1,"分销商代码不能为空！");
			}
		}else {
			return new StateAndMsg(-1,"分销商Id不能为空！");
		}
		}else {
			return new StateAndMsg(-1,"参数有误！");
		}
	}

	/**
	 * 用于生成jsp页面的饼状图
	 * @return
	 */
	public List<CategoryDto> findByClientLevel(){
		List<Category> categorys = categoryRepository.findCategoryByCategory(1);
		List<CategoryDto> categoryDtos = new ArrayList<CategoryDto>();
		
		for (Category category : categorys) {
			Object ob = clientRepository.findByCategory(category.getId());
			CategoryDto categoryDtoTemp = new CategoryDto();
			categoryDtoTemp.setNum(Integer.parseInt(ob.toString()));
			categoryDtoTemp.setName(category.getName());
			categoryDtos.add(categoryDtoTemp);
		}
		
		return categoryDtos;
	}

	@Override
	public Object add(Client client) {
		clientRepository.save(client);
		return null;
	}

	@Override
	public void delete(List<Integer> ids) {
		for (Integer id : ids) {
			clientRepository.delete(id);
		}
	}

	@Override
	public Client findById(Integer id) {
		
		return clientRepository.findOne(id);
	}


	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	} 

	
}
