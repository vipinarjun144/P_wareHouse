package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nit.model.WhUserType;
import com.nit.service.IWhUserService;

@Controller
@RequestMapping("/whusertype")
public class WhUserTypeController {

	@Autowired
	private IWhUserService service;

	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("whusertype", new WhUserType());
		return "WhUserTypeRegister";
	} 

	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveWhUser(@ModelAttribute WhUserType whusertype,Model model) {
		Integer id=service.SaveWhUserType(whusertype);
		String msg="Wh User Type "+id+"  saved";
		model.addAttribute("message",msg);
		model.addAttribute("whusertype", new WhUserType());
		return "WhUserTypeRegister";
	}
	@RequestMapping("/all")
	public String getAllUserTypeData(Model model) {
		List<WhUserType> list=service.getAllWhUserType();
		model.addAttribute("list", list);
		return "WhUserTypeData";
	}
	@RequestMapping("/delete")
	public String deleteWhUserType(@RequestParam("wid")Integer id,Model model) {
		service.deleteWhUserType(id);
		String massage="Wh user "+id+" Deleted";
		model.addAttribute("massage", massage);
		List<WhUserType> list=service.getAllWhUserType();
		model.addAttribute("list",list);
		return "WhUserTypeData";
	}

	@RequestMapping("/edit")
	public String showEditePage(@RequestParam("wid") Integer id,Model model) {
		WhUserType ob=service.getOneUserType(id);
		model.addAttribute("whusertype", ob);
		return "WhUserTypeEdit";

	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateUser(@ModelAttribute WhUserType whusertype,Model model) {
		service.updateWhUserType(whusertype);
		String massage="Wh User"+whusertype.getWhId()+"update Sucessfully";
		model.addAttribute("massage", massage);
		List<WhUserType> list=service.getAllWhUserType();
		model.addAttribute("list", list);
		return "WhUserTypeData";
	}
	@RequestMapping("/view")
	public String showOneUser(@RequestParam("wid") Integer id,Model model) {
		WhUserType wh=service.getOneUserType(id);
		model.addAttribute("ob", wh);
		return "WhUserTypeView";

	}
}
