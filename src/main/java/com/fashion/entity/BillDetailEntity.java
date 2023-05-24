package com.fashion.entity;

public class BillDetailEntity {

	private int id;
	private BillEntity id_hoadon;
	private ProductDetailEntity id_sp;
	private int quantity;
	private float price;
	private int idHoaDon;
	private int idSanPhamCt;

	public BillDetailEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillDetailEntity(BillEntity id_hoadon, ProductDetailEntity id_sp, int quantity, float price) {
		super();
		this.id_hoadon = id_hoadon;
		this.id_sp = id_sp;
		this.quantity = quantity;
		this.price = price;
	}

	public BillEntity getId_hoadon() {
		return id_hoadon;
	}

	public void setId_hoadon(BillEntity id_hoadon) {
		this.id_hoadon = id_hoadon;
	}

	public ProductDetailEntity getId_sp() {
		return id_sp;
	}

	public void setId_sp(ProductDetailEntity id_sp) {
		this.id_sp = id_sp;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdHoaDon() {
		return idHoaDon;
	}

	public void setIdHoaDon(int idHoaDon) {
		this.idHoaDon = idHoaDon;
	}

	public int getIdSanPhamCt() {
		return idSanPhamCt;
	}

	public void setIdSanPhamCt(int idSanPhamCt) {
		this.idSanPhamCt = idSanPhamCt;
	}

	@Override
	public String toString() {
		return "HoaDonChiTiet [id=" + id + ", id_hoadon=" + id_hoadon.getId() + ", id_sp=" + id_sp.getId()
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}

}
