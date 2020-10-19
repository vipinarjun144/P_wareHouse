/**
 * 
 */
package com.nit.service;

import java.util.List;

import com.nit.model.PurchaseDtl;
import com.nit.model.PurchaseOrder;

/**
 * @author vipin
 *
 */
public interface IPurchaseOrderService {
	public Integer savePurchaseOrder(PurchaseOrder po);
	public PurchaseOrder getOnePurchaseOrder(Integer id);
	public List<PurchaseOrder> getAllPurchaseOrder();
	
	//----------------Scrren#2 Operation-----------
	public Integer savePurchaseDtl(PurchaseDtl dtl);
	
	
	public void updatePoStatus(Integer poId,String status);
	void deletePurchaseDtl(Integer id);

}
