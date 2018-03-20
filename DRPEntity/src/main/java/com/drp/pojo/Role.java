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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
/**
 * 
 * @ClassName: Role 
 * @Description: 实体：角色
 * @author 刘江涛
 * @date 2017年11月7日 上午11:48:20 
 *
 */
@Entity
@Table(name="t_role")
public class Role implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(length=10,nullable=false)
	private String name;
	
	@ManyToMany(cascade= {CascadeType.REFRESH})
	@JoinTable(name="t_user_role",
	joinColumns=@JoinColumn(name="role_id"),
	inverseJoinColumns=@JoinColumn(name="user_id"))
	private Set<User> users = new HashSet<User>();
	
	@ManyToMany(cascade= {CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinTable(name="t_role_menu",
	joinColumns=@JoinColumn(name="role_id"),
	inverseJoinColumns=@JoinColumn(name="menu_id"))
	private Set<Menu> menus = new HashSet<Menu>();
	public Role() {}
	public Role(Integer id, String name, Set<User> users, Set<Menu> menus) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
		this.menus = menus;
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
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<Menu> getMenus() {
		return menus;
	}
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", menus=" + menus + "]";
	}
	
}
