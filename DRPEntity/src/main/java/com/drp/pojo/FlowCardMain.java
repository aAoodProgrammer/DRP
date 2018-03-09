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
 * 
 * @ClassName: FlowCardMain 
 * @Description: 实体：流向单主信息
 * @author zyl
 * @date 2017年11月7日 上午11:46:25 
 *
 */
@Entity
@Table(name="t_flowCardMain")
public class FlowCardMain implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;			//流向单主键
	@Column(length=1,nullable=false)
	private String flowCardNum;	//流向单单号
	@Column(length=1,nullable=false)
	private String operateType;	//审核标记
	@Temporal(TemporalType.TIMESTAMP)
	private Date recoedDate;	//录入时间
	@Column(length=1,nullable=false)
	private String spotDescribe;//抽查结果描述
	@Temporal(TemporalType.TIMESTAMP)
	private Date adjustData;	//调整时间
	@Temporal(TemporalType.TIMESTAMP)
	private Date spotDate;		//抽查时间
	@Column(length=40)
	private String spotMark;	//抽查标记
	@Temporal(TemporalType.TIMESTAMP)
	private Date reviewDate;	//复审时间
	@OneToOne()
	@JoinColumn(name="recoederId",nullable=false)
	private User recoeder;		//记录人
	@OneToOne()
	@JoinColumn(name="adjusterId",nullable=false)
	private User adjuster;		//调整人
	@OneToOne()
	@JoinColumn(name="spoterId")
	private User spoter;		//抽查人
	@OneToOne()
	@JoinColumn(name="reviewerId")
	private User reviewer;		//复审人
	@OneToOne()
	@JoinColumn(name="client_id",nullable=false)
	private Client client;		//分销商
	@ManyToOne()
	@JoinColumn(name="fiscal_id",nullable=false)
	private Fiscal fiscal;		//审核周期
	@OneToMany(mappedBy="flowCardMain")
	private Set<FlowCardDetail> flowCardDetails;		//流向单详情
	
	public FlowCardMain() {}
	
	public FlowCardMain(Integer id, String flowCardNum, String operateType, Date recoedDate, String spotDescribe,
			Date adjustData, Date spotDate, String spotMark, Date reviewDate, User recoeder, User adjuster, User spoter,
			User reviewer, Client client, Fiscal fiscal) {
		super();
		this.id = id;
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
		this.client = client;
		this.fiscal = fiscal;
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
	public String getspotDescribe() {
		return spotDescribe;
	}
	public void setspotDescribe(String spotDescribe) {
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
	public User getRecoeder() {
		return recoeder;
	}
	public void setRecoeder(User recoeder) {
		this.recoeder = recoeder;
	}
	public User getAdjuster() {
		return adjuster;
	}
	public void setAdjuster(User adjuster) {
		this.adjuster = adjuster;
	}
	public User getSpoter() {
		return spoter;
	}
	public void setSpoter(User spoter) {
		this.spoter = spoter;
	}
	public User getReviewer() {
		return reviewer;
	}
	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
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
	
	@Override
	public String toString() {
		return "FlowCardMain [id=" + id + ", operateType=" + operateType + ", recoedDate=" + recoedDate + ", spotDescribe="
				+ spotDescribe + ", adjustData=" + adjustData + ", spotDate=" + spotDate + ", spotMark=" + spotMark
				+ ", reviewDate=" + reviewDate + ", recoeder=" + recoeder + ", adjuster=" + adjuster + ", spoter="
				+ spoter + ", reviewer=" + reviewer + ", client=" + client + ", fiscal=" + fiscal + "]";
	}
	
}
