package com.drp.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.drp.pojo.FlowCardDetail;

/** 
 * @ClassName: FlowCardDetailRepository 
 * @Description: 流向单详情持久层
 * @author 刘江涛
 * @date 2017年11月1日 下午3:43:58 
 *  
 */
public interface FlowCardDetailRepository extends org.springframework.data.jpa.repository.JpaSpecificationExecutor<FlowCardDetail>, org.springframework.data.jpa.repository.JpaRepository<FlowCardDetail, Integer> {
	
	/**
	 * 保存流向单详细信息（目标客户的id）
	 * @param aimClientId
	 * @param item_id
	 * @param oprateNum
	 */
	@Query(value="insert into t_flowcarddetail (aimClientId,clientType,item_id,oprateNum) values(?1,?2,?3,?4)",nativeQuery=true)
	void saveProperty(Integer aimClientId,String clientType,Integer item_id,Integer oprateNum);
	/**
	 * 更新流向单详情
	 * 目标id
	 * @param aimClientId
	 * @param clientType
	 * @param item_id
	 */
	@Modifying
	@Query(value="update  t_flowcarddetail set aimClientId = ?1, clientType = ?2, item_id = ?3, adjustNum = ?4 where id = ?5", nativeQuery = true)
	void update(Integer aimClientId,String clientType,Integer item_id,Integer adjustNum, Integer id);
	
	/**
	 * 
	 * @param flowMainId
	 */
	@Modifying
	@Query(value="update  t_flowcarddetail set flowCardMain_id = null where flowCardMain_id = ?1", nativeQuery = true)
	void updateFlowMainNull(Integer flowMainId);
	/**
	 * 通过主流向单查询流向单详情
	 * @param floeCardMainId
	 */
	@Query(value="select * from t_flowcarddetail where flowCardMainId = ?", nativeQuery = true)
	void queryByMainId(Integer floeCardMainId);
	
}
