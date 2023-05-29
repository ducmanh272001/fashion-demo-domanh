package com.fashion.entity;

import java.util.Date;

public class PaymentEntity {

	private int id;
	
	private Long amount;// So tien
	
	private String bankCode;// Ngan hang
	
	private String currency;// don vi tien te

	private String cardType;// Kiểu thanh toán atm

	private Date datePayment;

	private String response;

	private Integer idhd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Date getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Integer getIdhd() {
		return idhd;
	}

	public void setIdhd(Integer idhd) {
		this.idhd = idhd;
	}

	public PaymentEntity(int id, Long amount, String bankCode, String currency, String cardType, Date datePayment,
			String response, Integer idhd) {
		super();
		this.id = id;
		this.amount = amount;
		this.bankCode = bankCode;
		this.currency = currency;
		this.cardType = cardType;
		this.datePayment = datePayment;
		this.response = response;
		this.idhd = idhd;
	}

	public PaymentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
