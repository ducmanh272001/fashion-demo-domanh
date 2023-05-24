package com.fashion.entity;

import java.util.List;


public class TypeProductEntity {


	private int id;
	private String loai_sp;
	private boolean status;
	private List<ProductEntity> listSanPham;

	public TypeProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeProductEntity(int id, String loai_sp, boolean status) {
		super();
		this.id = id;
		this.loai_sp = loai_sp;
		this.status = status;
	}

	public String getLoai_sp() {
		return loai_sp;
	}

	public void setLoai_sp(String loai_sp) {
		this.loai_sp = loai_sp;
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
		return "LoaiSanPham [id=" + id + ", loai_sp=" + loai_sp + ", status=" + status + "]";
	}

}
