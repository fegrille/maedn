package de.htwg.ain.se.maedn.figure;

import java.util.List;
import java.util.ArrayList;

public class Figure implements Ifigure{
	
	//**********************Objects****************************
	private List<Integer> fields = new ArrayList<Integer>();
	
	//**********************Variables****************************
	private int position = 0;
	private boolean onField = false;
	
	//**********************Constances****************************
	private static final int THIRDCASE = 3;
	private static final int FOURTHCASE = 4;
	private static final int ENDPOSITIONYELLOW = 30;
	private static final int ENDPOSITIONGREEN = 20;
	private static final int ENDPOSITIONBLUE = 10;
	private static final int ENDPOSITIONRED = 40;
	private static final int STARTOFBLUE = 11;
	private static final int STARTOFYELLOW = 31;
	private static final int STARTOFGREEN = 21;
	
	//**********************Constructor****************************
	public Figure(final int player) {
		switch(player) {
		case(1):
			addFields(STARTOFBLUE,ENDPOSITIONRED);
			addFields(1,ENDPOSITIONBLUE); 
			addFields(41,45);
			break;
		case(2):
			
			addFields(STARTOFGREEN,ENDPOSITIONRED);
			addFields(1,ENDPOSITIONGREEN);
			addFields(51, 55);
			break;
		case(THIRDCASE):

			addFields(STARTOFYELLOW,ENDPOSITIONRED);
			addFields(1,ENDPOSITIONYELLOW);
			addFields(61,65);
			break;
		case(FOURTHCASE):
			
			addFields(1,ENDPOSITIONRED);
			addFields(71,75);
			break;
		}
	}
	
	//**********************Get Position, Set Position****************************
	@Override
	public void setPosition() {
		this.position = fields.remove(0);
	}

	@Override
	public int getPosition() {
		return position;
	}
	
	//**********************Move****************************
	@Override
	public void move(int roll) {
		for(int i = 0; i < roll; i++){
			if(!fields.isEmpty()) {
				setPosition();
			} 
		}
	}
	
	//**********************PutOnField****************************
	@Override
	public void putOnField() {
		setOnField(true);
		setPosition();
	}
	
	//**********************KickFromField****************************
	@Override
	public void kickFromField() {
		setOnField(false);
	}
	
	//**********************Get onField, Set onField****************************
	@Override
	public boolean isOnField() {
		return onField;
	}
	
	@Override
	public void setOnField(boolean onField) {
		this.onField = onField;
	}
	
	//**********************Get List, Set List****************************
	@Override
	public List<Integer> getList(){
		return fields;
	}
	
	@Override
	public void setList(List<Integer> newList){
		fields = newList;
	}
	
	public void addFields(int start, int end) {
		for(int i = start; i <= end; i++){
			fields.add(i);
		}
	}
}
