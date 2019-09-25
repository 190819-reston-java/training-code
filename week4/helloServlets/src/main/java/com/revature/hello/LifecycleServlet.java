package com.revature.hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifecycleServlet extends HttpServlet {
	
	//Demo of the methods invoked by the Servlet Container
	// when it starts up, uses, and destroys Servlets
	
	//Override doGet to specify behaviour on GET requests
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	//lifecycle methods you also override: init, service, and destroy
	// Then that functionality happens each time the SC spins up/uses/etc your servlet
	
	@Override
	public void init() throws ServletException {
		System.out.println("Init for LifecycleServlet");
		super.init();
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy for LifecycleServlet");
		super.destroy();
	}
	
	//don't actually override service
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Service for LifecycleServlet");
		super.service(req, res);
	}
	
	
	

}
