/**
 * 
 */
package com.drp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.drp.pojo.Inventory;

/** 
 * @ClassName: InventoryRepository 
 * @Description: 库存的持久层
 * @author 小灰灰
 * @date 2017年11月1日 下午3:28:09 
 *  
 */
public interface InventoryRepository extends org.springframework.data.jpa.repository.JpaSpecificationExecutor<Inventory>, org.springframework.data.jpa.repository.JpaRepository<Inventory, Integer> {
	
	/**
	 * 修改初始库存
	 * @param client_id 分销商id
	 * @param item_id 物料id
	 * @param InitialNum 初始库存
	 */
	@Modifying
	@Query(value = "update t_inventory set initialNum=?3 where client_id=?1 and item_id=?2",nativeQuery=true)
	void update(Integer client_id, Integer item_id, Integer InitialNum);
	
	/**
	 * 查询库存（根据分销商id和物料id）
	 * @param client_id 分销商id
	 * @param item_id 物料id
	 * @return
	 */
	@Query(value = "select * from t_inventory  where client_id=?1 and item_id=?2 ",nativeQuery = true)
	List<Inventory> findByClientIdAndItemId(Integer client_id, Integer item_id);
	
	/**
	 * 查询库存（根据初始化数量是否确认）
	 * @param isVerify 商务代表是否确认
	 * @return
	 */
	@Query("select i from Inventory i where i.isVerify=?1")
	List<Inventory> findByIsVerify(String isVerify);
	
	/**
	 * 通过分销商id 药物id  核算期id查找库存
	 * @param itemId
	 * @param clientId
	 * @param fiscalId
	 * @return
	 */
	@Query("select i from Inventory i where i.item.id=?1 and i.client.id = ?2 and i.fiscal.id = ?3")
	List<Inventory> findByIds(Integer itemId,Integer clientId,Integer fiscalId);
	
	@Query(value = "select * from t_inventory  where client_id=?1 and item_id=?2 limit ?3,?4",nativeQuery = true)
	List<Inventory> pageByClientId(Integer clientId,Integer itemId,Integer currentPage,Integer pageSize);
}
