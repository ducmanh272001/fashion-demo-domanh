package com.fashion.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user_role")
public class UserRoleEntity {

	private int id;
	private UserEntity userId;
	private RoleEntity roleId;
	private String name_Role_ID;

	public UserRoleEntity() {

	}

	public UserRoleEntity(UserEntity userId, RoleEntity roleId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
	}

	public UserRoleEntity(int id, UserEntity userId, RoleEntity roleId) {
		super();
		this.id = id;
		this.userId = userId;
		this.roleId = roleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserEntity getUserId() {
		return userId;
	}

	public void setUserId(UserEntity userId) {
		this.userId = userId;
	}

	public RoleEntity getRoleId() {
		return roleId;
	}

	public void setRoleId(RoleEntity roleId) {
		this.roleId = roleId;
	}

	public String getName_Role_ID() {
		return name_Role_ID;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", userId=" + userId.getName() + ",userId=" + userId.getPassword() + ",userId="
				+ userId.getEnabled() + ", roleId=" + roleId.getName() + "]";
	}

}
