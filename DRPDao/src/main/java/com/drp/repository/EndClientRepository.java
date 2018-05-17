package com.drp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.drp.pojo.EndClient;

/**
 * @ClassName: EndClientRepository
 * @Description: 终端客户持久层
 * @author 刘江涛
 * @date 2017年11月1日 下午3:33:09 
 *
 */
public interface EndClientRepository extends org.springframework.data.jpa.repository.JpaSpecificationExecutor<EndClient>, org.springframework.data.jpa.repository.JpaRepository<EndClient, Integer> {


    /**
     * 通过上一级通过上一级分销商（区域）id进行查找
     * @param upperId
     * @return
     */
    @Query("select ec from EndClient ec where ec.endClient.id = ?1")
    List<EndClient> queryByUpperId(Integer upperId);

    /**
     * 分销商名称  分销商级别  银行帐号 联系电话 地址 邮编
     * @param name
     * @param category_id
     * @param address
     * @param contactTel
     * @param zipCode
     * @param id
     */
    @Modifying
    @Transactional
    @Query(value = "update t_endclient set name = ?1, category_id =?2, contactorTel = ?3, address = ?4, contactTel = ?5, zipCode = ?6 where id = ?7", nativeQuery = true)
    void updateEndClient(String name, Integer category_id, String contactorTel, String address, String contactTel, String zipCode, Integer id);

    /**
     * 修改区域名称
     * @param name
     * @param id
     */
    @Modifying
    @Transactional
    @Query(value = "update t_endclient set name = ?1 where id = ?2", nativeQuery = true)
    void updateArea(String name, Integer id);

    /**
     * 查询终端客户
     * 通终端客户的代码或名字进行模糊查询
     * @param codeName
     * @return
     */
    @Query("select ec from EndClient ec where ec.code like concat('%',?1,'%') or ec.name like concat('%',?1,'%')")
    List<EndClient> queryLikeNoOrName(String codeName);

    /**
     * 通过id进行查找
     * @param id
     * @return
     */
    @Query("select ec from EndClient ec where ec.id = ?1")
    EndClient findById(Integer id);

    /**
     * 通过代码进行查找
     * @param code
     * @return
     */
    @Query("select ec from EndClient ec where ec.code = ?1")
    EndClient findByCode(String code);
}
