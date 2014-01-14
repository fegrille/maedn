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
	private static final int FIRSTFIGURE = 1;
	private static final int SECONDFIGURE = 2;
	private static final int THIRDFIGURE = 3;
	private static final int FOURTHFIGURE = 4;
	
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
			case(FIRSTPLAYER):
				playerList[i] = new Player("blue",a);
				a++;
				break;
			case(SECONDPLAYER):
				playerList[i] = new Player("green",a);
				a++;
				break;
			case(THIRDPLAYER):
				playerList[i] = new Player("yellow",a);
				a++;
				break;
			case(FOURTHPLAYER):
				playerList[i] = new Player("red",a);
				break;
			
			default:
				log.info(newLine + "Only 4 Players are possible");
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
	public void setPlayerfield(Player[] newPlayerList) {
		if(newPlayerList == null) { 
		    this.playerList = new Player[0]; 
		  } else { 
		   this.playerList = Arrays.copyOf(newPlayerList, newPlayerList.length); 
		  } 
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
		if(!getPlayer(FIRSTPLAYER).getFigure(FIRSTFIGURE).isOnField()){
			getPlayer(FIRSTPLAYER).getFigure(FIRSTFIGURE).putOnField();
			changeFieldStatus(FIRSTPLAYER , FIRSTFIGURE);
			setFigureOnField1(true);
			
		} else if (!getPlayer(FIRSTPLAYER).getFigure(SECONDFIGURE).isOnField()){
			getPlayer(FIRSTPLAYER).getFigure(SECONDFIGURE).putOnField();
			changeFieldStatus(FIRSTPLAYER , SECONDFIGURE);
			setFigureOnField1(true);
		} else if (!getPlayer(FIRSTPLAYER).getFigure(THIRDFIGURE).isOnField()){
			getPlayer(FIRSTPLAYER).getFigure(THIRDFIGURE).putOnField();
			changeFieldStatus(FIRSTPLAYER , THIRDFIGURE);
			setFigureOnField1(true);
		} else {
			getPlayer(FIRSTPLAYER).getFigure(FOURTHFIGURE).putOnField();
			changeFieldStatus(FIRSTPLAYER , FOURTHFIGURE);
			setFigureOnField1(true);
		}
	}
	
	@Override
	public void putGreenOnField() {
		if(!getPlayer(SECONDPLAYER).getFigure(FIRSTFIGURE).isOnField()){
			getPlayer(SECONDPLAYER).getFigure(FIRSTFIGURE).putOnField();
			changeFieldStatus(SECONDPLAYER , FIRSTFIGURE);
			setFigureOnField2(true);
		} else if (!getPlayer(SECONDPLAYER).getFigure(SECONDFIGURE).isOnField()){
			getPlayer(SECONDPLAYER).getFigure(SECONDFIGURE).putOnField();
			changeFieldStatus(SECONDPLAYER , SECONDFIGURE);
			setFigureOnField2(true);
		} else if (!getPlayer(SECONDPLAYER).getFigure(THIRDFIGURE).isOnField()){
			getPlayer(SECONDPLAYER).getFigure(THIRDFIGURE).putOnField();
			changeFieldStatus(SECONDPLAYER , THIRDFIGURE);
			setFigureOnField2(true);
		} else {
			getPlayer(SECONDPLAYER).getFigure(FOURTHFIGURE).putOnField();
			changeFieldStatus(SECONDPLAYER , FOURTHFIGURE);
			setFigureOnField2(true);
		}
	}
	
	@Override
	public void putYellowOnField() {
		if(!getPlayer(THIRDPLAYER).getFigure(FIRSTFIGURE).isOnField()){
			getPlayer(THIRDPLAYER).getFigure(FIRSTFIGURE).putOnField();
			changeFieldStatus(THIRDPLAYER , FIRSTFIGURE);
			setFigureOnField3(true);
		} else if (!getPlayer(THIRDPLAYER).getFigure(SECONDFIGURE).isOnField()){
			getPlayer(THIRDPLAYER).getFigure(SECONDFIGURE).putOnField();
			changeFieldStatus(THIRDPLAYER , SECONDFIGURE);
			setFigureOnField3(true);
		} else if (!getPlayer(THIRDPLAYER).getFigure(THIRDFIGURE).isOnField()){
			getPlayer(THIRDPLAYER).getFigure(THIRDFIGURE).putOnField();
			changeFieldStatus(THIRDPLAYER , THIRDFIGURE);
			setFigureOnField3(true);
		} else {
			getPlayer(THIRDPLAYER).getFigure(FOURTHFIGURE).putOnField();
			changeFieldStatus(THIRDPLAYER , FOURTHFIGURE);
			setFigureOnField3(true);
		}
	}
	
	@Override
	public void putRedOnField() {
		if(!getPlayer(FOURTHPLAYER).getFigure(FIRSTFIGURE).isOnField()){
			getPlayer(FOURTHPLAYER).getFigure(FIRSTFIGURE).putOnField();
			changeFieldStatus(FOURTHPLAYER , FIRSTFIGURE);
			setFigureOnField4(true);
		} else if (!getPlayer(FOURTHPLAYER).getFigure(SECONDFIGURE).isOnField()){
			getPlayer(FOURTHPLAYER).getFigure(SECONDFIGURE).putOnField();
			changeFieldStatus(FOURTHPLAYER , SECONDFIGURE);
			setFigureOnField4(true);
		} else if (!getPlayer(FOURTHPLAYER).getFigure(THIRDFIGURE).isOnField()){
			getPlayer(FOURTHPLAYER).getFigure(THIRDFIGURE).putOnField();
			changeFieldStatus(FOURTHPLAYER , THIRDFIGURE);
			setFigureOnField4(true);
		} else {
			getPlayer(FOURTHPLAYER).getFigure(FOURTHFIGURE).putOnField();
			changeFieldStatus(FOURTHPLAYER , FOURTHFIGURE);
			setFigureOnField4(true);
		}
	}
	//**********************Collidations****************************
	public int collidateOwnFigures(int figure, int player, int run, int[] checking) {
		int choice = figure;
		int[] check = checking;
		while(check[0] == player){
			log.info(newLine + "You can`t move figure " + choice + " because it`s blocked by your own figure " + check[1]);
			choice = check[1];
			check = fieldStatus(run,player,choice);
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
		int startOfEnd;
		int endOfEnd;
		switch(player) {

		case(FIRSTPLAYER):
			startOfEnd = 41;
			endOfEnd = 45;
			end = checkwin(startOfEnd,endOfEnd);
			break;
		case(SECONDPLAYER):
			startOfEnd = 51;
			endOfEnd = 55;
			end = checkwin(startOfEnd,endOfEnd);
			break;
		case(THIRDPLAYER):
			startOfEnd = 61;
			endOfEnd = 65;
			end = checkwin(startOfEnd,endOfEnd);
			break;
		case(FOURTHPLAYER):
			startOfEnd = 71;
			endOfEnd = 75;
			end = checkwin(startOfEnd,endOfEnd);
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

