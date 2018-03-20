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
 * @ClassName: EndClient 
 * @Description: 实体：终端客户
 * @author 刘江涛
 * @date 2017年11月7日 上午11:44:13 
 *
 */
@Entity
@Table(name="t_endclient")
public class EndClient implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;				//终端客户主键id
	@Column(length=40,nullable=false)
	private String name;			//名字
	@Column(length=10,nullable=false)
	private String code;			//代码
	private String contactor;		//联系人
	private String contactorTel;	//联系电话
	private String address;			//地址
	private String zipCode;			//邮编
	@Column(length=1,nullable=false)
	private String IsLeaf;		//是否是叶子节点
	@Column(length=1,nullable=false)
	private String isEndClient;	//是否是终端客户
	@ManyToOne()
	@JoinColumn(name="category_id")
	private Category category;		//终端客户类型
	@ManyToOne()
	@JoinColumn(name="upperId")
	private EndClient endClient;	//上一级id
//	@OneToMany(mappedBy="endClient")
//	private Set<EndClient> endClients;
//	@OneToMany(mappedBy="endClient")
//	private Set<FlowCardDetail> flowCardDetails;
	public EndClient() {}
	
	public EndClient(Integer id, String name, String code, String isLeaf, String isEndClient) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		IsLeaf = isLeaf;
		this.isEndClient = isEndClient;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getContactor() {
		return contactor;
	}
	public void setContactor(String contactor) {
		this.contactor = contactor;
	}
	public String getContactorTel() {
		return contactorTel;
	}
	public void setContactorTel(String contactorTel) {
		this.contactorTel = contactorTel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getIsLeaf() {
		return IsLeaf;
	}
	public void setIsLeaf(String isLeaf) {
		IsLeaf = isLeaf;
	}
	public String getIsEndClient() {
		return isEndClient;
	}
	public void setIsEndClient(String isEndClient) {
		this.isEndClient = isEndClient;
	}
	public Category getType() {
		return category;
	}
	public void setType(Category category) {
		this.category = category;
	}
	public EndClient getEndClient() {
		return endClient;
	}
	public void setEndClient(EndClient endClient) {
		this.endClient = endClient;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Category getCategory() {
		return category;
	}
	
	@Override
	public String toString() {
		return "EndClient [id=" + id + ", name=" + name + ", code=" + code + ", contactor=" + contactor
				+ ", contactorTel=" + contactorTel + ", address=" + address + ", zipCode=" + zipCode + ", IsLeaf="
				+ IsLeaf + ", isEndClient=" + isEndClient + ", category=" + category + ", endClient=" + endClient + "]";
	}
	
}
