package de.htwg.ain.se.maedn.control;

import de.htwg.ain.se.maedn.player.Player;


/**
 * InterfaceControl, implements most of the control 
 * structure from a player and his figures.
 * @author Felix Grille and Manuel Scheunemann
 * @since 10.01.2014
 */

public interface Icontrol {
	
	/**
	 * Returns player from array index player - 1
	 * @param place
	 * @return Player
	 */
	
	Player getPlayer(int place);
	
	/**
	 * Adds a new Player to playerfield.
	 * Only 4 players can be added.
	 * @param playerList
	 */
	void setPlayerfield(Player[] playerList);
	
	/**
	 * This Method checks if the player got a figure on the field.
	 * @param player
	 */
	void noFigureOnField(int player);
	
	
	/**
	 * Returns true if player 1 got a figure on field or false if not.
	 * @return figureOnField1
	 */
	boolean isFigureOnField1();
	
	/**
	 * Sets new Value for variable figureOnField1
	 * @param figureOnField1
	 */
	void setFigureOnField1(boolean figureOnField1);
	
	/**
	 * Returns true if player 2 got a figure on field or false if not.
	 * @return figureOnField2
	 */
	boolean isFigureOnField2();
	
	/**
	 * Sets new Value for variable figureOnField2
	 * @param figureOnField2
	 */
	void setFigureOnField2(boolean figureOnField2);
	
	/**
	 * Returns true if player 3 got a figure on field or false if not.
	 * @return figureOnField3
	 */
	boolean isFigureOnField3();
	
	/**
	 * Sets new Value for variable figureOnField3
	 * @param figureOnField3
	 */
	void setFigureOnField3(boolean figureOnField3);
	
	/**
	 * Returns true if player 4 got a figure on field or false if not.
	 * @return figureOnField4
	 */
	boolean isFigureOnField4();
	
	/**
	 * Sets new Value for variable figureOnField4
	 * @param figureOnField4
	 */
	void setFigureOnField4(boolean figureOnField4);
	
	/**
	 * Checks if first figure till last one of player 1 (blue) if they are on the field 
	 * and puts the first one, that is not on field, on field and changes field status of his current field.
	 */
	void putBlueOnField();
	
	/**
	 * Checks if first figure till last one of player 2 (green) if they are on the field 
	 * and puts the first one, that is not on field, on field and changes field status of his current field.
	 */
	void putGreenOnField();
	
	/**
	 * Checks if first figure till last one of player 3 (yellow) if they are on the field 
	 * and puts the first one, that is not on field, on field and changes field status of his current field.
	 */
	void putYellowOnField();
	
	/**
	 * Checks if first figure till last one of player 4 (red) if they are on the field 
	 * and puts the first one, that is not on field, on field and changes field status of his current field.
	 */
	void putRedOnField();
	
	/**
	 * Checks if the figure collidates with figures from other players and kills them if they collidate
	 * @param int []fieldinfo
	 * @return true if collidated and false if not
	 */
	boolean collidateOtherFigures(final Integer[] fieldinfo);
	
	/**
	 * Initialize the first roll methode from roll while there is no figure on field.
	 * @return roll
	 */
	int start ();
	
	/**
	 * Initialize a roll.
	 * @return roll
	 */
	int rolls();
	
	/**
	 * Returns field status of the field the figure want to move.
	 * @param numberRolled
	 * @param player
	 * @param figure
	 * @return fieldstatus
	 */
	Integer[] fieldStatus(int numberRolled,int player, int figure);
	
	/**
	 * Changes status of a field
	 * @param player
	 * @param figure
	 */
	void changeFieldStatus(int player, int figure);
	
	/**
	 * Deletes status of a field
	 * @param player
	 * @param figure
	 */
	void deleteFieldStatus(int player, int figure);
	
	/**
	 * Checks if all figures of the player are inside the end fields
	 * @param player
	 * @return true if all at the end and false if not
	 */
	boolean win(int player);
}
