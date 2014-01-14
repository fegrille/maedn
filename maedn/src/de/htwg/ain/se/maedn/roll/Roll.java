package de.htwg.ain.se.maedn.roll;

public class Roll implements Iroll{
	
	//**********************Constances****************************
	private static final int MAXROLL = 6;
	private static final int MAXTHREW = 3;
	
	//**********************Roll****************************
	@Override
	public int roll() {
		int chuck = 0;
		chuck = (int)((Math.random()) * MAXROLL + 1);
		return chuck;
	}
	
	//**********************First Roll****************************
	@Override
	public int firstRoll() {
		int chuck = roll();
		int maxmove = 0;
		int threw = 1;
		while(chuck != MAXROLL && threw != MAXTHREW) {
			chuck = roll();
			threw++;
		}
		if(chuck == 6) {
			return chuck;
		}
		else {
			return maxmove;
		}
	}

}
