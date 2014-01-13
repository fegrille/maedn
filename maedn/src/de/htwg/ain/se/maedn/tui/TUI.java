package de.htwg.ain.se.maedn.tui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
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
	    
	public void TUIstart() {

		int numberOfPlayers = 0;
		int player = 1;
		int run = 0;
		boolean win = false;
		int winner = 0;
		Control c1;
		final String newLine = System.getProperty("line.separator");
		final Logger log = Logger.getLogger("htwgMaedn");
		BufferedReader entry = new BufferedReader(new InputStreamReader(System.in));
		log.info(newLine + "Enter Number of Players(2-4 Players possible): ");
		try {
			numberOfPlayers = Integer.parseInt(entry.readLine());
			c1 = new Control(numberOfPlayers);
		} catch (IOException e) {
			numberOfPlayers = 2;
			c1 = new Control(numberOfPlayers);
			log.log(Level.SEVERE,"No number of players entered", e);
		}
		while(!win){
		switch(player) {

		case(1):
			log.info(newLine + "Player 1 you can play now\n");
		
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
				try {
					while(!entry.readLine().equals("roll")) {
						log.info(newLine + "Please enter 'roll'");
					}
					run = c1.start();
					if(run != 0) {
						log.info(newLine + "Your first figure will put on field");

					} else {
						log.info(newLine + "You got no 6");
						break;
					}		
			
				} catch (IOException e) {
					log.log(Level.SEVERE,"Please enter 'roll'", e);
				}
				c1.noFigureOnField(player);
			}
			
			//***************Just Roll********************************************//
			log.info(newLine + "Please enter 'roll' to roll: ");
			try {
				if(entry.readLine().equals("roll")) {
					run = 0;
					int choice;
					while(run == 6 || run == 0) {
						boolean figureAtHome = false;
						run = c1.rolls();
						log.info(newLine + "You rolled a " + run);
						int checking[] = new int[2];
						
						
						//check if your roll is 6
						if(run == 6){
							//check if there are still figures at home
							for(int i = 1;i <= 4;i++){
								if(c1.getPlayer(player).getFigure(i).isOnField() == false) {
									figureAtHome = true;
									choice = i;
									checking = c1.fieldStatus(1,player,i);
									//check if first field is blocked with own figure and if the blocking figure get blocked with own figures
									while(checking[0] == player){
										choice = checking[1];
										checking = c1.fieldStatus(run,player,choice);
									}
									// check if origin figure or figure that can move can kill other player`s figures
									if(checking[0] > 0 && checking[0] < 5){
										log.info(newLine + "You kill a Figure " + checking[1] + " from player " + checking[0] + "!");
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
						checking = c1.field.getFieldStatus(11);
						while (true){
							
							if(checking[0] == player ){
								log.info(newLine + "Your first field is blocked so this figure is chosen: " + checking[1]);
								choice = checking[1];
								checking = c1.fieldStatus(run,player,choice);
							} else {
								StringBuilder positions = new StringBuilder();
								for(int i = 1; i <= numberOfPlayers; i++) {
									for(int a = 1; a <= 4; a++) {
										positions.append("Figure " + a + " from player " + i + " is on position " + c1.getPlayer(i).getFigure(a).getPosition() + "\n");
									}
								}
								log.info(newLine + positions);
								log.info(newLine + "Select figure you want to move (enter 1,2,3 or 4) or 0 if you want to skip your move: ");
								try {
									choice = Integer.parseInt(entry.readLine());
									if(choice < 0 || choice > 4) {
										log.info(newLine + "You entered a wrong number " + choice + "!");
										continue;
									}
								} catch (IOException e) {
									log.log(Level.SEVERE,"No number of players entered", e);
									continue;
								}
							}
							if(choice == 0) {
								break;
							}
							//check if first field is blocked with own figure and if the blocking figure get blocked with own figures
							
							while(checking[0] == player){
								log.info(newLine + "You can`t move figure " + choice + " because it`s blocked by your own figure " + checking[1]);
								choice = checking[1];
								checking = c1.fieldStatus(run,player,choice);
							}
							
							//check method
							//checken ob noch genug Felder da sind
							//checken ob die figur mit anderen eigenen figuren kollidiert
							//dann check ob die figur mit anderen figuren von anderen spielern kollidiert
							if(run > (c1.getPlayer(player).getFigure(choice).getList().size()-4)){
								//*************************Figure not in End Position yet***********************
								if(c1.getPlayer(player).getFigure(choice).getPosition()<=40){
									checking = c1.field.getFieldStatus(41);
									if(checking[0] == player)
										continue;
									checking = c1.field.getFieldStatus(42);
									if(checking[0] != player){
										if(run <= (c1.getPlayer(player).getFigure(choice).getList().size()-3)){
											break;
										}
									}else{
										continue;
									}
									checking = c1.field.getFieldStatus(43);
									if(checking[0] != player){
										if(run <= (c1.getPlayer(player).getFigure(choice).getList().size()-2)){
											break;
										}
									}else{
										continue;
									}
									checking = c1.field.getFieldStatus(44);
									if(checking[0] != player){
										if(run <= (c1.getPlayer(player).getFigure(choice).getList().size()-1)){
											break;
										}
									}
								}else{//*************************Figure in End Position yet**********************
									if(c1.getPlayer(player).getFigure(choice).getPosition() == 44){
										log.info(newLine + "You can't move, because Figure is already on last field!");
										continue;
									}
									checking = c1.field.getFieldStatus(44);
									if(c1.getPlayer(player).getFigure(choice).getPosition() == 43){
										if(checking[0] == player){
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
									if(c1.getPlayer(player).getFigure(choice).getPosition() == 42){
										checking = c1.field.getFieldStatus(43);
										if(checking[0] == player){
											log.info(newLine + "You can't move, because there are too few fields!");
											continue;
										}
										checking = c1.field.getFieldStatus(44);
										if(checking[0] == player){
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
									if(c1.getPlayer(player).getFigure(choice).getPosition() == 41){
										checking = c1.field.getFieldStatus(42);
										if(checking[0] == player){
											log.info(newLine + "You can't move, because there are too few fields!");
											continue;
										}
										checking = c1.field.getFieldStatus(43);
										if(checking[0] == player){
											if(run != 1){
												log.info(newLine + "You can't move, because there are too few fields!");
												continue;
											}
											break;
										}
										checking = c1.field.getFieldStatus(44);
										if(checking[0] == player){
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
							
							if(checking[0] == player){
								log.info(newLine + "You can't move, because there is one of your own figure! ");
								continue;
							} else if(checking[0] > 0 && checking[0] < 5){
								log.info(newLine + "You kill a Figure " + checking[1] + " from player " + checking[0] + "!");
								c1.collidateOtherFigures(checking);
								break;
							}
							break;
							//wenns kollidiert dann kill
							//dann laufen und naechster spieler
						}
						if(choice == 0) {
							continue;
						}
						c1.deleteFieldStatus(player, choice);
						c1.getPlayer(player).getFigure(choice).move(run);
						c1.changeFieldStatus(player, choice);
						
					}
				}
			} catch (IOException e) {
				log.log(Level.SEVERE,"Please enter 'roll'", e);
			}
			
			// test if there is a wiener
			if(c1.win(player)) {
				win = true;
				winner = player;
			}
			break;
			
			
			
			
		case(2):
			log.info(newLine + "Player 2 you can play now\n");
		
		//***************No Figure On Field********************************************//
		isAFigureOnField = false;
		for(int i = 1;i <= 4;i++){
			if(c1.getPlayer(player).getFigure(i).isOnField() == true) {
				isAFigureOnField = true;
				break;
			}

		}
	
		if(!isAFigureOnField) {
			log.info(newLine + "Please enter 'roll' to roll: ");
			try {
				while(!entry.readLine().equals("roll")) {
					log.info(newLine + "Please enter 'roll'");
				}
				run = c1.start();
				if(run != 0) {
					log.info(newLine + "Your first figure will put on field");

				} else {
					log.info(newLine + "You got no 6");
					break;
				}		
		
			} catch (IOException e) {
				log.log(Level.SEVERE,"Please enter 'roll'", e);
			}
			c1.noFigureOnField(player);
		}
		
		//***************Just Roll********************************************//
		log.info(newLine + "Please enter 'roll' to roll: ");
		try {
			if(entry.readLine().equals("roll")) {
				run = 0;
				int choice;
				while(run == 6 || run == 0) {
					boolean figureAtHome = false;
					run = c1.rolls();
					log.info(newLine + "You rolled a " + run);
					int checking[] = new int[2];
					
					
					//check if your roll is 6
					if(run == 6){
						//check if there are still figures at home
						for(int i = 1;i <= 4;i++){
							if(c1.getPlayer(player).getFigure(i).isOnField() == false) {
								figureAtHome = true;
								choice = i;
								checking = c1.fieldStatus(1,player,i);
								//check if first field is blocked with own figure and if the blocking figure get blocked with own figures
								while(checking[0] == player){
									choice = checking[1];
									checking = c1.fieldStatus(run,player,choice);
								}
								// check if origin figure or figure that can move can kill other player`s figures
								if(checking[0] > 0 && checking[0] < 5){
									log.info(newLine + "You kill a Figure " + checking[1] + " from player " + checking[0] + "!");
									c1.collidateOtherFigures(checking);
								}
								//check if it`s still the origin figure and put it on field or move other figure
								if(choice == i) {
									c1.getPlayer(player).getFigure(i).putOnField();
									c1.changeFieldStatus(player, choice);
								} else {
									c1.deleteFieldStatus(player, choice);
									c1.getPlayer(player).getFigure(choice).move(run);
									
								}
								
								break;
							}
							
						}
						if(figureAtHome){
							continue;
						}
					}

					// Check if the figurfiguree is able to be moved or if there are any collisions
					checking = c1.field.getFieldStatus(21);
					while (true){
						
						if(checking[0] == player ){
							log.info(newLine + "Your first field is blocked so this figure is chosen: " + checking[1]);
							choice = checking[1];
							checking = c1.fieldStatus(run,player,choice);
						} else {
							StringBuilder positions = new StringBuilder();
							for(int i = 1; i <= numberOfPlayers; i++) {
								for(int a = 1; a <= 4; a++) {
									positions.append("Figure " + a + " from player " + i + " is on position " + c1.getPlayer(i).getFigure(a).getPosition() + "\n");
								}
							}
							log.info(newLine + positions);
							log.info(newLine + "Select figure you want to move (enter 1,2,3 or 4) or 0 if you want to skip your move: ");
							try {
								choice = Integer.parseInt(entry.readLine());
								if(choice < 0 || choice > 4) {
									log.info(newLine + "You entered a wrong number " + choice + "!");
									continue;
								}
							} catch (IOException e) {
								log.log(Level.SEVERE,"No number of players entered", e);
								continue;
							}
						}
						if(choice == 0) {
							break;
						}
						//check if first field is blocked with own figure and if the blocking figure get blocked with own figures
						
						while(checking[0] == player){
							log.info(newLine + "You can`t move figure " + choice + " because it`s blocked by your own figure " + checking[1]);
							choice = checking[1];
							checking = c1.fieldStatus(run,player,choice);
						}
						
						//check method
						//checken ob noch genug Felder da sind
						//checken ob die figur mit anderen eigenen figuren kollidiert
						//dann check ob die figur mit anderen figuren von anderen spielern kollidiert
						if(run > (c1.getPlayer(player).getFigure(choice).getList().size()-4)){
							//*************************Figure not in End Position yet***********************
							if(c1.getPlayer(player).getFigure(choice).getPosition()<=40){
								checking = c1.field.getFieldStatus(51);
								if(checking[0] == player)
									continue;
								checking = c1.field.getFieldStatus(52);
								if(checking[0] != player){
									if(run <= (c1.getPlayer(player).getFigure(choice).getList().size()-3)){
										break;
									}
								}else{
									continue;
								}
								checking = c1.field.getFieldStatus(53);
								if(checking[0] != player){
									if(run <= (c1.getPlayer(player).getFigure(choice).getList().size()-2)){
										break;
									}
								}else{
									continue;
								}
								checking = c1.field.getFieldStatus(54);
								if(checking[0] != player){
									if(run <= (c1.getPlayer(player).getFigure(choice).getList().size()-1)){
										break;
									}
								}
							}else{//*************************Figure in End Position yet**********************
								if(c1.getPlayer(player).getFigure(choice).getPosition() == 54){
									log.info(newLine + "You can't move, because Figure is already on last field!");
									continue;
								}
								checking = c1.field.getFieldStatus(54);
								if(c1.getPlayer(player).getFigure(choice).getPosition() == 53){
									if(checking[0] == player){
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
								if(c1.getPlayer(player).getFigure(choice).getPosition() == 52){
									checking = c1.field.getFieldStatus(53);
									if(checking[0] == player){
										log.info(newLine + "You can't move, because there are too few fields!");
										continue;
									}
									checking = c1.field.getFieldStatus(54);
									if(checking[0] == player){
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
								if(c1.getPlayer(player).getFigure(choice).getPosition() == 51){
									checking = c1.field.getFieldStatus(52);
									if(checking[0] == player){
										log.info(newLine + "You can't move, because there are too few fields!");
										continue;
									}
									checking = c1.field.getFieldStatus(53);
									if(checking[0] == player){
										if(run != 1){
											log.info(newLine + "You can't move, because there are too few fields!");
											continue;
										}
										break;
									}
									checking = c1.field.getFieldStatus(54);
									if(checking[0] == player){
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
						
						if(checking[0] == player){
							log.info(newLine + "You can't move, because there is one of your own figure! ");
							continue;
						} else if(checking[0] > 0 && checking[0] < 5){
							log.info(newLine + "You kill a Figure " + checking[1] + " from player " + checking[0] + "!");
							c1.collidateOtherFigures(checking);
							break;
						}
						break;
						//wenns kollidiert dann kill
						//dann laufen und naechster spieler
					}
					if(choice == 0) {
						continue;
					}
					c1.deleteFieldStatus(player, choice);
					c1.getPlayer(player).getFigure(choice).move(run);
					c1.changeFieldStatus(player, choice);
					
				}
			}
		} catch (IOException e) {
			log.log(Level.SEVERE,"Please enter 'roll'", e);
		}
		
		// test if there is a wiener
		if(c1.win(player)) {
			win = true;
			winner = player;
		}
			break;
			
			
			
			
			
		case(3):
			break;
			
			
			
		case(4):
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
	

}
