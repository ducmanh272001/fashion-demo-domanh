package com.fashion.entity;

public class ProductSellNumber {
	
	 private Integer idsp;
	 private Long totalSellNumber;
	public Integer getIdsp() {
		return idsp;
	}
	public void setIdsp(Integer idsp) {
		this.idsp = idsp;
	}
	public Long getTotalSellNumber() {
		return totalSellNumber;
	}
	public void setTotalSellNumber(Long totalSellNumber) {
		this.totalSellNumber = totalSellNumber;
	}
	public ProductSellNumber(Integer idsp, Long totalSellNumber) {
		super();
		this.idsp = idsp;
		this.totalSellNumber = totalSellNumber;
	}
	public ProductSellNumber() {
		super();
		// TODO Auto-generated constructor stub
	}

	 
}
