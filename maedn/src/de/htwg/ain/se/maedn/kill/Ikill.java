package de.htwg.ain.se.maedn.kill;

import de.htwg.ain.se.maedn.player.Player;

/**
 * Kills a figure from a player.
 * @author Felix Grille and Manuel Scheunemann
 * @since 10.01.2014
 */
public interface Ikill {
	
	/**
	 * Delets a figure from a player with creating a new own.
	 * @param playerfield
	 * @param player
	 * @param figure
	 * @return playerfield
	 */
	Player[] kill(final Player[] playerfield, final int player, final int figure);
}
