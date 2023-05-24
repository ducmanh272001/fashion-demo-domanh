package com.fashion.entity;

public class ImagerEntity {

	private int id;
	private String name;
	private ProductEntity idhinhanh;
	private int idsp;

	public ImagerEntity(int id, String name, ProductEntity idhinhanh) {
		super();
		this.id = id;
		this.name = name;
		this.idhinhanh = idhinhanh;
	}

	public ImagerEntity(String name, ProductEntity idhinhanh) {
		super();
		this.name = name;
		this.idhinhanh = idhinhanh;
	}

	public ImagerEntity() {
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

	public ProductEntity getIdhinhanh() {
		return idhinhanh;
	}

	public void setIdhinhanh(ProductEntity idhinhanh) {
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
