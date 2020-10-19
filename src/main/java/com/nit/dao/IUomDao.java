package com.nit.dao;

import java.util.List;

import com.nit.model.Uom;

public interface IUomDao {
 Integer saveUom(Uom ob);
 List<Uom> getAllUoms();
 void  deleteUom(Integer id);
 Uom getOneUom(Integer id);
 void updateUom(Uom ob);
 List<Object[]> getUomCount();
 List<Object[]> getUomIdAndUomModel();

}
