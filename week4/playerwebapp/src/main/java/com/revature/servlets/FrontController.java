package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Player;
import com.revature.repositories.PlayerDaoImplPjdbc;
import com.revature.services.PlayerService;

public class FrontController extends HttpServlet {

	private PlayerService playerService;

	@Override
	public void init() throws ServletException {
		System.out.println("Starting Front Controller");
		this.playerService = new PlayerService(new PlayerDaoImplPjdbc());
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Our front controller parses the URI (and potentially other parts
		// of the request) to determine where to go/what to do

		String[] splitURI = req.getRequestURI().split("/");
		String[] tokens = Arrays.copyOfRange(splitURI, 3, splitURI.length);

		System.out.println(Arrays.toString(tokens));

		if (tokens.length == 0) {
			resp.sendError(400, "Usage: /api/players or /api/rpc");
			return;
		}

		switch (tokens[0]) {
		case "players":
			handlePlayers(req, resp, tokens);
			break;
		case "rpc":
			resp.sendError(501);
			break;
		default:
			resp.sendError(404, "Token not recognized: " + tokens[0]);
			break;
		}
	}

	private void handlePlayers(
			HttpServletRequest req, HttpServletResponse resp, String[] tokens
			) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = resp.getWriter();
		
		Player player = null;
		
		switch(req.getMethod()) {
		case "GET":
			// Check if further tokens follow /players:
			if (tokens.length == 1) {
				String jsonPlayers = om.writeValueAsString(playerService.getPlayers());
				pw.write(jsonPlayers);
			} else {
				String jsonPlayer = om.writeValueAsString(playerService.getPlayer(tokens[1]));
				pw.write(jsonPlayer);
			}
			break;
		case "POST":
			//We'll read JSON from the request body
			player = om.readValue(req.getReader(), Player.class);
			//This should definitely be more informative.
			if(!playerService.createPlayer(player)) {
				resp.sendError(400, "Failed to create player");
			} else {
				pw.write("Successful creation");
			}
			break;
		case "PUT":
			player = om.readValue(req.getReader(), Player.class);
			if(tokens.length > 1) {
				try {
					player.setId(Long.parseLong(tokens[1]));
				}catch (NumberFormatException e) {
					resp.sendError(400, "Must PUT to a valid ID.  PUT by name is not supported.");
				}
			}
			
			if(!playerService.updatePlayer(player)) {
				resp.sendError(400, "Failed to update player");
			} else {
				pw.write("Successful update");
			}
			break;
		}
			
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
