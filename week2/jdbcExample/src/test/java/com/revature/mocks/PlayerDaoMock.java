package com.revature.mocks;

import java.util.List;

import com.revature.model.Player;
import com.revature.repositories.PlayerDao;

public class PlayerDaoMock implements PlayerDao {

	@Override
	public Player getPlayer(long id) {
		if(id == 1L) {
			return new Player(0L, "SuccessfulId1Get", 0L, "C", 0);
		}
		return null;
	}

	@Override
	public Player getPlayer(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createPlayer(Player p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePlayer(Player p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void demoCallableStatement() {
		// TODO Auto-generated method stub

	}

}
