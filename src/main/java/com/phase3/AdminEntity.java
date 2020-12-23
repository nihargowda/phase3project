package com.phase3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class AdminEntity {
	
	@Id
	@Column(name="admin_id")
	String admin_id;
	
	@Column(name="admin_pwd")
	String admin_pwd;

	public AdminEntity(String admin_pwd) {
		super();
		this.admin_pwd = admin_pwd;
	}

	public AdminEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AdminEntity [admin_id=" + admin_id + ", admin_pwd=" + admin_pwd + "]";
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_pwd() {
		return admin_pwd;
	}

	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}

}