package com.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nit.dao.IUomDao;
import com.nit.model.Uom;

@Repository
public class UomDaoImpl implements IUomDao {
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveUom(Uom ob) {
		
		return (Integer)ht.save(ob);
	}

	@Override
	public List<Uom> getAllUoms() {
		
		return ht.loadAll(Uom.class);
	}

	@Override
	public void deleteUom(Integer id) {
		Uom o=new Uom();
		o.setUomId(id);
		ht.delete(o);
	}

	@Override
	public Uom getOneUom(Integer id) {
		
		return ht.get(Uom.class, id);
	}

	@Override
	public void updateUom(Uom ob) {
		ht.update(ob);

	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getUomCount() {
		String hql="select uomType,count(uomType)from"+
	               "in.nit.model.Uom"+"group by UomType";
		return (List<Object[]>) ht.find(hql);
	}

	@Override
	public List<Object[]> getUomIdAndUomModel() {
		String hql=" select id,uomModel from in.nit.model.Uom";
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Object[]> list=(List<Object[]>) ht.find(hql);
		return list;
		
	}

}
