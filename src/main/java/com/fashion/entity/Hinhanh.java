package com.fashion.entity;

public class Hinhanh {

	private int id;
	private String name;
	private Sanpham idhinhanh;
	private int idsp;

	public Hinhanh(int id, String name, Sanpham idhinhanh) {
		super();
		this.id = id;
		this.name = name;
		this.idhinhanh = idhinhanh;
	}

	public Hinhanh(String name, Sanpham idhinhanh) {
		super();
		this.name = name;
		this.idhinhanh = idhinhanh;
	}

	public Hinhanh() {
		super();
		// TODO Auto-generated constructor stub
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

	public Sanpham getIdhinhanh() {
		return idhinhanh;
	}

	public void setIdhinhanh(Sanpham idhinhanh) {
		this.idhinhanh = idhinhanh;
	}

	public int getIdsp() {
		return idsp;
	}

	@Override
	public String toString() {
		return "Hinhanh [id=" + id + ", name=" + name + ", idhinhanh=" + idhinhanh.getName() + "]";
	}

}
