package com.drp.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.drp.pojo.FlowCardMain;

import java.lang.String;
import java.util.Date;
import java.util.List;

/**
 * @author 刘江涛
 * @ClassName: FlowCardMainRepository
 * @Description: 流向单主信息持久层
 * @date 2017年11月1日 下午3:25:55
 */
public interface FlowCardMainRepository extends org.springframework.data.jpa.repository.JpaSpecificationExecutor<FlowCardMain>, org.springframework.data.jpa.repository.JpaRepository<FlowCardMain, Integer> {

    /**
     * 保存分销商的id
     *
     * @param client_id
     */
    @Query( value = "insert into t_flowcardmain (client_id) values(?)", nativeQuery = true )
    void saveClientId(Integer client_id);

    /**
     * 更新主菜单信息
     * 供方分销商id, 主键
     *
     * @param client_id
     * @param id
     */
    @Modifying
    @Query( value = "update t_flowcardmain set client_id = ?1 where id = ?2", nativeQuery = true )
    void update(Integer client_id, Integer id);

    /**
     * 通过流向单单号进项查询
     *
     * @param flowcardnum
     * @return
     */
    @Query( "select fm from FlowCardMain fm where fm.flowCardNum = ?1" )
    FlowCardMain findByFlowCardNum(String flowcardnum);

    @Query( "select fcm from FlowCardMain fcm where fcm.status =0" )
    List<FlowCardMain> findAllByStatus0();

    @Query( "select fcm from FlowCardMain fcm where fcm.status =1" )
    List<FlowCardMain> findAllByStatus01();

    @Query( "select fcm from FlowCardMain fcm where fcm.status =2" )
    List<FlowCardMain> findAllByStatus02();

    @Query( "select fcm from FlowCardMain fcm where fcm.recoedDate>=?1 and fcm.recoedDate<=?2 and fcm.status=0" )
    List<FlowCardMain> findAllByTime(Date beginDate, Date endDate);

    @Query( "select fcm from FlowCardMain fcm where  fcm.clientId=?1 and fcm.status=0" )
    List<FlowCardMain> findAllByClientId(Integer clientId);

    @Query( "select fcm from FlowCardMain fcm where fcm.recoedDate>=?1 and fcm.recoedDate<=?2 and fcm.clientId=?3 and fcm.status=0" )
    List<FlowCardMain> findAllByTimeAndClientId(Date beginDate, Date endDate, Integer clientId);

    @Query( "select fcm from FlowCardMain fcm where fcm.recoedDate>=?1 and fcm.recoedDate<=?2 and fcm.status=1" )
    List<FlowCardMain> findAllByTime1(Date beginDate, Date endDate);

    @Query( "select fcm from FlowCardMain fcm where  fcm.clientId=?1 and fcm.status=1" )
    List<FlowCardMain> findAllByClientId1(Integer clientId);

    @Query( "select fcm from FlowCardMain fcm where fcm.recoedDate>=?1 and fcm.recoedDate<=?2 and fcm.clientId=?3 and fcm.status=1" )
    List<FlowCardMain> findAllByTimeAndClientId1(Date beginDate, Date endDate, Integer clientId);
}
