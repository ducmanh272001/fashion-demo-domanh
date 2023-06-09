package com.fashion.entity;

import java.util.List;


public class BranchEntity {


	private int id;
	private String name_brand;
	private boolean status;
	private List<ProductEntity> listSanPham;

	public BranchEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BranchEntity(int id, String name_brand, boolean status) {
		super();
		this.id = id;
		this.name_brand = name_brand;
		this.status = status;
	}

	public String getName_brand() {
		return name_brand;
	}

	public void setName_brand(String name_brand) {
		this.name_brand = name_brand;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public List<ProductEntity> getListSanPham() {
		return listSanPham;
	}

	public void setListSanPham(List<ProductEntity> listSanPham) {
		this.listSanPham = listSanPham;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "NhanHieu [id=" + id + ", name_brand=" + name_brand + ", status=" + status + "]";
	}

}
