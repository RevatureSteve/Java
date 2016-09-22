package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EventAspect {
	//Like Triggers
	@Before("execution(* com.revature.service.EventService.play*(..))")
	public void setup2(JoinPoint jp){
		System.out.println("customers wait");
	}
	@Before("execution(* com.revature.service.EventService.play*(..))")
	public void setup(JoinPoint jp){
		System.out.println("Customers sit down");
	}
	
	
	@Around("execution(* com.revature.service.EventService.run*(..))")
	public void testAroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("Set up rides");
		
		System.out.println(pjp.getSignature());
		System.out.println("clean up rides");
	}
	
}
