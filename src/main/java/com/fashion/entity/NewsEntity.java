package com.fashion.entity;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class NewsEntity {

	private int id;
	@Length(min = 5, max = 100, message = "Tiêu đề tối thiểu 5 kí tự và tối đa là 100 kí tự")
	private String title;
	@Length(min = 5, max = 1000, message = "Mô tả tối thiểu là 4 và tối đa là 1000 kí tự")
	private String descripe;
	@Length(min = 10,max = 2000, message = "Tối thiểu là 10 kí tự và tối đa là 2000 kí tự")
	private String content;
	@NotEmpty(message = "Thuộc tính tin không bỏ trống")
	private String type_tin;
	private Date day_tin;
	private String img;
	@NotNull(message = "Không được bỏ trống")
	private int status;

	public NewsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewsEntity(int id, String title, String descripe, String content, String type_tin, Date day_tin, String img,
			int status) {
		super();
		this.id = id;
		this.title = title;
		this.descripe = descripe;
		this.content = content;
		this.type_tin = type_tin;
		this.day_tin = day_tin;
		this.img = img;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescripe() {
		return descripe;
	}

	public void setDescripe(String descripe) {
		this.descripe = descripe;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType_tin() {
		return type_tin;
	}

	public void setType_tin(String type_tin) {
		this.type_tin = type_tin;
	}

	public Date getDay_tin() {
		return day_tin;
	}

	public void setDay_tin(Date day_tin) {
		this.day_tin = day_tin;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TinTuc [id=" + id + ", title=" + title + ", descripe=" + descripe + ", content=" + content
				+ ", type_tin=" + type_tin + ", day_tin=" + day_tin + ", day_update=" + ", img=" + img + ", status="
				+ status + "]";
	}

}
