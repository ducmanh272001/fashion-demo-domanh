package com.fashion.entity;

import javax.validation.constraints.NotBlank;

public class ReviewForgetPassword {

	private Integer id;

	@NotBlank(message = "Xin vui lòng nhập mã xác thực ")
	private String passwordGenerated;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPasswordGenerated() {
		return passwordGenerated;
	}

	public void setPasswordGenerated(String passwordGenerated) {
		this.passwordGenerated = passwordGenerated;
	}

	public ReviewForgetPassword(Integer id,
			@NotBlank(message = "Xin vui lòng nhập mã xác thực ") String passwordGenerated) {
		super();
		this.id = id;
		this.passwordGenerated = passwordGenerated;
	}

	public ReviewForgetPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

}
