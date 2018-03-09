package com.drp.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
 * @ClassName: Resource 
 * @Description: 实体：资源
 * @author zyl
 * @date 2017年11月7日 上午11:47:43 
 *
 */
@Entity
@Table(name="t_resource")
public class Resource implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(length=30,nullable=false)
	private String name;
	@Column(length=50)
	private String url;
	@ManyToOne(cascade={CascadeType.REFRESH})
	@JoinColumn(name="menu_id")
	private Menu menu;
	
	public Resource() {}
	
	public Resource(Integer id, String name, String url, Menu menu) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.menu = menu;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "Resource [id=" + id + ", name=" + name + ", url=" + url + "]";
	}

	
}
