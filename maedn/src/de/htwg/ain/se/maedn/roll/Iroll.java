package de.htwg.ain.se.maedn.roll;

/**
 * Iroll contains a standard roll method and a roll method if no figure is on field.
 * @author Felix Grille and Manuel Scheunemann
 * @since 10.01.2014
 */

public interface Iroll {
	
	/**
	 * Initialize a roll with a random number between 1 and 6.
	 * @return chuck.
	 */
	int roll();
	
	/**
	 * Initialize a roll sequence that rolls 3 times till it got a 6.
	 * @return 0 if he got no 6 and 6 if he got a 6.
	 */
	int firstRoll();
}
