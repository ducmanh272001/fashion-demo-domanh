package com.fashion.entity;

public class CartChiTiet {

	private int quantity;
	private float price;
	private SanPhamChiTiet sanphamchitiet;

	public CartChiTiet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartChiTiet(int quantity, float price, SanPhamChiTiet sanphamchitiet) {
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

	public SanPhamChiTiet getSanphamchitiet() {
		return sanphamchitiet;
	}

	public void setSanphamchitiet(SanPhamChiTiet sanphamchitiet) {
		this.sanphamchitiet = sanphamchitiet;
	}

	@Override
	public String toString() {
		return "CartChiTiet [quantity=" + quantity + ", price=" + price + ", sanphamchitiet=" + sanphamchitiet + "]";
	}

}
