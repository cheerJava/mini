package com.cheer.mini.base.model;

import java.util.Date;

public class BaseEntity {

	public static final String KW_STATUS_SUCCESS = "S";
	public static final String KW_STATUS_FAIL = "F";

	private Date dateCreate = new Date();

	private Date dateUpdate = new Date();

	private String creatorFk;

	private String updaterFk;

	private short isValid = 1;

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getCreatorFk() {
		return creatorFk;
	}

	public void setCreatorFk(String creatorFk) {
		this.creatorFk = creatorFk;
	}

	public String getUpdaterFk() {
		return updaterFk;
	}

	public void setUpdaterFk(String updaterFk) {
		this.updaterFk = updaterFk;
	}

	public short getIsValid() {
		return isValid;
	}

	public void setIsValid(short isValid) {
		this.isValid = isValid;
	}

}
