package com.ex.day5.secure;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	
	@Override
	protected String determineTargetUrl(HttpServletRequest request, 
										HttpServletResponse response) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String role = auth.getAuthorities().toString();
		
		String targetUrl = "";
		
		if(role.equalsIgnoreCase("[ROLE_USER]")){
			targetUrl = "/";
		}else if (role.equalsIgnoreCase("[ROLE_ADMIN]")){
			targetUrl = "/admin";
		}else if (role.equalsIgnoreCase("[ROLE_DBA]")){
			targetUrl = "/dba";
		}
		
		return targetUrl;
	}
	
	
}
