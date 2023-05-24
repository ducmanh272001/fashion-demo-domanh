package com.fashion.entity;

import java.util.List;

public class SizeEntity {


	private int id;
	private String name;
	private boolean status;
	private List<ProductDetailEntity> listSanPhamDetail;

	public SizeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SizeEntity(int id, String name, boolean status, List<ProductDetailEntity> listSanPhamDetail) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.listSanPhamDetail = listSanPhamDetail;
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

	public List<ProductDetailEntity> getListSanPhamDetail() {
		return listSanPhamDetail;
	}

	public void setListSanPhamDetail(List<ProductDetailEntity> listSanPhamDetail) {
		this.listSanPhamDetail = listSanPhamDetail;
	}

	@Override
	public String toString() {
		return "Kichco [id=" + id + ", name=" + name + ", status=" + status + ", listSanPhamDetail=" + listSanPhamDetail
				+ "]";
	}

}
