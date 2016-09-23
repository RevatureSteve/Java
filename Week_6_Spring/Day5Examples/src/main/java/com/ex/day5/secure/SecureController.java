package com.ex.day5.secure;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecureController {
	
	@RequestMapping(value={"/","/welcome**"})
	public ModelAndView viewWelcomePage(){
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("home");
		mv.addObject("title", "Home");
		mv.addObject("message", "This is the default welcome page!");
		
		return mv;
	}

	@RequestMapping(value="/admin**")
	public ModelAndView viewAdminPage(){
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("specialHome");
		mv.addObject("title", "Admin Home");
		mv.addObject("message", "This is the admin page!!!");
		
		return mv;
	}
	
	@RequestMapping(value="/dba**")
	public ModelAndView viewDbaPage(Principal p){
		
		System.out.println(p.getName());
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("specialHome");
		mv.addObject("title", "DBA Home");
		mv.addObject("message", "This is the DBA page!!!");
		
		return mv;
	}
	
}
