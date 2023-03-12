package com.fashion.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class HoaDon {

	private int id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayban;
	private String nameKH;
	private String address;
	private String sdt;
	private boolean status;
	private KhachHang makh;
	private List<HoaDonChiTiet> listHoaDonCt;
	private int idmakh;
	private List<Integer> sohdChitiet;

	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoaDon(Date ngayban, String nameKH, String address, String sdt, boolean status, int idmakh,
			List<Integer> sohdChitiet) {
		super();
		this.ngayban = ngayban;
		this.nameKH = nameKH;
		this.address = address;
		this.sdt = sdt;
		this.status = status;
		this.idmakh = idmakh;
		this.sohdChitiet = sohdChitiet;
	}

	public HoaDon(int id, Date ngayban, String nameKH, String address, String sdt, boolean status, KhachHang makh) {
		super();
		this.id = id;
		this.ngayban = ngayban;
		this.nameKH = nameKH;
		this.address = address;
		this.sdt = sdt;
		this.status = status;
		this.makh = makh;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getNgayban() {
		return ngayban;
	}

	public void setNgayban(Date ngayban) {
		this.ngayban = ngayban;
	}

	public String getNameKH() {
		return nameKH;
	}

	public void setNameKH(String nameKH) {
		this.nameKH = nameKH;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public KhachHang getMakh() {
		return makh;
	}

	public void setMakh(KhachHang makh) {
		this.makh = makh;
	}

	public List<HoaDonChiTiet> getListHoaDonCt() {
		return listHoaDonCt;
	}

	public void setListHoaDonCt(List<HoaDonChiTiet> listHoaDonCt) {
		this.listHoaDonCt = listHoaDonCt;
	}

	public int getIdmakh() {
		return idmakh;
	}

	public void setIdmakh(int idmakh) {
		this.idmakh = idmakh;
	}

	public List<Integer> getSohdChitiet() {
		return sohdChitiet;
	}

	public void setSohdChitiet(List<Integer> sohdChitiet) {
		this.sohdChitiet = sohdChitiet;
	}

	@Override
	public String toString() {
		return "HoaDon [id=" + id + ", ngayban=" + ngayban + ", nameKH=" + nameKH + ", address=" + address + ", sdt="
				+ sdt + ", status=" + status + ", makh=" + makh.getName() + ", listHoaDonCt=" + listHoaDonCt + "]";
	}

}
