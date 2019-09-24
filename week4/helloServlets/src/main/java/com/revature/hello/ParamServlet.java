package com.revature.hello;

import java.io.IOException;
import java.net.http.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ParamServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cheese = getServletContext().getInitParameter("cheese");
		String apple = getServletConfig().getInitParameter("apple");
		
		//We'll get the bread from a session.  The user can set bread using another form.
		//grab sessions from the req.  This is quick:
		//String bread = (String) req.getSession().getAttribute("bread");
		HttpSession mySession = req.getSession();
		String bread = (String) mySession.getAttribute("bread");
		if(bread == null) {
			bread = "rye";
		}
		
		resp.setStatus(HttpServletResponse.SC_OK);
		
		resp.getWriter().write("Your cheese, apple and bread pairing: " +
					cheese + ", " + apple + ", " + bread);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession mySession = req.getSession();
		
		String preferredBread = req.getParameter("bread");
		
		mySession.setAttribute("bread", preferredBread);
		
		resp.setStatus(HttpServletResponse.SC_CREATED);
	}
	
}
