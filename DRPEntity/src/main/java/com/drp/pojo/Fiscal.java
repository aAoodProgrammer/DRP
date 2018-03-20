package com.drp.pojo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 
 * @ClassName: Fiscal 
 * @Description: 实体：会计核算期
 * @author 刘江涛
 * @date 2017年11月7日 上午11:44:29 
 *
 */
@Entity
@Table(name="t_fiscalPeriod")
public class Fiscal implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;			//主键id	
	@Column(length=4)
	private String fiscalYear;	//审核年份
	@Column(length=2)
	private String fiscalPeriod;//审核月份
	private String beginDate;	//开始时间
	private String endDate;		//结束时间
	@Column(length=1,nullable=false)
//	@Enumerated(EnumType.STRING)
	private String periodflag;	//审核标识是否可用
	@OneToMany(mappedBy="fiscal")
	private Set<FlowCardMain> flowCardMains;//流向单主信息 一对多
	@OneToMany(mappedBy="fiscal")
	private Set<Inventory> inventories;		//库存
	
	public Fiscal() {}
	
	public Fiscal(Integer id, String fiscalYear, String fiscalPeriod, String beginDate, String endDate,
			String periodflag) {
		super();
		this.id = id;
		this.fiscalYear = fiscalYear;
		this.fiscalPeriod = fiscalPeriod;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.periodflag = periodflag;
	}

	public Fiscal(Integer id, String fiscalYear, String fiscalPeriod, String beginDate, String endDate, String periodflag,
			Set<FlowCardMain> flowCardMains, Set<Inventory> inventories) {
		super();
		this.id = id;
		this.fiscalYear = fiscalYear;
		this.fiscalPeriod = fiscalPeriod;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.periodflag = periodflag;
		this.flowCardMains = flowCardMains;
		this.inventories = inventories;
	}

	public Set<Inventory> getInventories() {
		return inventories;
	}
	public void setInventories(Set<Inventory> inventories) {
		this.inventories = inventories;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFiscalYear() {
		return fiscalYear;
	}
	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}
	public String getFiscalPeriod() {
		return fiscalPeriod;
	}
	public void setFiscalPeriod(String fiscalPeriod) {
		this.fiscalPeriod = fiscalPeriod;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPeriodflag() {
		return periodflag;
	}
	public void setPeriodflag(String periodflag) {
		this.periodflag = periodflag;
	}
	public Set<FlowCardMain> getFlowCardMains() {
		return flowCardMains;
	}
	public void setFlowCardMains(Set<FlowCardMain> flowCardMains) {
		this.flowCardMains = flowCardMains;
	}

	@Override
	public String toString() {
		return "Fiscal [id=" + id + ", fiscalYear=" + fiscalYear + ", fiscalPeriod=" + fiscalPeriod + ", beginDate="
				+ beginDate + ", endDate=" + endDate + ", periodflag=" + periodflag + "]";
	}
	
}
