/**
 *
 */
package com.drp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.drp.pojo.Inventory;

/**
 * @author 刘江涛
 * @ClassName: InventoryRepository
 * @Description: 库存的持久层
 * @date 2017年11月1日 下午3:28:09
 */
public interface InventoryRepository extends org.springframework.data.jpa.repository.JpaSpecificationExecutor<Inventory>, org.springframework.data.jpa.repository.JpaRepository<Inventory, Integer> {

    /**
     * 查询库存（根据初始化数量是否确认）
     *
     * @param isVerify 商务代表是否确认
     * @return
     */
    @Query("select i from Inventory i where i.isVerify=?1")
    List<Inventory> findByIsVerify(String isVerify);


    @Query(value = "select * from t_inventory  where client_id=?1 and item_id=?2 limit ?3,?4", nativeQuery = true)
    List<Inventory> pageByClientId(Integer clientId, Integer itemId, Integer currentPage, Integer pageSize);
}
