package com.nit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nit.model.PurchaseDtl;
import com.nit.model.PurchaseOrder;
import com.nit.service.IPartService;
import com.nit.service.IPurchaseOrderService;
import com.nit.service.IShipmentTypeService;
import com.nit.service.IWhUserService;
import com.nit.util.CommonUtil;
import com.nit.view.VendorInvoicePdf;

@Controller
@RequestMapping("/po")
public class PurchaseOrderController {
	
	@Autowired
	private IPurchaseOrderService service;
	
	@Autowired
	private IPartService partService;
	
	@Autowired
	private IShipmentTypeService shipmentService;
	
	@Autowired
	private IWhUserService whUserTypeService;
	
	private void commonUi(Model model) {
		List<Object[]> shipList=shipmentService.getShipmentIdAndCode();
		Map<Integer,String> shipMap=CommonUtil.convert(shipList);
		model.addAttribute("shipMap", shipMap);
		
		List<Object[]> whVenList= whUserTypeService.getWhUserTypeIdAndCode("Vendor");
		Map<Integer,String> whVenMap=CommonUtil.convert(whVenList);
		model.addAttribute("whVenMap", whVenMap);
		
	}
	
	//show reg. page
	public String showRegPage(Model model) {
		PurchaseOrder po=new PurchaseOrder();
		po.setStatus("OPEN");
		model.addAttribute("purchaseOrder",po);
		commonUi(model);
		return "PurchaseOrderRegister";
	}
//read from data and save
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute PurchaseOrder purchaseOrder,Model model) {
		int id =service.savePurchaseOrder( purchaseOrder);
		model.addAttribute("massage","saved  with id :"+id);
		
		//clear form backing object
		PurchaseOrder po=new PurchaseOrder();
		po.setStatus("OPEN");
		model.addAttribute("purchaseOrder",po);
		
		//for drop down
		commonUi(model);
		return "PurchaseOrderRegister";
	}
	@RequestMapping("/all")
	public String showAll(Model model) {
		List<PurchaseOrder> polist=service.getAllPurchaseOrder();
		model.addAttribute("list",polist);
		return "PurchaseOrderData";
	}
	
	//******************************************************//
	///-------------------------SCREEN#2-------------------------//
	//**********************************************************//
	
	public String showChild(@RequestParam("poId") Integer poId,Model model) {
		//1.get purchase order data
		PurchaseOrder po=service.getOnePurchaseOrder(poId);
		model.addAttribute("parent",po);
		
		
		//2.for Backing object
		PurchaseDtl purchaseDtl=new PurchaseDtl();
		
		model.addAttribute("purchaseDtl",purchaseDtl);
		
		//3.Drop Down data
		List<Object[]> partlist=partService.getPartIdAndCodes();
		Map<Integer,String> partsMap=CommonUtil.convert(partlist);
		model.addAttribute("partsMap",partsMap);
		
		//4.Display all parts which are addded for this po
		List<PurchaseDtl> childs=po.getChild();
		int i=1;//slno setting
		for(PurchaseDtl dtl:childs) {
			dtl.setSlno(i++);
		}
		model.addAttribute("childs",childs);
		
		return "PurchaseParts";
		
	}
	//on click button
	@RequestMapping(value="/addPart",method=RequestMethod.POST)
	
	public String addPart(@ModelAttribute PurchaseDtl purchaseDtl) {
		service.savePurchaseDtl(purchaseDtl);
		Integer poId=purchaseDtl.getPo().getId();
		
		//at least one row added then status is picking
		service.updatePoStatus(poId, "PICKING");
		
		return "redirect:parts?poId"+poId;
	}
	
	//delete parat by Id and send to purchase Part with parentId(poId)
	@RequestMapping("/removePart")
	public String deletePart(@RequestParam("dtlId")Integer dtlId,
			                 @RequestParam("poId") Integer poId) {
		service.deletePurchaseDtl(dtlId);
		if(service.getOnePurchaseOrder(poId).getChild().isEmpty()){
			service.updatePoStatus(poId, "OPEN");
		}
		return "redirect:parts?poId="+poId;
	}
	@RequestMapping("/placeOrder")
	public String placeOrderConfirm(@RequestParam("poId") Integer poId) {
		
		service.updatePoStatus(poId, "ORDERED");
		return "redirect:parts?poId="+poId;
	}
	
	@RequestMapping("/invoceOrder")
	public String placeOrderForInvoice(@RequestParam("poId") Integer poId) {
		service.updatePoStatus(poId, "INVOICED");
		return "redirect:all";
	}
	
	//------------------Generate PDF-------------
	public ModelAndView downloadInvoiceAsPdf(@RequestParam("poId") Integer id) {
		PurchaseOrder po=service.getOnePurchaseOrder(id);
		ModelAndView m=new ModelAndView();
		m.setView(new VendorInvoicePdf());
		m.addObject("po", po);
		return m;
	}
}
