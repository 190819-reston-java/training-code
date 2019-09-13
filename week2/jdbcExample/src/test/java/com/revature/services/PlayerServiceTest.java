package com.revature.services;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.exceptions.PlayerNotFoundException;
import com.revature.mocks.PlayerDaoMock;
import com.revature.model.Player;

public class PlayerServiceTest {
	
	private static PlayerService playerService = null;
	
	@Before
	public void setUp() {
		playerService = new PlayerService(new PlayerDaoMock());
	}
	
	@After
	public void tearDown() {
		playerService = null;
	}
	
	@Test
	public void changePlayerFromDefaultUsingId() {
		playerService.changeSelectedPlayer(1L);
		assertTrue(playerService
				.getSelectedPlayer()
				.getName()
				.equals("SuccessfulId1Get"));
	}
	
	@Test(expected = PlayerNotFoundException.class)
	public void changePlayerWithNonExistantId() {
		playerService.changeSelectedPlayer(0L);
	}

}
