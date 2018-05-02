package com.drp.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author 刘江涛
 * @ClassName: FlowCardMain
 * @Description: 实体：流向单主信息
 * @date 2017年11月7日 上午11:46:25
 */
@Entity
@Table(name = "t_flowCardMain")
public class FlowCardMain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;            //流向单主键

    @Column(length = 1, nullable = false)
    private String flowCardNum;    //流向单单号

    @Column(length = 1, nullable = false)
    private String operateType;    //审核标记

    @Temporal(TemporalType.TIMESTAMP)
    private Date recoedDate;    //录入时间

    @Column(length = 1, nullable = false)
    private String spotDescribe;//抽查结果描述

    @Temporal(TemporalType.TIMESTAMP)
    private Date adjustData;    //调整时间

    @Temporal(TemporalType.TIMESTAMP)
    private Date spotDate;        //抽查时间

    @Column(length = 40)
    private String spotMark;    //抽查标记

    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewDate;    //复审时间

    @Column(name = "recoederId")
    private Integer recoeder;        //记录人

    @Column(name = "adjusterId")
    private Integer adjuster;        //调整人

    @Column(name = "spoterId")
    private Integer spoter;        //抽查人

    @Column(name = "reviewerId")
    private Integer reviewer;        //复审人

    @Column(name = "client_id")
    private Integer clientId;        //分销商

    private Integer status;         //0初始态，1审核中，2审核通过

    @JoinColumn(name = "fiscal_id")
    private Fiscal fiscal;        //审核周期

    @OneToMany(mappedBy = "flowCardMain")
    private Set<FlowCardDetail> flowCardDetails;        //流向单详情

    public FlowCardMain() {
    }

    public FlowCardMain(String flowCardNum, String operateType, Date recoedDate, String spotDescribe, Date adjustData, Date spotDate, String spotMark, Date reviewDate, Integer recoeder, Integer adjuster, Integer spoter, Integer reviewer, Integer clientId, Fiscal fiscal, Set<FlowCardDetail> flowCardDetails) {
        this.flowCardNum = flowCardNum;
        this.operateType = operateType;
        this.recoedDate = recoedDate;
        this.spotDescribe = spotDescribe;
        this.adjustData = adjustData;
        this.spotDate = spotDate;
        this.spotMark = spotMark;
        this.reviewDate = reviewDate;
        this.recoeder = recoeder;
        this.adjuster = adjuster;
        this.spoter = spoter;
        this.reviewer = reviewer;
        this.clientId = clientId;
        this.fiscal = fiscal;
        this.flowCardDetails = flowCardDetails;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlowCardNum() {
        return flowCardNum;
    }

    public void setFlowCardNum(String flowCardNum) {
        this.flowCardNum = flowCardNum;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public Date getRecoedDate() {
        return recoedDate;
    }

    public void setRecoedDate(Date recoedDate) {
        this.recoedDate = recoedDate;
    }

    public String getSpotDescribe() {
        return spotDescribe;
    }

    public void setSpotDescribe(String spotDescribe) {
        this.spotDescribe = spotDescribe;
    }

    public Date getAdjustData() {
        return adjustData;
    }

    public void setAdjustData(Date adjustData) {
        this.adjustData = adjustData;
    }

    public Date getSpotDate() {
        return spotDate;
    }

    public void setSpotDate(Date spotDate) {
        this.spotDate = spotDate;
    }

    public String getSpotMark() {
        return spotMark;
    }

    public void setSpotMark(String spotMark) {
        this.spotMark = spotMark;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Integer getRecoeder() {
        return recoeder;
    }

    public void setRecoeder(Integer recoeder) {
        this.recoeder = recoeder;
    }

    public Integer getAdjuster() {
        return adjuster;
    }

    public void setAdjuster(Integer adjuster) {
        this.adjuster = adjuster;
    }

    public Integer getSpoter() {
        return spoter;
    }

    public void setSpoter(Integer spoter) {
        this.spoter = spoter;
    }

    public Integer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Integer reviewer) {
        this.reviewer = reviewer;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Fiscal getFiscal() {
        return fiscal;
    }

    public void setFiscal(Fiscal fiscal) {
        this.fiscal = fiscal;
    }

    public Set<FlowCardDetail> getFlowCardDetails() {
        return flowCardDetails;
    }

    public void setFlowCardDetails(Set<FlowCardDetail> flowCardDetails) {
        this.flowCardDetails = flowCardDetails;
    }
}
