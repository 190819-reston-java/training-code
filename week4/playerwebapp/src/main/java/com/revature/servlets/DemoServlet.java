package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.repositories.PlayerDaoImplPjdbc;
import com.revature.services.PlayerService;

public class DemoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PlayerService playerService =
				new PlayerService(new PlayerDaoImplPjdbc());
		resp.getWriter().write(playerService.getPlayers().get(0).toString());
	}

}
