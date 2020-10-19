package com.nit.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PurchaseOrder {
	@Id
	@GeneratedValue
	private Integer id;

	private String orderCode;
	private String refNum;
	private String qltychk;
	private String status;
	private String note;

	@ManyToOne
	@JoinColumn(name="shpIdFK")
	private ShipmentType sob;

	@ManyToOne
	@JoinColumn(name="venIdFK")
	private WhUserType vendor;

	//We want to fetch all dtls when we get parent object
	@OneToMany(mappedBy = "po",fetch = FetchType.EAGER)
	private List<PurchaseDtl> child;

	public PurchaseOrder() {
		super();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getRefNum() {
		return refNum;
	}

	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}

	public String getQltychk() {
		return qltychk;
	}

	public void setQltychk(String qltychk) {
		this.qltychk = qltychk;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public ShipmentType getSob() {
		return sob;
	}

	public void setSob(ShipmentType sob) {
		this.sob = sob;
	}

	public WhUserType getVendor() {
		return vendor;
	}

	public void setVendor(WhUserType vendor) {
		this.vendor = vendor;
	}

	public List<PurchaseDtl> getChild() {
		return child;
	}

	public void setChild(List<PurchaseDtl> child) {
		this.child = child;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", orderCode=" + orderCode + ", refNum=" + refNum + ","
				+ " qltychk=" + qltychk
				+ ", status=" + status + ", note=" + note + ", sob=" + sob + ", vendor=" + vendor + "]";
	}

}
