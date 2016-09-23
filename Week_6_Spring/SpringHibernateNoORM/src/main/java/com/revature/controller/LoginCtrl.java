package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.revature.model.BankUser;
import com.revature.service.BankUserService;


@Controller
public class LoginCtrl {

	@Autowired
	BankUserService bankUserService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginGet(ModelMap modelMap){
		System.out.println("login but is it a get!");
		
		//Must supply a user model for the form to set parameters 
		BankUser emptyUser = new BankUser();
		modelMap.addAttribute("user", emptyUser);
		
		return "Login";
	}
	
	 
//	@RequestMapping(value="/login",method=RequestMethod.POST)
//	public String loginPost(User user, ModelMap modelMap){
//		System.out.println("login but is it a post!");
//		System.out.println(user.getUsername());
//		modelMap.addAttribute("user", user);
//		return "redirect:home";
//	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView loginPost(BankUser user, ModelMap modelMap){
		System.out.println("login but is it a post!");
		System.out.println(user.getBankUsername());
		modelMap.addAttribute("user", user);
		bankUserService.authBankUser(user);
		return new ModelAndView("Home",modelMap);
	}
	
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String getHomepage(ModelMap mm){
		System.out.println("GET home");
		System.out.println(mm.get("user"));
		
		return "Home";
	}
}
