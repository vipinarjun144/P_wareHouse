package com.nit.service;

import java.util.List;

import com.nit.model.ShipmentType;

public interface IShipmentTypeService {
	public Integer saveShipmentType(ShipmentType ob);
	public List<ShipmentType> getAllShipmentTypes();
	public void deleteShipmentType(Integer id);
	public void updateShipmentType(ShipmentType ob);
	public ShipmentType getOneShipmentType(Integer id);
	public List<Object[]> getShipmentModeCount();
	public List<Object[]> getShipmentIdAndCode();

}
