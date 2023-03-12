package com.fashion.entity;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


public class User {

	private int id;
	@NotEmpty(message = "Xin vui lòng điền tên đăn nhập")
	@Length(min = 1, max = 50, message = "Tên tối thiểu 1 kí tự tối đa 50 ký tự")
	private String name;
	@NotEmpty(message = "Xin vui lòng nhập mật khẩu!")
	@Length(min = 4, message = "Mật khẩu tối thiểu là 4 kí tự")
	private String password;
	private int enabled;
	private String fullName;
	private List<UserRole> listUserRole;

	public User() {

	}

	
	public User(String name, String password, String fullName, int enabled) {
		this.name = name;
		this.password = password;
		this.fullName = fullName;
	    this.enabled = enabled;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<UserRole> getListUserRole() {
		return listUserRole;
	}

	public void setListUserRole(List<UserRole> listUserRole) {
		this.listUserRole = listUserRole;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", enabled=" + enabled + ", fullName="
				+ fullName + ", listUserRole=" + listUserRole + "]";
	}

}
