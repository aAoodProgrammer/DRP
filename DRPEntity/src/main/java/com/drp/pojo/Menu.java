package com.drp.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @ClassName: menu 
 * @Description: 实体：菜单
 * @author 刘江涛
 * @date 2017年11月1日 下午5:49:38 
 *
 */
@Entity
@Table(name="t_menu")
public class Menu implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(length=20,nullable=false)
	private String name;
	@Column(length=2,nullable=false)
	private Integer level;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="menu_id")
	private Menu menu;
	
	@OneToMany(cascade={CascadeType.REFRESH,CascadeType.REMOVE})
	private Set<Menu> menus = new HashSet<Menu>();
	
	@OneToMany(mappedBy="menu",cascade={CascadeType.REFRESH,CascadeType.REMOVE})
	private Set<Resource> resources = new HashSet<Resource>();
	
	@ManyToMany(mappedBy="menus")
	private Set<Role> roles = new HashSet<Role>();
	public Menu() {}
	
	public Menu(Integer id, String name, Integer level, Menu menu, Set<Resource> resources,
			Set<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.menu = menu;
		this.resources = resources;
		this.roles = roles;
	}

	public Menu(Integer id, String name, Integer level, Menu menu, Set<Resource> resources) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.menu = menu;
		this.resources = resources;
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
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public Set<Menu> getMenus() {
		return menus;
	}
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	public Set<Resource> getResources() {
		return resources;
	}
	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", level=" + level + ", menu=" + menu + ", resources=" + resources
				+ "]";
	}
	
}
