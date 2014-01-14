package de.htwg.ain.se.maedn.tui;


import java.util.Scanner;
import java.util.logging.Logger;

import de.htwg.ain.se.maedn.control.Control;

public final class TUI {
	
	/**
	 * Performante und thread-safe Implementierung des Singleton-Patterns
	 */
    private static TUI instance = new TUI();
 
    /**
     * Default-Konstruktor, der nicht ausserhalb dieser Klasse
     * aufgerufen werden kann
     */
    private TUI() {}
 
    /**
     * Statische Methode, liefert die einzige Instanz dieser
     * Klasse zurueck
     */
    public static TUI getInstance() {
        return instance;
    }
    
	private int numberOfPlayers = 0;
	private int player = 1;
	private boolean win = false;
	private int winner = 0;
	private Control c1;
	private final String newLine = System.getProperty("line.separator");
	private final Logger log = Logger.getLogger("htwgMaedn");
	private Scanner scan = new Scanner(System.in);
	private String s;


    
    
	    
	public void Tuistart() {

		output("Enter Number of Players(2-4 Players possible): ");
		
		s = scan.next();
		while(!s.equals("2") && !s.equals("3") && !s.equals("4")){
			output("Enter Number of Players(2-4 Players possible): ");
			s = scan.next();
		}
		numberOfPlayers = Integer.parseInt(s);
		c1 = new Control(numberOfPlayers);
		
		while(!win){
		switch(player) {

		case(1):
			output("Player 1 you can play now\n");
		
			switchPlayer(player,11,41,42,43,44);
			
			// test if there is a wiener
			winner(player);
			break;
			
		case(2):
			output("Player 2 you can play now\n");
		
			switchPlayer(player,21,51,52,53,54);
		
			// test if there is a wiener
			winner(player);
			break;

		case(3):
			output("Player 3 you can play now\n");
			
			switchPlayer(player,31,61,62,63,64);
			
			// test if there is a wiener
			winner(player);
			break;
			
		case(4):
			output("Player 3 you can play now\n");
		
			switchPlayer(player,1,71,72,73,74);
			
			// test if there is a wiener
			winner(player);
			break;
		}
		if(player != numberOfPlayers) {
			player ++;
		} else {
			player = 1;
		}
	}
		output("And the winner of this epic game is " + winner + "!" + newLine + "You did it! :)");
	}
	
	private void switchPlayer(final int player, final int beginField, final int endFieldOne, 
					final int endFieldTwo, final int endFieldThree, final int endFieldFor){
		int run = 0;
		//***************No Figure On Field********************************************//
		boolean isAFigureOnField = isFigureOnField(player);
	
		if(!isAFigureOnField) {
			run = enterRoll();
			if(run != 0) {
				output("Your first figure will put on field");

			} else {
				output("You got no 6");
				return;
			}		

			c1.noFigureOnField(player);
		}
		
		//***************Just Roll********************************************//
		run = 0;
		int choice = 0;
		int checking[] = new int[2];
		while(run == 6 || run == 0) {
			boolean figureAtHome = false;
			run = enterRoll();
			output("You rolled a " + run);
			
			//check if your roll is 6
			checking = c1.fieldStatus(1,player,choice);
			figureAtHome = rolledSix(run);
			if(figureAtHome){
				continue;
			}

			// Check if the figure is able to be moved or if there are any collisions
			checking = c1.getField().getFieldStatus(beginField);
			while (true){
				
				choice = choosefigure(checking,run);
				checking = c1.fieldStatus(run,player,choice);
				
				if(choice == 0) {
					break;
				}
				//check if your figure is on Field or Not
				if(!c1.getPlayer(player).getFigure(choice).isOnField()){
					continue;
				}
				//check if first field is blocked with own figure and if the blocking figure get blocked with own figures
				
				choice = c1.collidateOwnFigures(choice, player, run, checking);
				
				//check method
				if(run > (c1.getPlayer(player).getFigure(choice).getList().size()-4)){
					//*************************Figure not in End Position yet***********************
					if(c1.getPlayer(player).getFigure(choice).getPosition()<=40){
						checking = c1.getField().getFieldStatus(endFieldOne);
						if(checking[0] == player){
							continue;
						}
						else{
							if(run <= (c1.getPlayer(player).getFigure(choice).getList().size()-3)){
								break;
							}
						}
						checking = c1.getField().getFieldStatus(endFieldTwo);
						if(checking[0] != player){
							if(run <= (c1.getPlayer(player).getFigure(choice).getList().size()-2)){
								break;
							}
						}else{
							continue;
						}
						checking = c1.getField().getFieldStatus(endFieldThree);
						if(checking[0] != player){
							if(run <= (c1.getPlayer(player).getFigure(choice).getList().size()-1)){
								break;
							}
						}else{
							continue;
						}
						checking = c1.getField().getFieldStatus(endFieldFor);
						if(checking[0] != player){
							if(run <= (c1.getPlayer(player).getFigure(choice).getList().size())){
								break;
							}
						}
					}else{//*************************Figure in End Position yet**********************
						if(fourthEndField(endFieldFor, choice)){
							output("You can't move, because Figure is already on last field!");
							continue;
						}
						checking = c1.getField().getFieldStatus(endFieldFor);
						if(c1.getPlayer(player).getFigure(choice).getPosition() == endFieldThree){
							if(checking[0] == player){
								output("You can't move, because Figure is already on last field!");
								continue;
							}else{
								if(run > 1){
									output("You can't move, because there are too few fields!");
									continue;
								}
								break;
							}
						}
						if(c1.getPlayer(player).getFigure(choice).getPosition() == endFieldTwo){
							checking = c1.getField().getFieldStatus(endFieldThree);
							if(checking[0] == player){
								output("You can't move, because there are too few fields!");
								continue;
							}
							checking = c1.getField().getFieldStatus(endFieldFor);
							if(checking[0] == player){
								if(run != 1){
									output("You can't move, because there are too few fields!");
									continue;
								}
								break;
							}else{
								if(run <= 2){
									break;
								}else{
									output("You can't move, because there are too few fields!");
									continue;
								}
							}
						}
						if(c1.getPlayer(player).getFigure(choice).getPosition() == endFieldOne){
							checking = c1.getField().getFieldStatus(endFieldTwo);
							if(checking[0] == player){
								output("You can't move, because there are too few fields!");
								continue;
							}
							checking = c1.getField().getFieldStatus(endFieldThree);
							if(checking[0] == player){
								if(run != 1){
									output("You can't move, because there are too few fields!");
									continue;
								}
								break;
							}
							checking = c1.getField().getFieldStatus(endFieldFor);
							if(checking[0] == player){
								if(run <= 2){
									break;
								}else{
									output("You can't move, because there are too few fields!");
									continue;
								}
							}else{
								if(run <= 3){
									break;
								}else{
									output("You can't move, because there are too few fields!");
									continue;
								}
							}
						}
					}
					output("You can't move, because there are too few fields!");
					continue;
				}
				
				checking = c1.fieldStatus(run,player,choice);
				
				if(checking[0] == player){
					output("You can't move, because there is one of your own figure! ");
					continue;
				} else if(checking[0] > 0 && checking[0] < 5){
					output("You kill a Figure " + checking[1] + " from player " + checking[0] + "!");
					c1.collidateOtherFigures(checking);
					break;
				}
				break;
			}
			if(choice == 0) {
				continue;
			}
			c1.deleteFieldStatus(player, choice);
			c1.getPlayer(player).getFigure(choice).move(run);
			c1.changeFieldStatus(player, choice);
		}
	}
	
	public void winner(int p) {
		if(c1.win(player)) {
			win = true;
			winner = player;
		}
	}
	
	public boolean isFigureOnField(int p) {
		for(int i = 1;i <= 4;i++){
			if(c1.getPlayer(player).getFigure(i).isOnField()) {
				return true;
			}

		}
		return false;
	}
	
	public int enterRoll() {
		s = "";
		while(!s.equals("roll")) {
			output("Please enter 'roll'");
			s = scan.next();
		}
		return c1.start();
	}
	
	public boolean rolledSix(int roll) {
		boolean figureHome = false;
		int choice;
		int[] checking = new int[2];
		if(roll == 6){
			//check if there are still figures at home
			for(int i = 1;i <= 4;i++){
				if(!c1.getPlayer(player).getFigure(i).isOnField()) {
					figureHome = true;
					choice = i;
					checking = c1.fieldStatus(1,player,choice);
					//check if first field is blocked with own figure and if the blocking figure get blocked with own figures
					choice = c1.collidateOwnFigures(choice, player, roll, checking);
					// check if origin figure or figure that can move can kill other player`s figures
					c1.collidateOtherFigures(checking);
					//check if it`s still the origin figure and put it on field or move other figure
					if(choice == i) {
						c1.getPlayer(player).getFigure(i).putOnField();
						c1.changeFieldStatus(player, choice);
					} else {
						c1.deleteFieldStatus(player, choice);
						c1.getPlayer(player).getFigure(choice).move(roll);
						c1.changeFieldStatus(player, choice);
					}
					
					break;
				}
				
			}
		}
		return figureHome;
	}
	
	public int choosefigure(int[] checking, int roll) {
		int choice = 0;
		if(checking[0] == player ){
			output("Your first field is blocked so this figure is chosen: " + checking[1]);
			choice = checking[1];
		} else {
			StringBuilder positions = returnPositions();
			log.info(newLine + positions);
			s = "";
			while(!equalsChoice(s)){
				output("Select figure you want to move (enter 1,2,3 or 4) or 0 if you want to skip your move: ");
				s = scan.next();
				choice = Integer.parseInt(s);
				if(choice < 0 || choice > 4) {
					output("You entered a wrong number " + choice + "!");
				continue;
				}
			}
		}
		return choice;
	}
	
	public StringBuilder returnPositions() {
		StringBuilder returnpositions = new StringBuilder();
		for(int i = 1; i <= numberOfPlayers; i++) {
			for(int a = 1; a <= 4; a++) {
				if(c1.getPlayer(i).getFigure(a).isOnField()) {
					returnpositions.append("Figure " + a + " from player " + i + " is on position " + c1.getPlayer(i).getFigure(a).getPosition() + "\n");
				}
			}
		}
		return returnpositions;
	}
	
	public boolean fourthEndField(int endFieldFour, int choice) {
		if(c1.getPlayer(player).getFigure(choice).getPosition() == endFieldFour){
			return true;
		}
		return false;
	}
	
	public boolean equalsChoice(String s) {
		if(!s.equals("1")) {
			return false;
		}
		if(!s.equals("2")) {
			return false;
		}
		if(!s.equals("3")) {
			return false;
		}
		if(!s.equals("4")) {
			return false;
		}
		if(!s.equals("0")) {
			return false;
		}
		return true;
	}
	
	public void output(String x) {
		log.info(newLine + x);
	}

}
