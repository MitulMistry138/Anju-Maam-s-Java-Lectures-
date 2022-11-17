package com.sportsmanagement.sportmanagement;

import java.util.ArrayList;
import java.util.List;

import com.sportmanagementdao.SportsDao;
import com.sportmanagemententity.Player;
import com.sportmanagemententity.PlayerDetail;
import com.sportmanagemententity.Sports;

public class App {
	public static void main(String[] args) {
		// Save two instructors
		Player player = new Player("Shri", "krishna", 32);
		PlayerDetail playerDetail = new PlayerDetail("Mumbai", "Runner");
		playerDetail.setPlayer(player);
		player.setPlayerDetail(playerDetail);

		Player player1 = new Player("Jignesh", "Shah", 35);
		PlayerDetail playerDetail1 = new PlayerDetail("Gujarat", "Football");
		playerDetail1.setPlayer(player1);
		player1.setPlayerDetail(playerDetail1);

		List<Sports> sportss = new ArrayList<>();
		// create some new sports
		Sports spo = new Sports("Runner");
		spo.setPlayer(player);
		sportss.add(spo);
		SportsDao sod = new SportsDao();
		sod.saveSports(spo);

		Sports spor = new Sports("Football");
		spor.setPlayer(player1);
		sportss.add(spor);
		SportsDao soda = new SportsDao();
		soda.saveSports(spor);
	}
}
