package com.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="whusertab")
public class WhUserType {
	@Id
	@GeneratedValue
	@Column(name="whid")
	private Integer whId;

	@Column(name="usertype")
	private String userType;

	@Column(name="usercode")
	private String userCode;

	@Column(name="userfor")
	private String userFor;

	@Column(name="mail")
	private String mail;

	@Column(name="uomcontact")
	private String uomContact;

	@Column(name="useridtype")
	private String userIDType;

	@Column(name="ifother")
	private String ifOther;

	@Column(name="idnumber")
	private String idNumber;


	public WhUserType() {
		super();
	}

	public Integer getWhId() {
		return whId;
	}

	public void setWhId(Integer whId) {
		this.whId = whId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserFor() {
		return userFor;
	}

	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUomContact() {
		return uomContact;
	}

	public void setUomContact(String uomContact) {
		this.uomContact = uomContact;
	}

	public String getUserIDType() {
		return userIDType;
	}

	public void setUserIDType(String userIDType) {
		this.userIDType = userIDType;
	}

	public String getIfOther() {
		return ifOther;
	}

	public void setIfOther(String ifOther) {
		this.ifOther = ifOther;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	@Override
	public String toString() {
		return "WhUserType [whId=" + whId + ", userType=" + userType + ", userCode=" + userCode + ", userFor=" + userFor
				+ ", mail=" + mail + ", uomContact=" + uomContact + ", userIDType=" + userIDType + ", ifOther="
				+ ifOther + ", idNumber=" + idNumber + "]";
	}
}
