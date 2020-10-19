package com.nit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nit.model.Part;
import com.nit.service.IOrderMethodService;
import com.nit.service.IPartService;
import com.nit.service.IUomService;
import com.nit.util.CommonUtil;
import com.nit.view.PartExcelView;

public class PartController {

	@Autowired
	private IPartService service;

	@Autowired
	private IUomService uomService;
	@Autowired
	private IOrderMethodService orderMethodService;

	private void commonUi(Model map) {
		//It Will show Drop Down at UI(reg/edit)
		List<Object[]> uomList=uomService.getUomIdAndUomModel();
		Map<Integer,String> uomMap=CommonUtil.convert(uomList);
		map.addAttribute("uomMap",uomMap);

		List<Object[]> omSaleList=orderMethodService.getOrderIdAndCode("Sale");
		Map<Integer,String> omSaleMap=CommonUtil.convert(omSaleList);
		map.addAttribute("omSaleMap",omSaleMap);

		List<Object[]> omPurchaseList=orderMethodService.getOrderIdAndCode("Purchase");
		Map<Integer,String> omPurchaseMap=CommonUtil.convert(omPurchaseList);
		map.addAttribute("omPurchaseMap",omPurchaseMap);

	}

	@RequestMapping("/register")
	public String regPart(Model map) {
		map.addAttribute("part",new Part());
		commonUi(map);
		return "PartRegister";
	}

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String savePart(@ModelAttribute Part part,Model map) {

		Integer id=service.savePart(part);
		map.addAttribute("massage","Part Created with id :"+id);
		map.addAttribute("part",new Part());
		commonUi(map);
		return "PartRegister";
	}

	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updatePart(@ModelAttribute Part part,Model model) {
		service.updatePart(part);
		model.addAttribute("massage","Part Update");
		List<Part> list=service.getAllParts();
		model.addAttribute("list",list);
		return "PartData";
	}

	@RequestMapping("/delete")
	public String deletePart(@RequestParam Integer id,Model map) {
		service.deletePart(id);
		String message="Part'"+id+"' deleted";
		map.addAttribute("massage",message);
		List<Part> list=service.getAllParts();
		map.addAttribute("list",list);
		return "PartData";
	}

	@RequestMapping("/edit")
	public String editPart(@RequestParam Integer id,Model map) {
		Part ob=service.getOnePart(id);
		map.addAttribute("part",ob);
		commonUi(map);
		return "PartEdit";
	}

	@RequestMapping("/all")
	public String getAllPart(@ModelAttribute Part part,Model map) {

		List<Part> list=service.getAllParts();
		map.addAttribute("list",list);
		return "PartData";
	}
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		ModelAndView m=new ModelAndView();
		m.setView(new PartExcelView());
		List<Part> list=service.getAllParts();
		m.addObject("list", list);
		return m;
	}


}


