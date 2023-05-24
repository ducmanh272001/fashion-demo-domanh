package com.fashion.entity;

import java.util.List;


public class ColorEntity {


	private int id;
	private String name;
	private boolean status;
	private List<ProductDetailEntity> lstChiTiet;

	public ColorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ColorEntity(int id, String name, boolean status, List<ProductDetailEntity> lstChiTiet) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.lstChiTiet = lstChiTiet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<ProductDetailEntity> getLstChiTiet() {
		return lstChiTiet;
	}

	public void setLstChiTiet(List<ProductDetailEntity> lstChiTiet) {
		this.lstChiTiet = lstChiTiet;
	}

	@Override
	public String toString() {
		return "Mausac [id=" + id + ", name=" + name + ", status=" + status + ", lstChiTiet=" + lstChiTiet + "]";
	}

}
