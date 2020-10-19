package com.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nit.dao.IOrderMethodDao;
import com.nit.model.OrderMethod;
@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveOrderMethod(OrderMethod ob) {
		return (Integer)ht.save(ob);

	}

	@Override
	public List<OrderMethod> getAllOrderMethods() {

		return ht.loadAll(OrderMethod.class);
	}

	@Override
	public void deleteOrderMethod(Integer id) {
		OrderMethod o=new OrderMethod();
		o.setOrderId(id);
		ht.delete(o);
	}

	@Override
	public OrderMethod getOneOrderMethod(Integer id) {
		return ht.get(OrderMethod.class, id);
	}

	@Override
	public void updateOrderMethod(OrderMethod ob) {
		ht.update(ob);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Object[]> getOrderTypeCount() {
		String hql=" select orderType,Count(orderType) from "+
				" in.nit.model.OrderMethod group by orderType ";
		return (List<Object[]>) ht.find(hql);
	}

	@Override
	public List<Object[]> getOrderIdAndCode(String mode) {
		String hql=" select orderId,orderCode from in.nit.model.OrderMethod where orderMode=?0 ";
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Object[]> list=(List<Object[]>) ht.find(hql, mode);
		return list;
	
	}
}
