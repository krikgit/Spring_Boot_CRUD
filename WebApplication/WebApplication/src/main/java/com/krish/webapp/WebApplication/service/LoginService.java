package com.krish.webapp.WebApplication.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	public boolean isAuth(String name, String pass) {
		return name.equalsIgnoreCase("krik") && pass.equalsIgnoreCase("ok");
	}
}
