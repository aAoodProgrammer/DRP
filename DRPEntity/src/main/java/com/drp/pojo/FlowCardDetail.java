package com.drp.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 
 * @ClassName: FlowCardDetail 
 * @Description: 实体：流向单详情
 * @author 刘江涛
 * @date 2017年11月7日 上午11:45:59 
 *
 */
@Entity
@Table(name="t_flowCardDetail")
public class FlowCardDetail implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;			//流向单详情
	@Column(length=12,nullable=false)
	private Integer oprateNum;	//操作数量
	@Column(length=12)
	private Integer adjustNum;	//调整数量
	@Column(length=30)
	private String adjustReason;//调整原因
	@Column(length=1,nullable=false)
	private String adjustFlag;//调整标识
	@Column(length=10)
	private Integer aimClientId;//目标客户的id
	@Column(length=10)
	private String clientType;//目标客户的id
	@ManyToOne()
	@JoinColumn(name="flowCardMain_Id")
	private FlowCardMain flowCardMain;//流向单主信息id
	@ManyToOne()
	@JoinColumn(name="item_id",nullable=false)
	private Item item;			//物料id
//	@ManyToOne()
//	@JoinColumn(name="aimClient_Id",nullable=false)
//	private EndClient endClient;//终端客户id
	public FlowCardDetail() {}
	
	public FlowCardDetail(Integer id, Integer oprateNum, Integer adjustNum, String adjustReason, String adjustFlag) {
		super();
		this.id = id;
		this.oprateNum = oprateNum;
		this.adjustNum = adjustNum;
		this.adjustReason = adjustReason;
		this.adjustFlag = adjustFlag;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOprateNum() {
		return oprateNum;
	}
	public void setOprateNum(Integer oprateNum) {
		this.oprateNum = oprateNum;
	}
	public Integer getAdjustNum() {
		return adjustNum;
	}
	public void setAdjustNum(Integer adjustNum) {
		this.adjustNum = adjustNum;
	}
	public String getAdjustReason() {
		return adjustReason;
	}
	public void setAdjustReason(String adjustReason) {
		this.adjustReason = adjustReason;
	}
	public String getAdjustFlag() {
		return adjustFlag;
	}
	public void setAdjustFlag(String adjustFlag) {
		this.adjustFlag = adjustFlag;
	}
	public FlowCardMain getFlowCardMain() {
		return flowCardMain;
	}
	public void setFlowCardMain(FlowCardMain flowCardMain) {
		this.flowCardMain = flowCardMain;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Integer getAimClientId() {
		return aimClientId;
	}
	public void setAimClientId(Integer aimClientId) {
		this.aimClientId = aimClientId;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	@Override
	public String toString() {
		return "FlowCardDetail [id=" + id + ", oprateNum=" + oprateNum + ", adjustNum=" + adjustNum + ", adjustReason="
				+ adjustReason + ", adjustFlag=" + adjustFlag + ", aimClientId=" + aimClientId + "]";
	}
	
	
}	
