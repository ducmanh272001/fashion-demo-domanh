package com.fashion.entity;

public class CalculateEntity {

	
	private Integer id;
	
	private Integer productId;
	

	private Integer quantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public CalculateEntity(Integer id, Integer productId, Integer quantity) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
	}

	public CalculateEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CalculateEntity(Integer productId, Integer quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	

}
