/**
 * 
 */
package com.drp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.drp.pojo.Item;

/** 
 * @ClassName: ItemRepository 
 * @Description: 物料的持久层
 * @author 小灰灰
 * @date 2017年11月1日 下午3:31:13 
 *  
 */
public interface ItemRepository extends BaseRepository<Item,Integer> {
	
	/**
	 * 修改物料（根据物料代码）
	 * @param name 物料名称
	 * @param specification	物料规格
	 * @param modelNum 物料型号
	 * @param itemType_id 类别
	 * @param unitType_id 计量单位
	 * @param code 物料代码
	 */
	@Modifying
	@Query(value = "update t_item i set i.name=?1, i.specification=?2, i.modelNum=?3, i.itemType_id=?4, i.unitType_id=?5 where i.code=?6",nativeQuery = true)
	void updateItem(String name, String specification, String modelNum, Integer itemType_id, Integer unitType_id, String code);
	
	/**
	 * 修改物料（根据物料id）
	 * @param name 物料名称
	 * @param specification	物料规格
	 * @param modelNum 物料型号
	 * @param itemType_id 类别
	 * @param unitType_id 计量单位
	 * @param id 物料id
	 */
	@Modifying
	@Query(value = "update t_item i set i.name=?1, i.specification=?2, i.modelNum=?3, i.itemType_id=?4, i.unitType_id=?5 where i.id=?6",nativeQuery = true)
	void updateItem(String name, String specification, String modelNum, Integer itemType_id, Integer unitType_id, Integer id);
	
	/**
	 * 上传物料样品图片
	 * @param simplePhoto 样品图片
	 * @param id 物料id
	 */
	@Modifying
	@Query("update Item i set i.simplePhoto=?1 where i.id=?2")
	void upLoadPic(String simplePhoto, Integer id);
	
	/**
	 * 上传物料样品图片
	 * @param simplePhoto 样品图片
	 * @param code 物料代码
	 */
	@Modifying
	@Query("update Item i set i.simplePhoto=?1 where i.code=?2")
	void upLoadPic(String simplePhoto, String code);
	
	/**
	 * 通过用户名和代码进行查询
	 * @param nameCode
	 * @return
	 */
	@Query("select i from Item i where i.code like concat('%',?1,'%') or i.name like concat('%',?1,'%')")
	List<Item> findLikeNameCode(String nameCode);
	
//	@Query("select i from Item i where i.name = ?1")
//	List<Item> findByName(String name);
	/**
	 * 通过物料代码进行查询
	 * @param code
	 * @return
	 */
	@Query("select i from Item i where i.code = ?1")
	List<Item> findByCode(String code);
}
