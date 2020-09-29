package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nit.model.ShipmentType;
import com.nit.service.IShipmentTypeService;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
	@Autowired
	private IShipmentTypeService service;

	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("shipmentType",new ShipmentType());
		return "ShipmentTypeRegister";
	}

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveShipment(@ModelAttribute ShipmentType shipmentType, Model model) {

		Integer id = service.saveShipmentType(shipmentType);
		String massage = "Shipment Type '"+ id+"' saved successfully";
		model.addAttribute("massage",massage);
		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}
	@RequestMapping("/all")
	public String getAllShimentTypes(Model model){
		List<ShipmentType> list=service.getAllShipmentTypes();
		model.addAttribute("list",list);
		return "ShipmentTypeData";
	}
	
	@RequestMapping("/delete")
	public String deleteShipmentType(@RequestParam("sid") Integer id,Model model) {
		service.deleteShipmentType(id);
		String massage="Shipment Type "+id+" Delected";
		model.addAttribute("massage", massage);
		List<ShipmentType> list=service.getAllShipmentTypes();
		model.addAttribute("list",list);
		return "ShipmentTypeData";
	}
	
	@RequestMapping("/edit")
	public String editShipmentType(@RequestParam("sid") Integer id,Model model) {
		ShipmentType st=service.getOneShipmentType(id);
		model.addAttribute("shipmentType", st);
		return "ShipmentTypeEdit";
	} 
	
	@RequestMapping("/update")
	public String updateShipmentType(@ModelAttribute ShipmentType shipmentType,Model model) {
		service.updateShipmentType(shipmentType);
		String massage="Shipment Type "+shipmentType.getShipId()+" Update Successfully";
		model.addAttribute("massage", massage);
		List<ShipmentType> list=service.getAllShipmentTypes();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}
	@RequestMapping("/view")
	public String showOneShipment(@RequestParam("sid") Integer id,Model model) {
		ShipmentType st=service.getOneShipmentType(id);
		model.addAttribute("ob", st);
		return "ShipmentTypeView";
	}


}