package com.revature.services;

import java.util.List;

import com.revature.exceptions.PlayerNotFoundException;
import com.revature.model.Player;
import com.revature.repositories.PlayerDao;
import com.revature.repositories.PlayerDaoImplPjdbc;

public class PlayerService {
	
	//We'll make this mostly non-static.
	
	//Inject DAO into Constructor
	public PlayerService(PlayerDao playerDao) {
		this.playerDao = playerDao;
		this.selectedPlayer = new Player(0L, "Default", 0L, "C", 0);
	}
	
	private Player selectedPlayer;
	private PlayerDao playerDao;

	public Player getSelectedPlayer() {
		return selectedPlayer;
	}

	public void setSelectedPlayer(Player selectedPlayer) {
		this.selectedPlayer = selectedPlayer;
	}
	
	public void sendPlayerToBat(long numberOfPitches) {
		
		int hitCounter = 0;
		int missCounter = 0;
		double avg = selectedPlayer.getBattingAverage();
		
		//NOTE: should move display logic here to Controller
		for(int i=0; i<numberOfPitches; i++) {
			if(Math.random() < avg) {
				hitCounter++;
				System.out.println("a hit!");
			} else {
				missCounter++;
				System.out.println("missed!");
			}
		}
		
		double newAvg = ((double) hitCounter) / 
				((double) (hitCounter + missCounter));
		
		selectedPlayer.setBattingAverage((newAvg+avg)/2);
		
		playerDao.updatePlayer(selectedPlayer);
		
	}

	//It's common to see methods like this in the Service layer:
	public List<Player> getPlayers() {
		return playerDao.getPlayers();
	}

	/**
	 * Change current selected player to a new player, retrieved
	 * from the DB by id.  Will not change selected player if PNFE
	 * is thrown
	 * 
	 * @throws PlayerNotFoundException
	 * 
	 * @param userInput
	 */
	public void changeSelectedPlayer(long userInput) {
		Player candidatePlayer = playerDao.getPlayer(userInput);
		if (candidatePlayer == null) {
			throw new PlayerNotFoundException();
		} else {
			setSelectedPlayer(candidatePlayer);
		}
	}

	public void updateSelectedPlayer() {
		playerDao.updatePlayer(selectedPlayer);
	}

	public Player getPlayer(String string) {
		try {
			return playerDao.getPlayer(Long.parseLong(string));
		} catch (NumberFormatException e) {
			return playerDao.getPlayer(string);
		}
	}

	
}
