package de.htwg.ain.se.maedn.figure;

import java.util.List;

/**
 * Ifigure implements everything about a figure.
 * @author Felix Grille and Manuel Scheunemann
 * @since 10.01.2014
 */
public interface Ifigure {
	
	/**
	 * Change position of the figure by removing the last element of the field list.
	 */
	void setPosition();
	
	/**
	 * Returns position of the figure.
	 * @return position
	 */
	int getPosition();
	
	/**
	 * Change position of the figure by using setPosition as often as the player rolled.
	 * @param roll
	 */
	void move(int roll);
	
	/**
	 * Put a figure on field.
	 */
	void putOnField();
	
	/**
	 * Kicks a figure from field.
	 */
	void kickFromField();
	
	/**
	 * Returns status of the figure.
	 * @return onField
	 */
	boolean isOnField();
	
	/**
	 * Changes the status of a figure.
	 * @param onField
	 */
	void setOnField(boolean onField);
	
	/**
	 * Returns fieldlist of the figure.
	 * @return fields
	 */
	List<Integer> getList();
	
	/**
	 * Sets fieldlist of the figure.
	 * @param newList
	 */
	void setList(List<Integer> newList);

}
