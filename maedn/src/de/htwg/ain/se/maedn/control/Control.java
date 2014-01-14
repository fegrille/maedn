package de.htwg.ain.se.maedn.control;

import java.util.Arrays;
import java.util.logging.Logger;

import de.htwg.ain.se.maedn.fields.Fields;
import de.htwg.ain.se.maedn.kill.Kill;
import de.htwg.ain.se.maedn.player.Player;
import de.htwg.ain.se.maedn.roll.Roll;

public class Control implements Icontrol{

	//**********************Objects****************************
	private Roll doRoll = new Roll();
	private Kill killer = new Kill();
	
	private Player[] playerList;
	private Fields field = new Fields();


	//**********************variables****************************
	private static final int FIRSTPLAYER = 1;
	private static final int SECONDPLAYER = 2;
	private static final int THIRDPLAYER = 3;
	private static final int FOURTHPLAYER = 4;
	
	private boolean figureOnField1 = false;
	private boolean figureOnField2 = false;
	private boolean figureOnField3 = false;
	private boolean figureOnField4 = false;
	private final String newLine = System.getProperty("line.separator");
	private final Logger log = Logger.getLogger("htwgMaedn");
	
	//**********************Constructor****************************
	public Control(int numberOfPlayers) {
		int a = 1;
		playerList = new Player[numberOfPlayers];
		for(int i = 0; i < numberOfPlayers; i++) {
			switch(a) {
			case(1):
				playerList[i] = new Player("blue",a);
				a++;
				break;
			case(2):
				playerList[i] = new Player("green",a);
				a++;
				break;
			case(3):
				playerList[i] = new Player("yellow",a);
				a++;
				break;
			case(4):
				playerList[i] = new Player("red",a);
				break;
			
			default:
				System.out.println("Only 4 Players are possible");
				break;
			
			}
			
		}
		
	}
	//**********************Get Set****************************
	@Override
	public Player getPlayer(int place){
		return playerList[place -1];
	}
	
	@Override
	public void setPlayerfield(Player[] players) {
		if(players == null) { 
		    this.playerList = new Player[0]; 
		  } else { 
		   this.playerList = Arrays.copyOf(players, players.length); 
		  } 
		this.playerList = players;
	}
	
	public Fields getField() {
		return field;
	}
	public void setField(Fields field) {
		this.field = field;
	}
	//**********************No Figure on Field****************************
	@Override
	public void noFigureOnField(int player) {
		switch(player) {
			case(1):
				putBlueOnField();
			break;
			
			case(2):
				putGreenOnField();
			break;

			case(THIRDPLAYER):
				putYellowOnField();
			break;

			case(FOURTHPLAYER):
				putRedOnField();
			break;
				
			default:
				break;
		}
	}
	
	//**********************Is figure on Field?****************************
	@Override
	public boolean isFigureOnField1() {
		return figureOnField1;
	}

	//**********************Set Figures on field****************************
	@Override
	public void setFigureOnField1(boolean figureOnField1) {
		this.figureOnField1 = figureOnField1;
	}

	@Override
	public boolean isFigureOnField2() {
		return figureOnField2;
	}

	@Override
	public void setFigureOnField2(boolean figureOnField2) {
		this.figureOnField2 = figureOnField2;
	}

	@Override
	public boolean isFigureOnField3() {
		return figureOnField3;
	}

	@Override
	public void setFigureOnField3(boolean figureOnField3) {
		this.figureOnField3 = figureOnField3;
	}

	@Override
	public boolean isFigureOnField4() {
		return figureOnField4;
	}

	@Override
	public void setFigureOnField4(boolean figureOnField4) {
		this.figureOnField4 = figureOnField4;
	}

	
	//**********************put Figures on Field****************************
	@Override
	public void putBlueOnField() {
		if(!getPlayer(FIRSTPLAYER).getFigure(1).isOnField()){
			getPlayer(FIRSTPLAYER).getFigure(1).putOnField();
			changeFieldStatus(FIRSTPLAYER , 1);
			setFigureOnField1(true);
			
		} else if (!getPlayer(FIRSTPLAYER).getFigure(2).isOnField()){
			getPlayer(FIRSTPLAYER).getFigure(2).putOnField();
			changeFieldStatus(FIRSTPLAYER , 2);
			setFigureOnField1(true);
		} else if (!getPlayer(FIRSTPLAYER).getFigure(3).isOnField()){
			getPlayer(FIRSTPLAYER).getFigure(3).putOnField();
			changeFieldStatus(FIRSTPLAYER , 3);
			setFigureOnField1(true);
		} else {
			getPlayer(FIRSTPLAYER).getFigure(4).putOnField();
			changeFieldStatus(FIRSTPLAYER , 4);
			setFigureOnField1(true);
		}
	}
	
	@Override
	public void putGreenOnField() {
		if(!getPlayer(SECONDPLAYER).getFigure(1).isOnField()){
			getPlayer(SECONDPLAYER).getFigure(1).putOnField();
			changeFieldStatus(SECONDPLAYER , 1);
			setFigureOnField2(true);
		} else if (!getPlayer(SECONDPLAYER).getFigure(2).isOnField()){
			getPlayer(SECONDPLAYER).getFigure(2).putOnField();
			changeFieldStatus(SECONDPLAYER , 2);
			setFigureOnField2(true);
		} else if (!getPlayer(SECONDPLAYER).getFigure(3).isOnField()){
			getPlayer(SECONDPLAYER).getFigure(3).putOnField();
			changeFieldStatus(SECONDPLAYER , 3);
			setFigureOnField2(true);
		} else {
			getPlayer(SECONDPLAYER).getFigure(4).putOnField();
			changeFieldStatus(SECONDPLAYER , 4);
			setFigureOnField2(true);
		}
	}
	
	@Override
	public void putYellowOnField() {
		if(!getPlayer(THIRDPLAYER).getFigure(1).isOnField()){
			getPlayer(THIRDPLAYER).getFigure(1).putOnField();
			changeFieldStatus(THIRDPLAYER , 1);
			setFigureOnField3(true);
		} else if (!getPlayer(THIRDPLAYER).getFigure(2).isOnField()){
			getPlayer(THIRDPLAYER).getFigure(2).putOnField();
			changeFieldStatus(THIRDPLAYER , 2);
			setFigureOnField3(true);
		} else if (!getPlayer(THIRDPLAYER).getFigure(3).isOnField()){
			getPlayer(THIRDPLAYER).getFigure(3).putOnField();
			changeFieldStatus(THIRDPLAYER , 3);
			setFigureOnField3(true);
		} else {
			getPlayer(THIRDPLAYER).getFigure(4).putOnField();
			changeFieldStatus(THIRDPLAYER , 4);
			setFigureOnField3(true);
		}
	}
	
	@Override
	public void putRedOnField() {
		if(!getPlayer(FOURTHPLAYER).getFigure(1).isOnField()){
			getPlayer(FOURTHPLAYER).getFigure(1).putOnField();
			changeFieldStatus(FOURTHPLAYER , 1);
			setFigureOnField4(true);
		} else if (!getPlayer(FOURTHPLAYER).getFigure(2).isOnField()){
			getPlayer(FOURTHPLAYER).getFigure(2).putOnField();
			changeFieldStatus(FOURTHPLAYER , 2);
			setFigureOnField4(true);
		} else if (!getPlayer(FOURTHPLAYER).getFigure(3).isOnField()){
			getPlayer(FOURTHPLAYER).getFigure(3).putOnField();
			changeFieldStatus(FOURTHPLAYER , 3);
			setFigureOnField4(true);
		} else {
			getPlayer(FOURTHPLAYER).getFigure(4).putOnField();
			changeFieldStatus(FOURTHPLAYER , 4);
			setFigureOnField4(true);
		}
	}
	//**********************Collidations****************************
	public int collidateOwnFigures(int figure, int player, int run, int[] checking) {
		int choice = figure;
		while(checking[0] == player){
			choice = checking[1];
			checking = fieldStatus(run,player,choice);
		}
		return choice;
	}
	@Override
	public void collidateOtherFigures(int[] checking) {
		if(checking[0] > 0 && checking[0] < 5){
			log.info(newLine + "You kill a Figure " + checking[1] + " from player " + checking[0] + "!");
			playerList = killer.kill(playerList, checking[0], checking[1]);
		}
	}
	
	//**********************Initialisizing first Roll****************************
	@Override
	public int start () {
		return doRoll.firstRoll();
	}
	
	//**********************Initialisizing Roll****************************
	@Override
	public int rolls() {
		return doRoll.roll();
	}
	
	//**********************Test Field status****************************
	@Override
	public int[] fieldStatus(int numberRolled,int player, int figure){
		
		int newPosition = getPlayer(player).getFigure(figure).getList().get(numberRolled -1);
		int status[] = field.getFieldStatus(newPosition);
		
		return status;
	}
	
	//**********************Change fieldstatus************************************
	
	@Override
	public void changeFieldStatus(int player, int figure) {
		
		int[] information = new int[2];
		information[0] = player;
		information[1] = figure;
		field.setFieldStatus(getPlayer(player).getFigure(figure).getPosition(), information);
	}
	
	@Override
	public void deleteFieldStatus(int player, int figure) {
		int[] information = new int[2];
		information[0] = 0;
		information[1] = 0;
		field.setFieldStatus(getPlayer(player).getFigure(figure).getPosition(), information);
	}
	
	
	//**********************Check for win*****************************************
	
	@Override
	public boolean win(int player) {
		boolean end = true;
		switch(player) {
		case(1):
			end = checkwin(41,45);
			break;
		case(2):
			end = checkwin(51,55);
			break;
		case(3):
			end = checkwin(61,65);
			break;
		case(4):
			end = checkwin(71,75);
			break;
		}
		return end;
	}
	
	public boolean checkwin (int startOfEnd, int endOfEnd) {
		for(int i = startOfEnd; i < endOfEnd; i++) {
			int[] checking = field.getFieldStatus(i);
			if(checking[0] == 0) {
				return false;
			}
		}
		return true;
	}
	
}

