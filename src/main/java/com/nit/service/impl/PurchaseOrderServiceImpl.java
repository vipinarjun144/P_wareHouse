package com.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nit.dao.IPurchaseOrderDao;
import com.nit.model.PurchaseDtl;
import com.nit.model.PurchaseOrder;
import com.nit.service.IPurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {
	
	@Autowired
	private IPurchaseOrderDao dao;

	@Override
	@Transactional
	public Integer savePurchaseOrder(PurchaseOrder po) {
		
		return dao.savePurchaseOrder(po);
	}

	@Override
	@Transactional(readOnly=true)
	public PurchaseOrder getOnePurchaseOrder(Integer id) {
		
		return dao.getOnePurchaseOrder(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<PurchaseOrder> getAllPurchaseOrder() {
		return dao.getAllPurchaseOrder();
	}

	@Override
	@Transactional
	public Integer savePurchaseDtl(PurchaseDtl dtl) {
		
		return dao.savePurchaseDtl(dtl);
	}

	@Override
	@Transactional
	public void updatePoStatus(Integer poId, String status) {
		dao.updatePoStatus(poId, status);

	}

	@Override
	@Transactional
	public void deletePurchaseDtl(Integer id) {
		dao.deletePurchaseDtl(id);
	}

}
