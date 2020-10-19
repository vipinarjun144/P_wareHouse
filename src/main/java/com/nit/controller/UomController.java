package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nit.model.Uom;
import com.nit.service.IUomService;

@Controller
@RequestMapping("/uom")
public class UomController {
	@Autowired
	private IUomService service;

	@RequestMapping("/register")
	private String showPage(Model model) {
		model.addAttribute("uom",new Uom());
		return "UomRegister";
	}

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveUom(@ModelAttribute Uom uom, Model model) {
		
		Integer id = service.saveUom(uom);
		String message = "Uom '"+ id+"' saved Successfully";
		model.addAttribute("message",message);
		model.addAttribute("uom",new Uom());
		return "UomRegister";
	}
	

	@RequestMapping("/all")
	private String getAllUom(Model model){
		List<Uom> list=service.getAllUoms();
		model.addAttribute("list", list);	
		return "UomData";
	}

	@RequestMapping("/edit")
	private String editUom(@RequestParam("uid")Integer id,Model model) {
		Uom u=service.getOneUom(id);
		model.addAttribute("uom", u);
		return "UomEdit";
	}

	@RequestMapping("/update")
	private String updateUom(@ModelAttribute Uom uom,Model model) {
		service.updateUom(uom);
		String message="UOM update "+uom.getUomId()+" Successfully";
		model.addAttribute("massage", message);
		List<Uom> list=service.getAllUoms();
		model.addAttribute("list", list);
		return "UomData";
	}
	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("uid")Integer id,Model model) {
		service.deleteUom(id);
		String message="UOM "+id+" Deleted";
		model.addAttribute("message", message);
		
		List<Uom> list=service.getAllUoms();
		model.addAttribute("list", list);
		return"UomData";
	} 
	
	@RequestMapping("/view")
	private String showViewPage(@RequestParam("uid")Integer id,Model model) {
		Uom u=service.getOneUom(id);
		model.addAttribute("ob", u);
		return "UomView";	
	} 

}
