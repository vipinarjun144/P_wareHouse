package com.nit.dao;

import java.util.List;

import com.nit.model.PurchaseDtl;
import com.nit.model.PurchaseOrder;

public interface IPurchaseOrderDao {
	public Integer savePurchaseOrder(PurchaseOrder po);
	public PurchaseOrder getOnePurchaseOrder(Integer id);
	public List<PurchaseOrder> getAllPurchaseOrder();
	
	//----------------Scrren#2 Operation-----------
	public Integer savePurchaseDtl(PurchaseDtl dtl);
	
	
	public void updatePoStatus(Integer id,String status);
	void deletePurchaseDtl(Integer id);

}
