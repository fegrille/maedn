package de.htwg.ain.se.maedn.player;

import de.htwg.ain.se.maedn.figure.Figure;

public class Player implements Iplayer{
	
	//**********************Variables****************************
	private String color;
	
	//**********************Objects****************************
	private Figure[] figurefield = new Figure[4];
	
	//**********************Constructor****************************
	public Player(String color, int playernumber) {
		setColor(color);
		for(int i = 0; i < 4; i ++) {
			figurefield[i] = new Figure(playernumber);
		}
	}
	
	//**********************Get Color, Set Color****************************
	@Override
	public String getColor() {
		return color;
	}
	
	@Override
	public void setColor(String color) {
		this.color = color;
	}

	//**********************Get Figurefield, Set Figurefield****************************
	@Override
	public Figure[] getFigurefield() {
		return figurefield;
	}
	
	@Override
	public void setFigurefield(Figure[] figures) {
		this.figurefield = figures;
	}

	//**********************Get Figure****************************
	@Override
	public Figure getFigure(int place) {
		return figurefield[place-1];
	}
	
}
