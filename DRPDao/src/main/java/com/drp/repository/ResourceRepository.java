/**
 * 
 */
package com.drp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.drp.pojo.Resource;
import java.lang.Integer;

/** 
 * @ClassName: ResourceRepository 
 * @Description: 资源持久层
 * @author 刘江涛
 * @date 2017年11月1日 下午3:18:42 
 *  
 */

public interface ResourceRepository extends org.springframework.data.jpa.repository.JpaSpecificationExecutor<Resource>, org.springframework.data.jpa.repository.JpaRepository<Resource, Integer> {
	
	/**
	 * 修改资源url
	 * @param id 资源id
	 * @param url 资源url
	 */
	@Modifying
	@Query("update Resource r set r.name=?2,r.url=?3 where r.id=?1")
	void updateResource(Integer id,String name, String url);
	
	/**
	 * 通过菜单id查找资源
	 */
	@Query("select r from Resource r where r.menu.id = ?1")
	List<Resource> findByMenuId(Integer menu_id);
	
	@Query("select r from Resource r where r.name = ?1")
	Resource findByName(String name);
	
}
