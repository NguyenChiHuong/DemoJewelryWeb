package com.webbanhang.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "color")
public class ColorEntity extends BaseEntity {

	@Column
	private String name;

	@Column
	private String code;

	@OneToMany(mappedBy = "color")
	private List<ProductEntity> products = new ArrayList<ProductEntity>();

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

	@Override
	public String toString() {
		return this.name; // Return the name of the color for display
	}
}
