package logging;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import database.SessionFactory;

// Aspect (my cross-cutting concern)
@Aspect
public class Logger {
	
	@Pointcut("execution(public database.* getSessionFactory())")
	public void getSfPointcut(){} // stub method
	
	@Pointcut("execution(public * set*(..)) ") // .. 0+ params of any type
	public void advancedPC(){
		/*
		 *  any public method, any return type, 
		 *  name starts with 'get', 0+ params of any type
		 */
		// execution(public * get*(..))  
		
		/*
		 *  any public method, any return type, 
		 *  name starts with 'get', ONLY 1 param of any type
		 */
		// execution(public * get*(*))
		
		/*
		 *  any public method, any return type, 
		 *  name starts with 'get', EXACTLY 2 params of any type
		 */
		// execution(public * get*(*, *))
		
		/*
		 *  any public method, any return type, 
		 *  name starts with 'get', EXACTLY 2 params,
		 *  1st param must be String, second is any type
		 */
		// execution(public * get*(String, *))
		
		/*
		 *  any public method, any return type, 
		 *  name starts with 'get', EXACTLY 0-arg
		 */
		// execution(public * get*())
		
		/*
		 *  any public method, any return type where type is database package, 
		 *  name starts with 'get', EXACTLY 0-arg
		 */
		// execution(public database.* get*())
		
		// within(com.example.database.MyClass)
		
	} //stub
	
	@Before("advancedPC()")
	public void check(){
		System.out.println("@Before: Cooool");
	}

	@Before("getSfPointcut()")
	public void loggingSf(){
		// Before
		System.out.println("@Before: Instantiating your SessionFactory...");
	}
	
	@AfterReturning(pointcut="getSfPointcut()", returning="obj")
	public void sfSuccess(Object obj){
		// After Returning
		System.out.println("@AfterReturning: Completed SessionFactory instantiation! :) " +
							obj);
	}
	
	@AfterThrowing(pointcut="execution(* *(..))", throwing="excp")
	public void sfFailure(Exception excp){
		// After Throwing
		System.out.println("@AfterThrowing: Failed to instantiate SessionFactory!! :/ cuz" 
				+ excp.getMessage());
	}
	
	@After("getSfPointcut()")
	public void sfDone(){
		// After (after 'finally')
		System.out.println("@After: OK... Moving on.....");
	}
	
	@Around("getSfPointcut()")
	// PJP encapsulates your joinpoint (aka your method)
	public Object sfTimer(ProceedingJoinPoint pjp){
		// Around
		// all this before
		Object obj = null; // the return of the method invocation
		Date start = new Date();
		try {
			System.out.println("@Around: Invoking: " + pjp.getSignature());
			obj = pjp.proceed();  //invokes the method
		} catch (Throwable e) {
			e.printStackTrace();
		}
		Date end = new Date();
		System.out.println("@Around: grabbed this object: " + obj);
		// all this after
		System.out.println("@Around: SessionFactory took "+ 
				(end.getTime() - start.getTime()) +
				" milliseconds to complete.. \\( ^_^) /");
		return obj;
	}
	
}
