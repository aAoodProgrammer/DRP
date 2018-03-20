/**   
 * @Title: TypeRepository.java
 * @Package com.drp.repository 
 * @author 刘江涛	日期：2017年11月1日 
 * @version V1.0   
 */
package com.drp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.drp.pojo.Category;

/**
 * @ClassName: CategoryRepository
 * @Description: 类型（静态字典）持久层
 * @author 刘江涛
 * @date 2017年11月1日 下午3:57:42
 * 
 */

@Repository
public interface CategoryRepository extends JpaSpecificationExecutor<Category>, JpaRepository<Category, Integer> {

	@Query("select c from Category c where c.category = ?1")
	List<Category> queryByCategory(Integer category);

	@Query("select c from Category c where c.id = ?1")
	Category findById(Integer id);
	
	@Query("select c from Category c where c.category = ?1")
	List<Category> findCategoryByCategory(Integer category);
}
