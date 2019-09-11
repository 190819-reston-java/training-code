package com.revature.services;

import java.util.List;

import com.revature.model.Player;
import com.revature.repositories.PlayerDAO;
import com.revature.repositories.PlayerDAOImplPJDBC;

public class PlayerService {
	
	//We'll make this mostly non-static.
	
	private Player selectedPlayer = new Player(0L, "Default", 0L, "C", 0);
	private PlayerDAO playerDAO = new PlayerDAOImplPJDBC();

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
		
		playerDAO.updatePlayer(selectedPlayer);
		
	}

	//It's common to see methods like this in the Service layer:
	public List<Player> getPlayers() {
		return playerDAO.getPlayers();
	}

	public void changeSelectedPlayer(long userInput) {
		setSelectedPlayer(playerDAO.getPlayer(userInput));
	}

	public void updateSelectedPlayer() {
		playerDAO.updatePlayer(selectedPlayer);
	}

	
}
