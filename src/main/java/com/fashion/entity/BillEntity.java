	package com.fashion.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class BillEntity {

	private int id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayban;
	private String nameKH;
	private String address;
	private String sdt;
	private boolean status;
	private CustomerEntity makh;
	private List<BillDetailEntity> listHoaDonCt;
	private int idmakh;
	private List<Integer> sohdChitiet;

	public BillEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillEntity(Date ngayban, String nameKH, String address, String sdt, boolean status, int idmakh,
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

	public BillEntity(int id, Date ngayban, String nameKH, String address, String sdt, boolean status, CustomerEntity makh) {
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

	public CustomerEntity getMakh() {
		return makh;
	}

	public void setMakh(CustomerEntity makh) {
		this.makh = makh;
	}

	public List<BillDetailEntity> getListHoaDonCt() {
		return listHoaDonCt;
	}

	public void setListHoaDonCt(List<BillDetailEntity> listHoaDonCt) {
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
