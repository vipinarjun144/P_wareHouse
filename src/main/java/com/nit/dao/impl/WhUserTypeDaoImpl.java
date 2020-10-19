package com.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nit.dao.IWhUserTypeDao;
import com.nit.model.WhUserType;

@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer SaveWhUserType(WhUserType wh) {	
		return (Integer)ht.save(wh);
	}

	@Override
	public List<WhUserType> getAllWhUserType() {

		return ht.loadAll(WhUserType.class);
	}

	@Override
	public void deleteWhUserType(Integer id) {
		WhUserType wh=new WhUserType();
		wh.setWhId(id);
		ht.delete(wh);

	}

	@Override
	public WhUserType getOneUserType(Integer id) {

		return ht.get(WhUserType.class, id);
	}

	@Override
	public void updateWhUserType(WhUserType wh) {
		ht.update(wh);

	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getWhUserTypeCount() {
		String hql=" select userFor,Count(userFor) from "+
				" in.nit.model.WhUserType group by userFor ";
		return (List<Object[]>) ht.find(hql);
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Object[]> getWhUserTypeIdAndCode(String userType) {
		String hql=" select id, userCode from "+WhUserType.class.getName()+" where userType=?0";
		return (List<Object[]>) ht.find(hql, userType);
	}

}
