package com.nit.service;

import java.util.List;

import com.nit.model.WhUserType;

public interface IWhUserService {
	public Integer SaveWhUserType(WhUserType wh);
	public List<WhUserType> getAllWhUserType();
	public void deleteWhUserType(Integer id);
	public WhUserType getOneUserType(Integer id);
	public void updateWhUserType(WhUserType wh);
	public List<Object[]> getWhUserTypeCount();
	public List<Object[]> getWhUserTypeIdAndCode(String userType);

}
