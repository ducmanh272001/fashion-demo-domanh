package com.fashion.entity;

import java.util.List;

public class SanPhamChiTiet {

	private int id;
	private int amount;
	private Mausac idms;
	private Kichco idkc;
	private Sanpham mact;
	private List<HoaDonChiTiet> listHoaDonCt;
	private String kichco_name;
	private String mausac_name;
	private String sanpham_name;

	public SanPhamChiTiet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SanPhamChiTiet(int amount, Mausac idms, Kichco idkc, Sanpham mact) {
		super();
		this.amount = amount;
		this.idms = idms;
		this.idkc = idkc;
		this.mact = mact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Mausac getIdms() {
		return idms;
	}

	public void setIdms(Mausac idms) {
		this.idms = idms;
	}

	public Kichco getIdkc() {
		return idkc;
	}

	public void setIdkc(Kichco idkc) {
		this.idkc = idkc;
	}

	public Sanpham getMact() {
		return mact;
	}

	public void setMact(Sanpham mact) {
		this.mact = mact;
	}

	public List<HoaDonChiTiet> getListHoaDonCt() {
		return listHoaDonCt;
	}

	public void setListHoaDonCt(List<HoaDonChiTiet> listHoaDonCt) {
		this.listHoaDonCt = listHoaDonCt;
	}

	public String getKichco_name() {
		return kichco_name;
	}

	public void setKichco_name(String kichco_name) {
		this.kichco_name = kichco_name;
	}

	public String getMausac_name() {
		return mausac_name;
	}

	public void setMausac_name(String mausac_name) {
		this.mausac_name = mausac_name;
	}

	public String getSanpham_name() {
		return sanpham_name;
	}

	public void setSanpham_name(String sanpham_name) {
		this.sanpham_name = sanpham_name;
	}

	@Override
	public String toString() {
		return "SanPhamChiTiet [id=" + id + ", amount=" + amount + ", idms=" + idms.getName() + ", idkc="
				+ idkc.getName() + ", mact=" + mact.getName() + ", listHoaDonCt=" + listHoaDonCt + "]";
	}

}
