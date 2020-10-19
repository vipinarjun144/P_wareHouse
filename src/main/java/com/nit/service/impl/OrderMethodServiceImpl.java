package com.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nit.dao.IOrderMethodDao;
import com.nit.model.OrderMethod;
import com.nit.service.IOrderMethodService;
@Service
public class OrderMethodServiceImpl implements IOrderMethodService {

	@Autowired
	private IOrderMethodDao dao;

	@Override
	@Transactional
	public Integer saveOrderMethod(OrderMethod ob) {

		return dao.saveOrderMethod(ob);
	}

	@Override
	@Transactional(readOnly=true)
	public List<OrderMethod> getAllOrderMethods() {

		return dao.getAllOrderMethods();
	}

	@Override
	@Transactional
	public void deleteOrderMethod(Integer id) {
		dao.deleteOrderMethod(id);

	}

	@Override
	@Transactional(readOnly=true)
	public OrderMethod getOneOrderMethod(Integer id) {

		return dao.getOneOrderMethod(id);
	}

	@Override
	@Transactional
	public void updateOrderMethod(OrderMethod ob) {
		dao.updateOrderMethod(ob);

	}

	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getOrderTypeCount() {

		return dao.getOrderTypeCount();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getOrderIdAndCode(String mode) {
		// TODO Auto-generated method stub
		return dao.getOrderIdAndCode(mode);
	}
}
