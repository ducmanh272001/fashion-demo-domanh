package com.fashion.entity;

public class CartEntity {

	private int quantity;
	private float price;
	private ProductEntity sanpham;

	public CartEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartEntity(int quantity, float price, ProductEntity sanpham) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.sanpham = sanpham;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public ProductEntity getSanpham() {
		return sanpham;
	}

	public void setSanpham(ProductEntity sanpham) {
		this.sanpham = sanpham;
	}

	@Override
	public String toString() {
		return "Cart [quantity=" + quantity + ", price=" + price + ", sanpham=" + sanpham + "]";
	}

}
