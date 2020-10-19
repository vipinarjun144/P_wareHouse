package com.nit.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nit.dao.IPurchaseOrderDao;
import com.nit.model.PurchaseDtl;
import com.nit.model.PurchaseOrder;


@Repository
public class PurchaseOrderDaoImp implements IPurchaseOrderDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer savePurchaseOrder(PurchaseOrder po) {

		return (Integer) ht.save(po);
	}

	@Override
	public PurchaseOrder getOnePurchaseOrder(Integer id) {

		return ht.get(PurchaseOrder.class, id);
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrder() {

		return ht.loadAll(PurchaseOrder.class);
	}

	@Override
	public Integer savePurchaseDtl(PurchaseDtl dtl) {

		return (Integer) ht.save(dtl);
	}

	@Override
	public void deletePurchaseDtl(Integer id) {
		PurchaseDtl dtl=new PurchaseDtl();
		dtl.setId(id);
		ht.delete(dtl);
	}

	@Override
	public void updatePoStatus(Integer poId, String status) {
		ht.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) 
					throws HibernateException 
			{
				String hql=" update in.nit.model.PurchaseOrder "
						+" set status=:a "
						+" where id=:b ";
				int count=session.createQuery(hql)
						.setParameter("a", status)
						.setParameter("b", poId)
						.executeUpdate();
				return count;

			}
		});
	}


}
