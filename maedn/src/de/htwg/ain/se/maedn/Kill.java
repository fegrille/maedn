package de.htwg.ain.se.maedn;

public class Kill {
	
	Player[] kill(final Player[] playerfield, final int player, final int figure){
		playerfield[player-1].getFigurefield()[figure-1] = new Figure(player);
		return playerfield;
	}
}
