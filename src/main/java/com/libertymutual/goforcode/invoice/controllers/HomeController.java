package com.libertymutual.goforcode.invoice.controllers;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.goforcode.invoice.models.User;
import com.libertymutual.goforcode.invoice.repositories.UserRepository;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private UserRepository  userRepository;
	private PasswordEncoder encoder;
	
	public HomeController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.encoder = passwordEncoder;
	}
		

	@GetMapping("")
	public String unsecured() {
		return "home/default";
	}
	
	
	@GetMapping("/signup")
	public ModelAndView singup() {
		ModelAndView mv = new ModelAndView("home/signup");	
		return mv;
	}
	
	
	@PostMapping("/signup")
	public ModelAndView handleSingup(User user) {
		// TOTO needs refactoring 
		String password = user.getPassword();		
		String encryptedPassword = encoder.encode(password);
		user.setPassword(encryptedPassword);
				
		ModelAndView mv = new ModelAndView();
		
		try{
			userRepository.save(user);
		    mv.setViewName("redirect:/login");
		}catch(DataIntegrityViolationException e) {
			mv.setViewName("home/signup");
			mv.addObject("errorMessage", "Cannot signup with this username");
		}
		
		return mv;
	}
}
