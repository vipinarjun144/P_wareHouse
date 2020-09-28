package com.nit.dao;

import java.util.List;

import com.nit.model.ShipmentType;

public interface IShipmentTypeDao {
	Integer saveShipmentType(ShipmentType ob);
	List<ShipmentType> getAllShipmentTypes();
	void deleteShipmentType(Integer id);
	void updateShipmentType(ShipmentType ob);
	ShipmentType getOneShipmentType(Integer id);
	public List<Object[]> getShipmentModeCount();

}
