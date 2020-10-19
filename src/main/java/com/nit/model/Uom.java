package com.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="uomtab")
public class Uom {
	@Id
	@GeneratedValue
	@GenericGenerator(name="uomidgen",strategy="increment")
	@Column(name="uomId")
	private Integer uomId;

	@Column(name="utype")
	private String uomType;

	@Column(name="umodel")
	private String uomModel;

	@Column(name="udesc")
	private String UomDesc;

	public Uom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getUomId() {
		return uomId;
	}

	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}

	public String getUomType() {
		return uomType;
	}

	public void setUomType(String uomType) {
		this.uomType = uomType;
	}

	public String getUomModel() {
		return uomModel;
	}

	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}

	public String getUomDesc() {
		return UomDesc;
	}

	public void setUomDesc(String uomDesc) {
		UomDesc = uomDesc;
	}

	@Override
	public String toString() {
		return "Uom [uomId=" + uomId + ", uomType=" + uomType + ", UomModel=" + uomModel + ", UomDesc=" + UomDesc + "]";
	}


}
