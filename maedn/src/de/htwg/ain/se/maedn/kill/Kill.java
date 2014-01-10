package de.htwg.ain.se.maedn.kill;

import de.htwg.ain.se.maedn.figure.Figure;
import de.htwg.ain.se.maedn.player.Player;

public class Kill implements Ikill{
	
	//**********************Kill****************************
	@Override
	public Player[] kill(final Player[] playerfield, final int player, final int figure){
		playerfield[player-1].getFigurefield()[figure-1] = new Figure(player);
		return playerfield;
	}
}
