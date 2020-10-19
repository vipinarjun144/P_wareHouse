package com.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nit.dao.IWhUserTypeDao;
import com.nit.model.WhUserType;
import com.nit.service.IWhUserService;

@Service
public class WhUserServiceImpl implements IWhUserService {
	@Autowired
	private IWhUserTypeDao dao;

	@Override
	@Transactional
	public Integer SaveWhUserType(WhUserType wh) {
		
		return dao.SaveWhUserType(wh);
	}

	@Override
	@Transactional(readOnly=true)
	public List<WhUserType> getAllWhUserType() {
		 List<WhUserType> list=dao.getAllWhUserType();
		 Collections.sort(list,(o1,o2)->o1.getWhId()-o2.getWhId());
		return list;
	}

	@Override
	@Transactional
	public void deleteWhUserType(Integer id) {
		dao.deleteWhUserType(id);
		

	}

	@Override
	@Transactional(readOnly=true)
	public WhUserType getOneUserType(Integer id) {
		
		return dao.getOneUserType(id);
	}

	@Override
	@Transactional
	public void updateWhUserType(WhUserType wh) {
		dao.updateWhUserType(wh);

	}

	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getWhUserTypeCount() {
		
		return dao.getWhUserTypeCount();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getWhUserTypeIdAndCode(String userType) {
		
		return dao.getWhUserTypeIdAndCode(userType);
	}

}
