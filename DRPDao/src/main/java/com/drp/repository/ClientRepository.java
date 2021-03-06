package com.drp.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.drp.pojo.Client;

/**
 * @author 刘江涛
 * @ClassName: ClientRepository
 * @Description: 分销商持久层
 * @date 2017年11月1日 下午3:25:42
 */
@Repository
public interface ClientRepository extends org.springframework.data.jpa.repository.JpaSpecificationExecutor<Client>, org.springframework.data.jpa.repository.JpaRepository<Client, Integer> {

    /**
     * 通过上一级通过上一级分销商（区域）id进行查找
     *
     * @param upperId
     * @return
     */
    @Query( value = "SELECT * FROM t_client WHERE upperId = ?", nativeQuery = true )
    List<Client> queryByUpperId(Integer upperId);

    /**
     * 分销商名称  分销商级别  银行帐号 联系电话 地址 邮编
     *
     * @param name
     * @param level_id
     * @param bankCardNum
     * @param address
     * @param contactTel
     * @param zipCode
     * @param zipCode     id
     */
    @Modifying
    @Query( value = "update t_client set name = ?1, level_id =?2, bankCardNum = ?3, address = ?4, contactTel = ?5, zipCode = ?6 where id = ?7", nativeQuery = true )
    void updateClient(String name, Integer level_id, String bankCardNum, String address, String contactTel, String zipCode, Integer id);

    /**
     * 修改区域名称
     *
     * @param name
     * @param id
     */
    @Modifying
    @Query( value = "update t_client set name = ?1 where id = ?2", nativeQuery = true )
    void updateArea(String name, Integer id);

    /**
     * 查询分销商
     * 通过分销商的代码或名字进行模糊查询
     *
     * @return
     */
    @Query( "select c from Client c where c.code like concat('%',?1,'%') or c.name like concat('%',?1,'%')" )
    List<Client> queryLikeNoOrName(String codeName);

    /**
     * 通过id进行查找
     *
     * @param id
     * @return
     */
    @Query( "select c from Client c where c.id = ?1" )
    Client findById(Integer id);

    @Query( "select c from Client c where c.name = ?1" )
    Client findAllByName(String name);

    /**
     * 通过代码进行查找
     *
     * @param code
     * @return
     */
    @Query( "select c from Client c where c.code = ?1" )
    Client findByCode(String code);
}


