package com.revature.aspects;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.revature.models.Account;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger log = Logger.getLogger(LoggingAspect.class);
	
	@Before("within(com.revature.models.User)")
	public void logUserMethods(JoinPoint jp) {
		log.info(jp.getTarget() + " has invoked " + jp.getSignature());
	}
	
	@AfterReturning(pointcut = "execution(boolean *(..))", returning = "returnedObject")
	public void logAccountInteractions(JoinPoint jp, Object returnedObject) {
		log.info(jp.getTarget() + " has invoked " + jp.getSignature() + " returning " + returnedObject);
	}
	
	@AfterThrowing(pointcut = "execution(* *(..))", throwing = "ex")
	public void logExceptions(JoinPoint jp, Exception ex) {
		log.warn(jp.getTarget() + " has invoked " + jp.getSignature()  + " with arguments " + Arrays.toString(jp.getArgs()) + " throwing " + ex.getClass(), ex);
	}
	
	@Around("within(com.revature.models.Account) && execution(boolean withdraw(int))")
	public boolean logExceptions(ProceedingJoinPoint pjp) throws Throwable {
		Account account = (Account) pjp.getTarget();
		
		/*
		 * if((Integer) pjp.getArgs()[0] > account.getAmount()) {
		 * log.warn("Tried to withdraw too much from the account!"); return false; }
		 * 
		 * return (boolean) pjp.proceed();
		 */
		
		boolean result;
		
		try {
			result = (boolean) pjp.proceed();
		} catch(ArithmeticException e) {
			log.warn("Tried to withdraw too much from the account!");
//			throw e;
			return false;
		}
		
		return result;
	}
}
