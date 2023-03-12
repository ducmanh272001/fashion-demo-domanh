package com.fashion.entity;

import java.util.List;

public class Kichco {


	private int id;
	private String name;
	private boolean status;
	private List<SanPhamChiTiet> listSanPhamDetail;

	public Kichco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kichco(int id, String name, boolean status, List<SanPhamChiTiet> listSanPhamDetail) {
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

	public List<SanPhamChiTiet> getListSanPhamDetail() {
		return listSanPhamDetail;
	}

	public void setListSanPhamDetail(List<SanPhamChiTiet> listSanPhamDetail) {
		this.listSanPhamDetail = listSanPhamDetail;
	}

	@Override
	public String toString() {
		return "Kichco [id=" + id + ", name=" + name + ", status=" + status + ", listSanPhamDetail=" + listSanPhamDetail
				+ "]";
	}

}
