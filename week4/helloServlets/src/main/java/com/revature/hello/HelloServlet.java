package com.revature.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	//not the right way to do things, we'll use session storage
	// or similar in future examples
	static int count = 0;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Handling a GET in HelloServlet");
		
		//when we write to the response, we use a PrintWriter
		PrintWriter pw = resp.getWriter();
		//whatever we write using pw will go in the body of the response
		pw.write("<p>Writing to response from HelloServlet."
				+ " Has happened " + ++count + " times</p>"
				+ "<a href=\"/helloServlets\">Go Back\\</a>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userText = req.getParameter("userText");
		System.out.println("Received in POST: " + userText);
		
		resp.getWriter().write("hi from before redirect");
		
		resp.sendRedirect("/helloServlets");
	}

}
