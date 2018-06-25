package com.spring.mvc.spittr.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/home") 
public class HomeController {
	
	public HomeController() {
		System.out.println("=============================HomeController create =======================");
	}
	
	@RequestMapping(value="/home", method=GET)
	public String home() {
		System.out.println("home controller start ...");
		return "home";
	}
	
	@RequestMapping(value="/out", method=GET)
	public String out() {
		System.out.println("out controller start ......");
		return "home";
	}

}
