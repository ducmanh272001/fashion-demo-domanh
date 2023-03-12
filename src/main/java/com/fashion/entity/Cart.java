package com.fashion.entity;

public class Cart {

	private int quantity;
	private float price;
	private Sanpham sanpham;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int quantity, float price, Sanpham sanpham) {
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

	public Sanpham getSanpham() {
		return sanpham;
	}

	public void setSanpham(Sanpham sanpham) {
		this.sanpham = sanpham;
	}

	@Override
	public String toString() {
		return "Cart [quantity=" + quantity + ", price=" + price + ", sanpham=" + sanpham + "]";
	}

}
