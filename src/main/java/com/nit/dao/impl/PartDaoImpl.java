package com.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nit.dao.IPartDao;
import com.nit.model.Part;

@Repository
public class PartDaoImpl implements IPartDao {
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer savePart(Part part) {
		
		return (Integer)ht.save(part);
	}

	@Override
	public void updatePart(Part part) {
		ht.update(part);
	}

	@Override
	public void deletePart(Integer id) {
		Part p=new Part();
		p.setId(id);
		ht.delete(p);
		

	}

	@Override
	public Part getOnePart(Integer id) {
	
		return ht.get(Part.class, id);
	}

	@Override
	public List<Part> getAllParts() {
		
		return ht.loadAll(Part.class);
	}

	@Override
	public List<Object[]> getPartIdAndCodes() {
		String hql=" select id,partCode from in.nit.model.Part ";
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Object[]> list=(List<Object[]>) ht.find(hql);
		return list;
	}

}
