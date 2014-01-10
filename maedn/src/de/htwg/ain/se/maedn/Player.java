package de.htwg.ain.se.maedn;

public class Player {
	
	private String color;
	
	private Figure[] figurefield = new Figure[4];
	
	public Player(String color, int playernumber) {
		setColor(color);
		for(int i = 0; i < 4; i ++) {
			figurefield[i] = new Figure(playernumber);
		}
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Figure[] getFigurefield() {
		return figurefield;
	}
	
	public Figure getFigure(int place) {
		return figurefield[place-1];
	}

	public void setFigurefield(Figure[] figurefield) {
		this.figurefield = figurefield;
	}
	
}
