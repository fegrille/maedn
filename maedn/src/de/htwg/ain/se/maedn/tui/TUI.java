package de.htwg.ain.se.maedn.tui;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import de.htwg.ain.se.maedn.control.Control;

public final class TUI {
	
	/**
	 * Performante und thread-safe Implementierung des Singleton-Patterns
	 */
    private static TUI instance = new TUI();
 
    /**
     * Default-Konstruktor, der nicht außerhalb dieser Klasse
     * aufgerufen werden kann
     */
    private TUI() {}
 
    /**
     * Statische Methode, liefert die einzige Instanz dieser
     * Klasse zurück
     */
    public static TUI getInstance() {
        return instance;
    }
    
	int numberOfPlayers = 0;
	int player = 1;
	boolean win = false;
	int winner = 0;
	Control c1;
	final String newLine = System.getProperty("line.separator");
	final Logger log = Logger.getLogger("htwgMaedn");
	Scanner scan = new Scanner(System.in);
	String s;


    
    
	    
	public void TUIstart() {

		log.info(newLine + "Enter Number of Players(2-4 Players possible): ");
		
		s = scan.next();
		while(!s.equals("2") && !s.equals("3") && !s.equals("4")){
			log.info(newLine + "Enter Number of Players(2-4 Players possible): ");
			s = scan.next();
		}
		numberOfPlayers = Integer.parseInt(s);
		c1 = new Control(numberOfPlayers);
		
		while(!win){
		switch(player) {

		case(1):
			log.info(newLine + "Player 1 you can play now\n");
		
			switchPlayer(player,11,41,42,43,44);
			
			// test if there is a wiener
			if(c1.win(player)) {
				win = true;
				winner = player;
			}
			break;
			
		case(2):
			log.info(newLine + "Player 2 you can play now\n");
		
			switchPlayer(player,21,51,52,53,54);
		
			// test if there is a wiener
			if(c1.win(player)) {
				win = true;
				winner = player;
			}
			break;

		case(3):
			log.info(newLine + "Player 3 you can play now\n");
			
			switchPlayer(player,31,61,62,63,64);
			
			// test if there is a wiener
			if(c1.win(player)) {
				win = true;
				winner = player;
			}
			break;
			
		case(4):
			log.info(newLine + "Player 3 you can play now\n");
		
			switchPlayer(player,1,71,72,73,74);
			
			// test if there is a wiener
			if(c1.win(player)) {
				win = true;
				winner = player;
			}
			break;
		}
		if(player != numberOfPlayers) {
			player ++;
		} else {
			player = 1;
		}
	}
		log.info(newLine + "And the winner of this epic game is " + winner + "!" + newLine + "You did it! :)");
	}
	
	private void switchPlayer(final int player, final int beginField, final int endFieldOne, final int endFieldTwo, final int endFieldThree, final int endFieldFor){
		int run = 0;
		//***************No Figure On Field********************************************//
		boolean isAFigureOnField = false;
		for(int i = 1;i <= 4;i++){
			if(c1.getPlayer(player).getFigure(i).isOnField() == true) {
				isAFigureOnField = true;
				break;
			}

		}
	
		if(!isAFigureOnField) {
			log.info(newLine + "Please enter 'roll' to roll: ");
	
			s = scan.next();
			while(!s.equals("roll")) {
				log.info(newLine + "Please enter 'roll'");
				s = scan.next();
			}
			run = c1.start();
			if(run != 0) {
				log.info(newLine + "Your first figure will put on field");

			} else {
				log.info(newLine + "You got no 6");
				return;
			}		

			c1.noFigureOnField(player);
		}
		
		//***************Just Roll********************************************//
		log.info(newLine + "Please enter 'roll' to roll: ");
		//***************insert roll********************************************//
		s = scan.next();
		while(!s.equals("roll")) {
			log.info(newLine + "Please enter 'roll'");
			s = scan.next();
		}
		run = 0;
		int choice;
		while(run == 6 || run == 0) {
			boolean figureAtHome = false;
			run = c1.rolls();
			log.info(newLine + "You rolled a " + run);
			ArrayList<Integer> checking = new ArrayList<>();
			
			
			//check if your roll is 6
			if(run == 6){
				//check if there are still figures at home
				for(int i = 1;i <= 4;i++){
					if(c1.getPlayer(player).getFigure(i).isOnField() == false) {
						figureAtHome = true;
						choice = i;
						checking = c1.fieldStatus(1,player,i);
						//check if first field is blocked with own figure and if the blocking figure get blocked with own figures
						while(checking.get(0) == player){
							choice = checking.get(1);
							checking = c1.fieldStatus(run,player,choice);
						}
						// check if origin figure or figure that can move can kill other player`s figures
						if(checking.get(0) > 0 && checking.get(0) < 5){
							log.info(newLine + "You kill a Figure " + checking.get(1) + " from player " + checking.get(0) + "!");
							c1.collidateOtherFigures(checking);
						}
						//check if it`s still the origin figure and put it on field or move other figure
						if(choice == i) {
							c1.getPlayer(player).getFigure(i).putOnField();
							c1.changeFieldStatus(player, choice);
						} else {
							c1.deleteFieldStatus(player, choice);
							c1.getPlayer(player).getFigure(choice).move(run);
							c1.changeFieldStatus(player, choice);
						}
						
						break;
					}
					
				}
				if(figureAtHome){
					continue;
				}
			}

			// Check if the figurfiguree is able to be moved or if there are any collisions
			checking = c1.field.getFieldStatus(beginField);
			while (true){
				
				if(checking.get(0) == player ){
					log.info(newLine + "Your first field is blocked so this figure is chosen: " + checking.get(1));
					choice = checking.get(1);
					checking = c1.fieldStatus(run,player,choice);
				} else {
					StringBuilder positions = new StringBuilder();
					for(int i = 1; i <= numberOfPlayers; i++) {
						for(int a = 1; a <= 4; a++) {
							if(c1.getPlayer(i).getFigure(a).isOnField())
							positions.append("Figure " + a + " from player " + i + " is on position " + c1.getPlayer(i).getFigure(a).getPosition() + "\n");
						}
					}
					log.info(newLine + positions);
					log.info(newLine + "Select figure you want to move (enter 1,2,3 or 4) or 0 if you want to skip your move: ");

					s = scan.next();
					while(!s.equals("1") && !s.equals("2") && !s.equals("3") && !s.equals("4") && !s.equals("0")){
						log.info(newLine + "Select figure you want to move (enter 1,2,3 or 4) or 0 if you want to skip your move: ");
						s = scan.next();
					}
					
					choice = Integer.parseInt(s);
					if(choice < 0 || choice > 4) {
						log.info(newLine + "You entered a wrong number " + choice + "!");
						continue;
					}

				}
				if(choice == 0) {
					break;
				}
				//check if your figure is on Field or Not
				if(!c1.getPlayer(player).getFigure(choice).isOnField()){
					continue;
				}
				//check if first field is blocked with own figure and if the blocking figure get blocked with own figures
				
				while(checking.get(0) == player){
					log.info(newLine + "You can`t move figure " + choice + " because it`s blocked by your own figure " + checking.get(1));
					choice = checking.get(1);
					checking = c1.fieldStatus(run,player,choice);
				}
				
				//check method
				if(run > (c1.getPlayer(player).getFigure(choice).getList().size()-4)){
					//*************************Figure not in End Position yet***********************
					if(c1.getPlayer(player).getFigure(choice).getPosition()<=40){
						checking = c1.field.getFieldStatus(endFieldOne);
						if(checking.get(0) == player){
							continue;
						}
						else{
							if(run <= (c1.getPlayer(player).getFigure(choice).getList().size()-3)){
								break;
							}
						}
						checking = c1.field.getFieldStatus(endFieldTwo);
						if(checking.get(0) != player){
							if(run <= (c1.getPlayer(player).getFigure(choice).getList().size()-2)){
								break;
							}
						}else{
							continue;
						}
						checking = c1.field.getFieldStatus(endFieldThree);
						if(checking.get(0) != player){
							if(run <= (c1.getPlayer(player).getFigure(choice).getList().size()-1)){
								break;
							}
						}else{
							continue;
						}
						checking = c1.field.getFieldStatus(endFieldFor);
						if(checking.get(0) != player){
							if(run <= (c1.getPlayer(player).getFigure(choice).getList().size())){
								break;
							}
						}
					}else{//*************************Figure in End Position yet**********************
						if(c1.getPlayer(player).getFigure(choice).getPosition() == endFieldFor){
							log.info(newLine + "You can't move, because Figure is already on last field!");
							continue;
						}
						checking = c1.field.getFieldStatus(endFieldFor);
						if(c1.getPlayer(player).getFigure(choice).getPosition() == endFieldThree){
							if(checking.get(0) == player){
								log.info(newLine + "You can't move, because Figure is already on last field!");
								continue;
							}else{
								if(run > 1){
									log.info(newLine + "You can't move, because there are too few fields!");
									continue;
								}
								break;
							}
						}
						if(c1.getPlayer(player).getFigure(choice).getPosition() == endFieldTwo){
							checking = c1.field.getFieldStatus(endFieldThree);
							if(checking.get(0) == player){
								log.info(newLine + "You can't move, because there are too few fields!");
								continue;
							}
							checking = c1.field.getFieldStatus(endFieldFor);
							if(checking.get(0) == player){
								if(run != 1){
									log.info(newLine + "You can't move, because there are too few fields!");
									continue;
								}
								break;
							}else{
								if(run <= 2){
									break;
								}else{
									log.info(newLine + "You can't move, because there are too few fields!");
									continue;
								}
							}
						}
						if(c1.getPlayer(player).getFigure(choice).getPosition() == endFieldOne){
							checking = c1.field.getFieldStatus(endFieldTwo);
							if(checking.get(0) == player){
								log.info(newLine + "You can't move, because there are too few fields!");
								continue;
							}
							checking = c1.field.getFieldStatus(endFieldThree);
							if(checking.get(0) == player){
								if(run != 1){
									log.info(newLine + "You can't move, because there are too few fields!");
									continue;
								}
								break;
							}
							checking = c1.field.getFieldStatus(endFieldFor);
							if(checking.get(0) == player){
								if(run <= 2){
									break;
								}else{
									log.info(newLine + "You can't move, because there are too few fields!");
									continue;
								}
							}else{
								if(run <= 3){
									break;
								}else{
									log.info(newLine + "You can't move, because there are too few fields!");
									continue;
								}
							}
						}
					}
					log.info(newLine + "You can't move, because there are too few fields!");
					continue;
				}
				
				checking = c1.fieldStatus(run,player,choice);
				
				if(checking.get(0) == player){
					log.info(newLine + "You can't move, because there is one of your own figure! ");
					continue;
				} else if(checking.get(0) > 0 && checking.get(0) < 5){
					log.info(newLine + "You kill a Figure " + checking.get(1) + " from player " + checking.get(0) + "!");
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

}
