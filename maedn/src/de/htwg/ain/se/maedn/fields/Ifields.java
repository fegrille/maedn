package de.htwg.ain.se.maedn.fields;

import java.util.ArrayList;

/**
 * Ifields saves status for every fields.
 * @author Felix Grille and Manuel Scheunemann
 * @since 10.01.2014
 */
public interface Ifields {
	
	/**
	 * Sets status of field.
	 * @param number
	 * @param figure.
	 */
	void setFieldStatus(int number, int[] figure);
	
	/**
	 * Returns status of a field.
	 * @param number
	 * @return allFields.get(number).
	 */
	int[] getFieldStatus(int number);
	
	/**
	 * Creates a new Field
	 * @return newfield
	 */
	int[] newfield();
}
