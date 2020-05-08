package com.tracker.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tracker.service.RegisterService;

@Controller
public class HomeController {
	
	@Autowired
	RegisterService registerService;
	
	@RequestMapping("home")
	public String home(HttpServletRequest request){
		UserDetails activeUser = registerService.findLoggedInUsername();
		request.setAttribute("username", activeUser);
		
		return "home/home";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login/login";
	}
	
	@RequestMapping("/logout-success")
	public String logout() {
		return "login/logout";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "login/register";
	}
	
	@RequestMapping("/resetpass")
	public String resetpass() {
		return "login/resetpass";
	}
	
	
}
