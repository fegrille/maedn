package de.htwg.ain.se.maedn.player;

import de.htwg.ain.se.maedn.Figure;

public interface Iplayer {

	/**
	 * Returns color of player
	 * @return color
	 */
	String getColor();
	
	/**
	 * Sets color of player
	 * @param color
	 */
	void setColor(String color);
	
	/**
	 * Returns figure list of the player.
	 * @return figurefield
	 */
	Figure[] getFigurefield();
	
	/**
	 * Sets figur field of the player
	 * @param figurefield
	 */
	void setFigurefield(Figure[] figurefield);
	
	/**
	 * Returns a figure in figurefield at index place - 1.
	 * @param place
	 * @return figurefield[place - 1].
	 */
	Figure getFigure(int place);
}
