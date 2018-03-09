package com.drp.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/** 
* @ClassName: BaseRepository 
* @Description: TODO
* @author 小灰灰
* @date 2017年11月3日 下午8:38:37 
*  
*/

public class BaseService <T> {
	/**
	 * 按条件查询并分页
	 * @param pageNo 当前的页码数.页码从1开始，不能小于1
	 * @param pageSize 每页显示的数据条数. 每页线束的数据条数不能小于等于0
	 * @param repository 持久层的一个接口对象
	 * @param objects 查询条件，如：按用户名username和用户代码userCode查找并显示第一页的内容每页显示5条数据就输入：
	 * 				(1,5,JpaSpecificationExecutor<T>,"username",用户名查询的条件,"userCode",用户代码的查询条件)
	 * @return Page<T> 
	 * @throws IllegalArgumentException 当pageNo小于1时抛出异常信息：当前的页码不能小于1
	 * 									当pageSize小于1时抛出异常信息：每页线束的数据条数不能小于等于0
	 */
	public Page<T> findByConditions(Integer pageNo, Integer pageSize, JpaSpecificationExecutor<T> object, final Object...objects){
		
		PageRequest pageable = new PageRequest(pageNo-1, pageSize);
		Specification<T> specification = new Specification<T>() {
			
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				int length = objects.length;
				for (int i = 0; i < length-1; i+=2) {
					if(null != objects[i] ){
	                    predicates.add(cb.equal(root.get((String)objects[i]), objects[i+1]));
	                }
				}
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
		Page<T> page = object.findAll(specification, pageable);
		return page;
	}
}
