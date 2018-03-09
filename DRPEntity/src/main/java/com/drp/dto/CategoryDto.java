package com.drp.dto;

import java.io.Serializable;

public class CategoryDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 类型名称
	 */
	private String name;
	
	/**
	 * 类型的id或者数量 
	 */
	private Integer num;
	
	public CategoryDto() {
	}

	public CategoryDto(String name, Integer num) {
		this.name = name;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "CategoryDto [name=" + name + ", num=" + num + "]";
	}
}
