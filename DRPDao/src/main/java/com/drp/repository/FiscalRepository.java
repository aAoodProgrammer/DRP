/**
 *
 */
package com.drp.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.drp.pojo.Fiscal;

/**
 * @author 刘江涛
 * @ClassName: FiscalRepository
 * @Description: 会计核算持久层
 * @date 2017年11月1日 下午3:33:38
 */
public interface FiscalRepository extends org.springframework.data.jpa.repository.JpaSpecificationExecutor<Fiscal>, org.springframework.data.jpa.repository.JpaRepository<Fiscal, Integer> {

    /**
     * 修改会计维护期
     * 审核年 审核月 开始时间 结束时间 是否可用   主键id
     *
     * @param fiscalYear
     * @param fiscalPeriod
     * @param beginDate
     * @param endDate
     * @param periodflag
     * @param id
     */
    @Modifying
    @Query(value = "update Fiscal f set f.fiscalYear = ?1, fiscalPeriod =?2, beginDate = ?3, endDate = ?4, periodflag = ?5 where id = ?6")
    void updateFiscal(String fiscalYear, String fiscalPeriod, String beginDate, String endDate, String periodflag, Integer id);

//	@Query("")
//	Fiscal findFiscal();
}
