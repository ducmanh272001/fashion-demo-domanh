package com.fashion.entity;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

public class KhachHang {

	private int id;
	@NotEmpty(message = "Không để trống tên!")
	private String name;
	@NotEmpty(message = "Không để trống account!")
	private String account;
	@Min(value = 3, message = "Mật khẩu tối thiểu là 3 kí tự")
	@NotEmpty(message = "Vui lòng không để trống pass!")
	private String passwword;
	@NotEmpty(message = "Vui lòng không để trống địa chỉ")
	private String address;
	@Pattern(regexp = "^[0-9\\-\\+]{9,15}$", message = "Số điện thoại phải bắt đầu từ 0, và là chữ số !")
	private String call;
	@Pattern(regexp = "^(.+)@(\\S+)$", message = "Kí tự phải bao gồm @ các số từ 0-9")
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private boolean gender;
	private boolean status;
	private List<HoaDon> listHoaDon;

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KhachHang(String name, String account, String passwword, String address, String call, String email,
			Date birthday, boolean gender, boolean status) {
		super();
		this.name = name;
		this.account = account;
		this.passwword = passwword;
		this.address = address;
		this.call = call;
		this.email = email;
		this.birthday = birthday;
		this.gender = gender;
		this.status = status;
	}

	public KhachHang(int id, String name, String account, String passwword, String address, String call, String email,
			Date birthday, boolean gender, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
		this.passwword = passwword;
		this.address = address;
		this.call = call;
		this.email = email;
		this.birthday = birthday;
		this.gender = gender;
		this.status = status;
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPasswword() {
		return passwword;
	}

	public void setPasswword(String passwword) {
		this.passwword = passwword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCall() {
		return call;
	}

	public void setCall(String call) {
		this.call = call;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<HoaDon> getListHoaDon() {
		return listHoaDon;
	}

	public void setListHoaDon(List<HoaDon> listHoaDon) {
		this.listHoaDon = listHoaDon;
	}

	@Override
	public String toString() {
		return "KhachHang [id=" + id + ", name=" + name + ", account=" + account + ", passwword=" + passwword
				+ ", address=" + address + ", call=" + call + ", email=" + email + ", birthday=" + birthday
				+ ", gender=" + gender + ", status=" + status + ", listHoaDon=" + listHoaDon + "]";
	}

}
