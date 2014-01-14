package de.htwg.ain.se.maedn.gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import java.util.logging.Logger;


import de.htwg.ain.se.maedn.control.Control;
import javax.swing.JTextArea;


public class Gui extends JFrame {

    
    // Putt all Components Here
	JPanel Field = new JPanel();
	JLabel Game = new JLabel(new ImageIcon("/rzhome/mascheun/z-drive/maedn/maedn/maedn/pictures/386px-Menschenaergern.svg.jpg"));
	JPanel controlField = new JPanel();
	JButton btnWuerfeln = new JButton("Wuerfeln");
	JButton OnePlayer = new JButton("1");
	JButton TwoPlayer = new JButton("2");
	JButton ThreePlayer = new JButton("3");
	JButton FourPlayer = new JButton("4");
	JLabel lblAnzahlspieler = new JLabel("AnzahlSpieler");
	JLabel lblWelchefigur = new JLabel("WelcheFigur?");
	JButton FigureFour = new JButton("4");
	JButton FigureThree = new JButton("3");
	JButton FigureTwo = new JButton("2");
	JButton FigureOne = new JButton("1");
	JButton Skip = new JButton("Skip");
	JTextArea ShowPlayer = new JTextArea();
	JTextArea ShowText = new JTextArea();
	
    
    // Consructor
	public Gui() {
		setVisible(true);
		setTitle("Maedn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		Field.setBounds(5, 5, 396, 586);
		contentPane.add(Field);
		Field.setLayout(null);
		

		Game.setBounds(5, 105, 386, 386);
		Field.add(Game);
		

		ShowPlayer.setBounds(180, 279, 37, 36);
		Field.add(ShowPlayer);
		ShowPlayer.setEditable(false);
		

		controlField.setBounds(404, 5, 240, 586);
		contentPane.add(controlField);
		controlField.setLayout(null);
		
		// Wuerfeln
		btnWuerfeln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		//btnWuerfeln.
		btnWuerfeln.setBounds(45, 111, 124, 37);
		controlField.add(btnWuerfeln);
		btnWuerfeln.setEnabled(false);
		btnWuerfeln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnWuerfeln.setEnabled(false);
			}
		});
		
		// Choose number of Player
		OnePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfPlayers = 2;
			}
		});
		OnePlayer.setBounds(22, 52, 42, 25);
		controlField.add(OnePlayer);
		OnePlayer.setEnabled(false);
		
		
		TwoPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfPlayers = 2;
			}
		});
		TwoPlayer.setBounds(74, 52, 42, 25);
		controlField.add(TwoPlayer);
		TwoPlayer.setEnabled(false);
		
		
		ThreePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfPlayers = 3;
			}
		});
		ThreePlayer.setBounds(126, 52, 42, 25);
		controlField.add(ThreePlayer);
		ThreePlayer.setEnabled(false);
		

		FourPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfPlayers = 4;
			}
		});
		FourPlayer.setBounds(178, 52, 42, 25);
		controlField.add(FourPlayer);
		FourPlayer.setEnabled(false);
		

		lblAnzahlspieler.setBounds(12, 12, 165, 28);
		controlField.add(lblAnzahlspieler);
		lblAnzahlspieler.setVisible(true);
		lblAnzahlspieler.setText("Waehle Anzahl Spieler!");
		
		
		//Choose a Figure or Skip
		lblWelchefigur.setBounds(12, 185, 140, 25);
		controlField.add(lblWelchefigur);
		lblWelchefigur.setText("Waehle eine Figur!");

		FigureFour.setBounds(178, 222, 42, 25);
		controlField.add(FigureFour);
		FigureFour.setEnabled(false);
		

		FigureThree.setBounds(126, 222, 42, 25);
		controlField.add(FigureThree);
		FigureThree.setEnabled(false);
		

		FigureTwo.setBounds(74, 222, 42, 25);
		controlField.add(FigureTwo);
		FigureTwo.setEnabled(false);
		

		FigureOne.setBounds(22, 222, 42, 25);
		controlField.add(FigureOne);
		FigureOne.setEnabled(false);
		

		Skip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Skip.setBounds(22, 259, 198, 25);
		controlField.add(Skip);
		Skip.setEnabled(false);
		

		ShowText.setBounds(20, 309, 208, 265);
		controlField.add(ShowText);
		ShowText.setEditable(false);
		ShowText.setLineWrap(true);
		ShowText.setWrapStyleWord(true);

		
	}

	
	private JPanel contentPane;

	
	
	//**************************Game Control Unit*******************************
	
	int numberOfPlayers = 0;
	int player = 1;
	boolean win = false;
	int winner = 0;
	Control c1;
	final String newLine = System.getProperty("line.separator");
	final Logger log = Logger.getLogger("htwgMaedn");
	Scanner scan = new Scanner(System.in);
	String s;
	
	public void GuiStart() {

		ShowText.setText(newLine + "Enter Number of Players(2-4 Players possible): ");
		

		OnePlayer.setEnabled(true);
		TwoPlayer.setEnabled(true);
		ThreePlayer.setEnabled(true);
		FourPlayer.setEnabled(true);
		
		while(numberOfPlayers != 2 && numberOfPlayers != 3 && numberOfPlayers != 4 ){
			
		}

		OnePlayer.setEnabled(false);
		TwoPlayer.setEnabled(false);
		ThreePlayer.setEnabled(false);
		FourPlayer.setEnabled(false);
		
		c1 = new Control(numberOfPlayers);
		
		while(!win){
		switch(player) {

		case(1):
			ShowText.setText(newLine + "Player 1 you can play now\n");
		
			switchPlayer(player,11,41,42,43,44);
			
			// test if there is a wiener
			if(c1.win(player)) {
				win = true;
				winner = player;
			}
			break;
			
		case(2):
			ShowText.setText(newLine + "Player 2 you can play now\n");
		
			switchPlayer(player,21,51,52,53,54);
		
			// test if there is a wiener
			if(c1.win(player)) {
				win = true;
				winner = player;
			}
			break;

		case(3):
			ShowText.setText(newLine + "Player 3 you can play now\n");
			
			switchPlayer(player,31,61,62,63,64);
			
			// test if there is a wiener
			if(c1.win(player)) {
				win = true;
				winner = player;
			}
			break;
			
		case(4):
			ShowText.setText(newLine + "Player 4 you can play now\n");
		
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
		ShowText.setText(newLine + "And the winner of this epic game is " + winner + "!" + newLine + "You did it! :)");
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
			ShowText.setText(newLine + "Please press 'roll' to roll: ");
	

			btnWuerfeln.setEnabled(true);
			while(btnWuerfeln.isEnabled()) {

			}
			run = c1.start();
			if(run != 0) {
				ShowText.setText(newLine + "Your first figure will put on field");

			} else {
				ShowText.setText(newLine + "You got no 6");
				return;
			}		

			c1.noFigureOnField(player);
		}
		
		//***************Just Roll********************************************//
		ShowText.setText(newLine + "Please press 'roll' to roll: ");
		//***************insert roll********************************************//
		btnWuerfeln.setEnabled(true);
		while(btnWuerfeln.isEnabled()) {

		}
		run = 0;
		int choice;
		while(run == 6 || run == 0) {
			boolean figureAtHome = false;
			run = c1.rolls();
			ShowText.setText(newLine + "You rolled a " + run);
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
							ShowText.setText(newLine + "You kill a Figure " + checking[1] + " from player " + checking[0] + "!");
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
				
				if(checking[0] == player ){
					ShowText.setText(newLine + "Your first field is blocked so this figure is chosen: " + checking[1]);
					choice = checking[1];
					checking = c1.fieldStatus(run,player,choice);
				} else {
					StringBuilder positions = new StringBuilder();
					for(int i = 1; i <= numberOfPlayers; i++) {
						for(int a = 1; a <= 4; a++) {
							if(c1.getPlayer(i).getFigure(a).isOnField())
							positions.append("Figure " + a + " from player " + i + " is on position " + c1.getPlayer(i).getFigure(a).getPosition() + "\n");
						}
					}
					ShowText.setText(newLine + positions);
					ShowText.setText(newLine + "Select figure you want to move (enter 1,2,3 or 4) or 0 if you want to skip your move: ");

					FigureOne.setEnabled(true);
					FigureTwo.setEnabled(true);
					FigureThree.setEnabled(true);
					FigureFour.setEnabled(true);
					
					while(numberOfPlayers != 2 && numberOfPlayers != 3 && numberOfPlayers != 4 ){
						
					}

					FigureOne.setEnabled(false);
					FigureTwo.setEnabled(false);
					FigureThree.setEnabled(false);
					FigureFour.setEnabled(false);
					
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
				
				while(checking[0] == player){
					log.info(newLine + "You can`t move figure " + choice + " because it`s blocked by your own figure " + checking[1]);
					choice = checking[1];
					checking = c1.fieldStatus(run,player,choice);
				}
				
				//check method
				if(run > (c1.getPlayer(player).getFigure(choice).getList().size()-4)){
					//*************************Figure not in End Position yet***********************
					if(c1.getPlayer(player).getFigure(choice).getPosition()<=40){
						checking = c1.field.getFieldStatus(endFieldOne);
						if(checking[0] == player){
							continue;
						}
						else{
							if(run <= (c1.getPlayer(player).getFigure(choice).getList().size()-3)){
								break;
							}
						}
						checking = c1.field.getFieldStatus(endFieldTwo);
						if(checking[0] != player){
							if(run <= (c1.getPlayer(player).getFigure(choice).getList().size()-2)){
								break;
							}
						}else{
							continue;
						}
						checking = c1.field.getFieldStatus(endFieldThree);
						if(checking[0] != player){
							if(run <= (c1.getPlayer(player).getFigure(choice).getList().size()-1)){
								break;
							}
						}else{
							continue;
						}
						checking = c1.field.getFieldStatus(endFieldFor);
						if(checking[0] != player){
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
						if(c1.getPlayer(player).getFigure(choice).getPosition() == endFieldTwo){
							checking = c1.field.getFieldStatus(endFieldThree);
							if(checking[0] == player){
								log.info(newLine + "You can't move, because there are too few fields!");
								continue;
							}
							checking = c1.field.getFieldStatus(endFieldFor);
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
						if(c1.getPlayer(player).getFigure(choice).getPosition() == endFieldOne){
							checking = c1.field.getFieldStatus(endFieldTwo);
							if(checking[0] == player){
								log.info(newLine + "You can't move, because there are too few fields!");
								continue;
							}
							checking = c1.field.getFieldStatus(endFieldThree);
							if(checking[0] == player){
								if(run != 1){
									log.info(newLine + "You can't move, because there are too few fields!");
									continue;
								}
								break;
							}
							checking = c1.field.getFieldStatus(endFieldFor);
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
