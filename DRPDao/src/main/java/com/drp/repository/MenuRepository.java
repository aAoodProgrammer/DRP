/**
 * 
 */
package com.drp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.drp.pojo.Menu;

/** 
 * @ClassName: MenuRepository 
 * @Description: 菜单的持久层
 * @author 小灰灰
 * @date 2017年11月1日 下午3:34:31 
 *  
 */
public interface MenuRepository extends org.springframework.data.jpa.repository.JpaSpecificationExecutor<Menu>, org.springframework.data.jpa.repository.JpaRepository<Menu, Integer> {
	
	/**
	 * 更新
	 * @param name
	 * @param id
	 */
	@Modifying
	@Query("update Menu m set m.name=?1 where m.id=?2")
	void update(String name, Integer id);
	
	/**
	 * 通过上一级菜单的id进行查找
	 * @param menuId
	 * @return
	 */
	@Query("select m from Menu m where m.menu.id=?1")
	List<Menu> findByUpperId(Integer menuId);
	/**
	 * 通过菜单的名字进行模糊
	 * @return
	 */
	@Query("select m from Menu m where m.name like concat('%',?1,'%')")
	List<Menu> findLikeName(String name);
	
	/**
	 * 通过菜单的名字进行查询
	 * @return
	 */
	@Query("select m from Menu m where m.name=?1")
	Menu findByName(String name);
}
