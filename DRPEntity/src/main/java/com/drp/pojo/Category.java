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
 * @ClassName: Category 
 * @Description: 数据字典1 分销商级别,2 物料类型,3 物料计量单位,4终端客户类型
 * @author 刘江涛
 * @date 2017年11月7日 上午11:42:28 
 *
 */
@Entity
@Table(name="t_type")
public class Category implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;		//类别id
	@Column(length=10,nullable=false)
	private String name;	//具体类名
	@Column(length=2,nullable=false)
	private Integer category;//数据类型 （1,2,3,4）
	
	@OneToMany(mappedBy="category")
	private Set<EndClient> endClient;
	@OneToMany(mappedBy="itemType")
	private Set<Item> itemTypes;
	@OneToMany(mappedBy="unitType")
	private Set<Item> itemUnits;
	@OneToMany(mappedBy="level")
	private Set<Client> clients;
	
	public Category() {}
	
	public Category(Integer id, String name, Integer category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
	}

	public Category(Integer id, String name, Integer category, Set<EndClient> endClient, Set<Item> itemTypes,
			Set<Item> itemUnits) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.endClient = endClient;
		this.itemTypes = itemTypes;
		this.itemUnits = itemUnits;
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
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Set<EndClient> getEndClient() {
		return endClient;
	}
	public void setEndClient(Set<EndClient> endClient) {
		this.endClient = endClient;
	}

	public Set<Item> getItemTypes() {
		return itemTypes;
	}
	public void setItemTypes(Set<Item> itemTypes) {
		this.itemTypes = itemTypes;
	}
	public Set<Item> getItemUnits() {
		return itemUnits;
	}
	public void setItemUnits(Set<Item> itemUnits) {
		this.itemUnits = itemUnits;
	}
	public Set<Client> getClients() {
		return clients;
	}
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", category=" + category + "]";
	}

}
