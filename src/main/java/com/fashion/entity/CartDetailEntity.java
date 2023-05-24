package com.fashion.entity;

public class CartDetailEntity {

	private int quantity;
	private float price;
	private ProductDetailEntity sanphamchitiet;

	public CartDetailEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDetailEntity(int quantity, float price, ProductDetailEntity sanphamchitiet) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.sanphamchitiet = sanphamchitiet;
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

	public ProductDetailEntity getSanphamchitiet() {
		return sanphamchitiet;
	}

	public void setSanphamchitiet(ProductDetailEntity sanphamchitiet) {
		this.sanphamchitiet = sanphamchitiet;
	}

	@Override
	public String toString() {
		return "CartChiTiet [quantity=" + quantity + ", price=" + price + ", sanphamchitiet=" + sanphamchitiet + "]";
	}

}
