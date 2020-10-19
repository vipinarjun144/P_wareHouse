package com.nit.dao;

import java.util.List;

import com.nit.model.Part;

public interface IPartDao {
	Integer savePart(Part part);
	
	void updatePart(Part part);
	
	void deletePart(Integer id);
	
	Part getOnePart(Integer id);
	
	List<Part> getAllParts();
	
	List<Object[]> getPartIdAndCodes();
	
	

}
