package com.fashion.entity;

public class HoaDonChiTiet {

	private int id;
	private HoaDon id_hoadon;
	private SanPhamChiTiet id_sp;
	private int quantity;
	private float price;
	private int idHoaDon;
	private int idSanPhamCt;

	public HoaDonChiTiet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoaDonChiTiet(HoaDon id_hoadon, SanPhamChiTiet id_sp, int quantity, float price) {
		super();
		this.id_hoadon = id_hoadon;
		this.id_sp = id_sp;
		this.quantity = quantity;
		this.price = price;
	}

	public HoaDon getId_hoadon() {
		return id_hoadon;
	}

	public void setId_hoadon(HoaDon id_hoadon) {
		this.id_hoadon = id_hoadon;
	}

	public SanPhamChiTiet getId_sp() {
		return id_sp;
	}

	public void setId_sp(SanPhamChiTiet id_sp) {
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
