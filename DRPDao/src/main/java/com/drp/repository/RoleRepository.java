/**   
 * @Title: RoleRepository.java
 * @Package com.drp.repository 
 * @author 小灰灰	日期：2017年11月1日 
 * @version V1.0   
 */
package com.drp.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.drp.pojo.Role;
import com.drp.pojo.User;

/** 
 * @ClassName: RoleRepository 
 * @Description: 角色持久层
 * @author 小灰灰
 * @date 2017年11月1日 下午3:55:03 
 *  
 */

public interface RoleRepository extends BaseRepository<Role,Integer> {
	
	/**
	 * 更新角色名
	 * @param name 角色名
	 * @param id 角色id
	 */
	@Modifying
	@Query("update Role r set r.name=?1 where r.id=?2")
	void updateRole(String name, Integer id);
	
	/**
	 * 通过角色名称进行查找
	 * @param name
	 */
	@Query("select r from Role r where r.name=?1")
	User findByName(String name);
}
