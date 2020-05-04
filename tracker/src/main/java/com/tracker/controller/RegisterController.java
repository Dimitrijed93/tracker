package com.tracker.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tracker.model.Users;
import com.tracker.service.RegisterService;
import com.tracker.validator.UserValidator;


@RequestMapping
@Controller
public class RegisterController {
	
	@Autowired
	public RegisterService registerService;
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Autowired
	public JavaMailSender javaMailSender;

	@PostMapping("/save-user")
	public String save(@ModelAttribute("userForm") Users userForm, BindingResult bindingresult, HttpServletRequest request) {
		userValidator.validate(userForm, bindingresult);
		
		if(bindingresult.hasErrors()) {	
			return "redirect:register";
		}
		registerService.save(userForm);
//		registerService.autoLogin(userForm.getUsername(), (passwordEncoder.encode(userForm.getPassword())));
		return "redirect:home";
	}
	
	
	@RequestMapping ("/reset-password/{email}")
	public String findByEmail(@PathVariable String email) {
		Users user = registerService.findByEmail(email);	
			if (user==null) {
				return "Email doesn't excist!" ;
		}
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(user.getEmail());
			message.setSubject("Reset password");
			message.setText("Click on the link to reset your password! http://localhost:8080/tracker/reset-password/" + user.getPassword());
			javaMailSender.send(message);
			
			return "Message sent successufully";
	}
	
	@RequestMapping("/reset-password/new/{password}")
	public String resetpass(@PathVariable String password) {
	
		return "login/resetpass2";
	}

}
