package com.project.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.servlet.*;
import com.project.entity.*;
import com.project.service.*;

import java.util.*;




@RestController
public class ManagementController {
	@Autowired
	private ProjectService projectService;
	Login o;
	
	@GetMapping("index")
	public ModelAndView index() {
		ModelAndView view=new ModelAndView("index");
		return view;
	}
	/*
	@GetMapping("login")
	public ModelAndView login() {
		ModelAndView view=new ModelAndView("login");
		o=new Login("請登入帳號、密碼");
		view.addObject("error",o);
		return view;
	}
	
	@PostMapping("login")
	public ModelAndView index(@ModelAttribute Login login) {
		if(login.getAccount().equals("admin") && login.getPassword().equals("1234")) {
			System.out.println("成功登入");
			ModelAndView view=new ModelAndView("index");
			return view;
		}else {
			System.out.println("登入錯誤");
			o.setOknok("登入錯誤請再登入一次");
			ModelAndView view=new ModelAndView("datahtml/loginError");
			view.addObject("loginerror",o);
			return view;
		}
	}
	*/
	
	
	@GetMapping("findall")
	public List<ProductNumber> FindAlljson() {
		return projectService.findAll();
	}
	
	@PostMapping("findall")
	public ModelAndView FindAll(@ModelAttribute ProductNumber productNumber) {
		ModelAndView view=null;
		List<ProductNumber> list = null;
		if (productNumber.getProductnumber()!=""&&productNumber.getProductname()!="") {
			projectService.saveProductNumber(
					new ProductNumber(productNumber.getProductnumber(),productNumber.getProductname()));
			view=new ModelAndView("datahtml/sreachDone");
			list=projectService.findAll();
		}
		view.addObject("findData",list);
		return view;
	}
	
	@PostMapping("findonly")
	public ModelAndView Findonly(@ModelAttribute ProductNumber productNumber) {
		List<ProductNumber> data=projectService.queryByProductnumber(productNumber.getProductnumber());
		ModelAndView view = new ModelAndView("datahtml/sreachOnly");
		view.addObject("onlyData",data);
		return view;
	}
	
	@PostMapping("findD")
	public void FindD(@ModelAttribute ProductNumber productNumber) {
		List<ProductNumber> data=projectService.queryByProductnumber(productNumber.getProductnumber());
		for (ProductNumber e : data) {
			System.out.println(e);
			projectService.deleteByProductnumber(e.getId());
		}
	}
	
	@PostMapping("set")
	public void Set(@ModelAttribute ProductNumber productNumber) {
		Integer data=projectService.setByProductnumber(productNumber.getId());
		if(data!=null) {
			projectService.deleteByProductnumber(data);
			projectService.saveProductNumber(
					new ProductNumber(productNumber.getProductnumber(),productNumber.getProductname()));
		}
		
	}
	
	
	
	
	
}


















