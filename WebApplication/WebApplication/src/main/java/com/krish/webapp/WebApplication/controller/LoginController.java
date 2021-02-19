package com.krish.webapp.WebApplication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

@Controller
public class LoginController {
	@RequestMapping(value="/home", method=RequestMethod.GET)
	//@ResponseBody
	public String initMsg() {
		return "login";
	}
	
	@RequestMapping(value="/home",method=RequestMethod.POST)
	public String wlcmMsg(@RequestParam String name, ModelMap model) {
		model.put("name", name);
		return "welcome";
	}
}
