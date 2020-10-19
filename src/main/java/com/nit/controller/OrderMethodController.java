package com.nit.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nit.model.OrderMethod;
import com.nit.service.IOrderMethodService;
import com.nit.view.OrderMethodExcelView;
import com.nit.view.OrderMethodPdf;
@Controller
@RequestMapping("/ordermethod")
public class OrderMethodController {

	@Autowired
	private IOrderMethodService service;



	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("orderMethod",new OrderMethod());
		return "OrderMethodRegister";
	}

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveOrderMethod(@ModelAttribute OrderMethod ordermethod,
			Model model) {
		Integer id=service.saveOrderMethod(ordermethod);
		String msg="Order Method '"+id+"' saved";
		model.addAttribute("message",msg);
		model.addAttribute("orderMethod",new OrderMethod());
		return "OrderMethodRegister";
	}

	@RequestMapping("/all")
	public String getAllOrderMethod(Model model) {
		List<OrderMethod> list= service.getAllOrderMethods();
		model.addAttribute("list",list);
		return "OrderMethodData";
	}

	@RequestMapping("/delete")
	public String deleteOrderMethod(@RequestParam("oid")Integer id, Model model) {
		service.deleteOrderMethod(id);
		String message="order method '"+id+"' deleted";
		model.addAttribute("message", message);
		List<OrderMethod> list=service.getAllOrderMethods();
		model.addAttribute("list",list);
		return "OrderMethodData";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("oid")Integer id,Model model) {
		OrderMethod ob=service.getOneOrderMethod(id);
		model.addAttribute("orderMethod",ob);
		return "OrderMethodEdit";
	}

	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateOrder(@ModelAttribute OrderMethod orderMethod, Model model) {
		service.updateOrderMethod(orderMethod);
		String message="Order Method '"+orderMethod.getOrderId()+"' updated";
		model.addAttribute("message", message);
		List<OrderMethod> list=service.getAllOrderMethods();
		model.addAttribute("list",list);
		return "OrderMethodData";
	}

	@RequestMapping("/view")
	public String showOneOrder(@RequestParam("oid")Integer id, Model model) {
		OrderMethod om=service.getOneOrderMethod(id);
		model.addAttribute("ob",om);
		return "OrderMethodView";
	}

	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="id", required=false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new OrderMethodExcelView());

		if(id==null) {
			List<OrderMethod> list=service.getAllOrderMethods();
			m.addObject("list",list);
		}

		else {
			OrderMethod o=service.getOneOrderMethod(id);
			m.addObject("list",Arrays.asList(o));
		}
		return m;
	}

	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="id",required=false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new OrderMethodPdf());

		if(id==null) {
			List<OrderMethod> list=service.getAllOrderMethods();
			m.addObject("list",list);
		}
		else {
			OrderMethod o=service.getOneOrderMethod(id);
			m.addObject("list",Arrays.asList(o));
		}
		return m;
	}
	/*
	@RequestMapping("/charts")
	public String showCharts() {
		List<Object[]> list=service.getOrderTypeCount();
		String path=context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path,list);
		return "OrderMethodCharts";
	}*/
}

