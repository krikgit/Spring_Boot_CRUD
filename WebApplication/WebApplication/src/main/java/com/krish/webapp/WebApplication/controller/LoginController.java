package com.krish.webapp.WebApplication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.krish.webapp.WebApplication.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

@Controller
@SessionAttributes("name")
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String initMsg() {
		return "login";
	}
	
	@RequestMapping(value="/home",method=RequestMethod.POST)
	public String wlcmMsg( ModelMap model,@RequestParam String name,@RequestParam String pass) {
		
		if(!loginService.isAuth(name, pass)) {
			model.put("errMsg", "Invalid Credentials");
			return "login";
		}
		
		model.put("name", name);
		model.put("pass",pass);
		return "welcome";
	}
}
