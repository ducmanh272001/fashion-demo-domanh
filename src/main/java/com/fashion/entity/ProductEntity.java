package com.fashion.entity;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

public class ProductEntity {
	private int id;
	@NotEmpty(message = "Xin vui lòng điền tên đăng nhập")
	@Length(min = 5, message = "Tên sản phẩm tối thiểu 5 kí tự")
	private String name;
	@Length(min = 5, message = "Nội dung tối thiểu 5 kí tự")
	private String descripe;
	@Length(min = 10, max = 1000, message = "Thông tin tối thiểu 10 kí tự tối đa là 1000 kí tự")
	private String information;
	@Min(value = 10000, message = "Giá nhập tối thiểu 10.000đ")
	private float price_import;
	@Min(value = 10000, message = "Giá mới tối thiểu 10.000đ")
	private float price_new;
	private int sp_view;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "Không để trống ngày !")
	private Date day_update;
	private boolean status;
	private BranchEntity idnh;
	private TypeProductEntity idlsp;
	private String tennh;
	private List<ImagerEntity> listHinhAnh;
	private String tenloai;
	private int idnhanhieu;
	private int idtheloai;

	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public ProductEntity(int id, String name, String descripe, String information, float price_import,
			float price_new, int sp_view, Date day_update, boolean status, BranchEntity idnh, TypeProductEntity idlsp, List<ImagerEntity> listHinhAnh) {
		super();
		this.id = id;
		this.name = name;
		this.descripe = descripe;
		this.information = information;
		this.price_import = price_import;
		this.price_new = price_new;
		this.sp_view = sp_view;
		this.day_update = day_update;
		this.status = status;
		this.idnh = idnh;
		this.idlsp = idlsp;
		this.listHinhAnh = listHinhAnh;
	}

	public ProductEntity(String name, String descripe, String information, float price_import,
			float price_new, int sp_view, Date day_update, boolean status, BranchEntity idnh, TypeProductEntity idlsp) {
		super();
		this.name = name;
		this.descripe = descripe;
		this.information = information;
		this.price_import = price_import;
		this.price_new = price_new;
		this.sp_view = sp_view;
		this.day_update = day_update;
		this.status = status;
		this.idnh = idnh;
		this.idlsp = idlsp;
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

	public String getDescripe() {
		return descripe;
	}

	public void setDescripe(String descripe) {
		this.descripe = descripe;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public float getPrice_import() {
		return price_import;
	}

	public void setPrice_import(float price_import) {
		this.price_import = price_import;
	}


	public float getPrice_new() {
		return price_new;
	}

	public void setPrice_new(float price_new) {
		this.price_new = price_new;
	}

	public int getSp_view() {
		return sp_view;
	}

	public void setSp_view(int sp_view) {
		this.sp_view = sp_view;
	}

	public Date getDay_update() {
		return day_update;
	}

	public void setDay_update(Date day_update) {
		this.day_update = day_update;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public BranchEntity getIdnh() {
		return idnh;
	}

	public void setIdnh(BranchEntity idnh) {
		this.idnh = idnh;
	}

	public TypeProductEntity getIdlsp() {
		return idlsp;
	}

	public void setIdlsp(TypeProductEntity idlsp) {
		this.idlsp = idlsp;
	}

	public String getTennh() {
		return tennh;
	}

	public void setTennh(String tennh) {
		this.tennh = tennh;
	}

	public String getTenloai() {
		return tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}

	public int getIdnhanhieu() {
		return idnhanhieu;
	}

	public void setIdnhanhieu(int idnhanhieu) {
		this.idnhanhieu = idnhanhieu;
	}

	public int getIdtheloai() {
		return idtheloai;
	}

	public void setIdtheloai(int idtheloai) {
		this.idtheloai = idtheloai;
	}

	public List<ImagerEntity> getListHinhAnh() {
		return listHinhAnh;
	}

	public void setListHinhAnh(List<ImagerEntity> listHinhAnh) {
		this.listHinhAnh = listHinhAnh;
	}

	@Override
	public String toString() {
		return "Sanpham [id=" + id + ", name=" + name + ", descripe=" + descripe + ", information=" + information
				+ ", price_import=" + price_import + ", price_new=" + price_new
				+ ", sp_view=" + sp_view + ", day_update=" + day_update + ", status=" + status + ", idnh=" + idnh
				+ ", idlsp=" + idlsp + " ]";
	}

}
