package com.nit.dao;

import java.util.List;

import com.nit.model.OrderMethod;

public interface IOrderMethodDao {
	public Integer saveOrderMethod(OrderMethod ob);
	public List<OrderMethod> getAllOrderMethods();
	public void deleteOrderMethod(Integer id);
	public OrderMethod getOneOrderMethod(Integer id);
	public void updateOrderMethod(OrderMethod ob);
	public List<Object[]> getOrderTypeCount();
	public List<Object[]> getOrderIdAndCode(String mode);
}
