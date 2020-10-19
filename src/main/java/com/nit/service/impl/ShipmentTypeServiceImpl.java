package com.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nit.dao.IShipmentTypeDao;
import com.nit.model.ShipmentType;
import com.nit.service.IShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	@Autowired
	private IShipmentTypeDao dao;

	@Override
	@Transactional
	public Integer saveShipmentType(ShipmentType ob) {

		return dao.saveShipmentType(ob);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ShipmentType> getAllShipmentTypes() {
		List<ShipmentType> list=dao.getAllShipmentTypes();
		Collections.sort(list,(o1,o2)->o1.getShipId()-o2.getShipId());
		return list;

	}

	@Override
	@Transactional
	public void deleteShipmentType(Integer id) {
		dao.deleteShipmentType(id);

	}

	@Override
	@Transactional
	public void updateShipmentType(ShipmentType ob) {
		dao.updateShipmentType(ob);

	}

	@Override
	@Transactional(readOnly=true)
	public ShipmentType getOneShipmentType(Integer id) {

		return dao.getOneShipmentType(id);
	}

	@Override

	public List<Object[]> getShipmentModeCount() {

		return dao.getShipmentModeCount();
	}

	@Transactional(readOnly = true)
	public List<Object[]> getShipmentIdAndCode() {
		return dao.getShipmentIdAndCode();
	}

}
