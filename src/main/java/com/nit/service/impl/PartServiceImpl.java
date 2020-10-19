package com.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nit.dao.IPartDao;
import com.nit.model.Part;
import com.nit.service.IPartService;

@Service
public class PartServiceImpl implements IPartService {
	
	@Autowired
	private IPartDao dao;

	@Override
	@Transactional
	public Integer savePart(Part part) {
		
		return dao.savePart(part);
	}

	@Override
	@Transactional
	public void updatePart(Part part) {
		dao.updatePart(part);

	}

	@Override
	@Transactional
	public void deletePart(Integer id) {
		dao.deletePart(id);

	}

	@Override
	@Transactional(readOnly=true)
	public Part getOnePart(Integer id) {
		// TODO Auto-generated method stub
		return dao.getOnePart(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Part> getAllParts() {
		
		return dao.getAllParts();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getPartIdAndCodes() {
		
		return dao.getPartIdAndCodes();
	}
}
