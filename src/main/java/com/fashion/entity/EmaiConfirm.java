package com.fashion.entity;

import javax.validation.constraints.NotBlank;

public class EmaiConfirm {
	
	
	@NotBlank(message = "Xin vui lòng điền địa chỉ email của bạn")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EmaiConfirm(@NotBlank(message = "Xin vui lòng điền địa chỉ email của bạn") String email) {
		super();
		this.email = email;
	}

	public EmaiConfirm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
