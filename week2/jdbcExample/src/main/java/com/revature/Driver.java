package com.revature;

import com.revature.repositories.PlayerDAO;
import com.revature.repositories.PlayerDAOImplPJDBC;
import com.revature.utils.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		//ConnectionUtil.getConnection();
		
		PlayerDAO playerDAO = new PlayerDAOImplPJDBC();
		
		playerDAO.getPlayers();

	}

}
