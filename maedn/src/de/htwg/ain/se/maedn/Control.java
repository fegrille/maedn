package de.htwg.ain.se.maedn;

public class Control {

	

	//**********************Objects****************************
	private Roll doRoll = new Roll();
	private Kill killer = new Kill();
	
	private Player[] playerList;
	Fields field = new Fields();
	
	//**********************variables****************************
	private static final int FIRSTPLAYER = 1;
	private static final int SECONDPLAYER = 2;
	private static final int THIRDPLAYER = 3;
	private static final int FOURTHPLAYER = 4;
	
	private boolean figureOnField1 = false;
	private boolean figureOnField2 = false;
	private boolean figureOnField3 = false;
	private boolean figureOnField4 = false;

	
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
	Player getPlayer(int place){
		return playerList[place -1];
	}
	
	public void setPlayerfield(Player[] playerList) {
		this.playerList = playerList;
	}
	
	//**********************No Figure on Field****************************
	void noFigureOnField(int player) {
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
	public boolean isFigureOnField1() {
		return figureOnField1;
	}

	//**********************Set Figures on field****************************
	public void setFigureOnField1(boolean figureOnField1) {
		this.figureOnField1 = figureOnField1;
	}

	public boolean isFigureOnField2() {
		return figureOnField2;
	}

	public void setFigureOnField2(boolean figureOnField2) {
		this.figureOnField2 = figureOnField2;
	}

	public boolean isFigureOnField3() {
		return figureOnField3;
	}

	public void setFigureOnField3(boolean figureOnField3) {
		this.figureOnField3 = figureOnField3;
	}

	public boolean isFigureOnField4() {
		return figureOnField4;
	}

	public void setFigureOnField4(boolean figureOnField4) {
		this.figureOnField4 = figureOnField4;
	}

	
	//**********************put Figures on Field****************************
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
	public boolean collidateOwnFigures(final int[] fieldinfo, int player) {
		return true;
	}
	public boolean collidateOtherFigures(final int[] fieldinfo) {
		
		playerList = killer.kill(playerList, fieldinfo[0], fieldinfo[1]);
		return true;
	}
	
	//**********************Initialisizing first Roll****************************
	public int start () {
		return doRoll.firstRoll();
	}
	
	//**********************Initialisizing Roll****************************
	public int rolls() {
		return doRoll.roll();
	}
	
	//**********************Test Field status****************************
	public int[] fieldStatus(int numberRolled,int player, int figure){
		
		int newPosition = getPlayer(player).getFigure(figure).getList().get(numberRolled -1);
		int status[] = field.getFieldStatus(newPosition);
		
		return status;
	}
	
	//**********************Test rest figure move size****************************
	
	
	
	
	//**********************Change fieldstatus************************************
	
	public void changeFieldStatus(int player, int figure) {
		
		int[] information = new int[2];
		information[0] = player;
		information[1] = figure;
		field.setFieldStatus(getPlayer(player).getFigure(figure).getPosition(), information);
	}
	
	public void deleteFieldStatus(int player, int figure) {
		int[] information = new int[2];
		information[0] = 0;
		information[1] = 0;
		field.setFieldStatus(getPlayer(player).getFigure(figure).getPosition(), information);
	}
	
	
	//**********************Check for win*****************************************
	
	public boolean win(int player) {
		boolean end = true;
		switch(player) {
		case(1):
			for(int i = 41; i < 45; i++) {
				int[] checking = field.getFieldStatus(i);
				if(checking[0] == 0) {
					end = false;
				}
			}
			break;
		case(2):
			for(int i = 51; i < 55; i++) {
				int[] checking = field.getFieldStatus(i);
				if(checking[0] == 0) {
					end = false;
				}
			}
			break;
		case(3):
			for(int i = 61; i < 65; i++) {
				int[] checking = field.getFieldStatus(i);
				if(checking[0] == 0) {
					end = false;
				}
			}
			break;
		case(4):
			for(int i = 71; i < 75; i++) {
				int[] checking = field.getFieldStatus(i);
				if(checking[0] == 0) {
					end = false;
				}
			}
			break;
		}
		return end;
	}
	
	
}

