package de.htwg.ain.se.maedn;

import java.util.List;
import java.util.ArrayList;

public class Figure {
	private int position = 0;
	
	private List<Integer> fields = new ArrayList<Integer>();
	private boolean onField = false;
	private static final int THIRDCASE = 3;
	private static final int FOURTHCASE = 4;
	private static final int ENDPOSITIONYELLOW = 30;
	private static final int ENDPOSITIONGREEN = 20;
	private static final int ENDPOSITIONBLUE = 10;
	private static final int ENDPOSITIONRED = 40;
	private static final int STARTOFBLUE = 11;
	private static final int STARTOFYELLOW = 31;
	private static final int STARTOFGREEN = 21;
	
	public Figure(final int player) {
		switch(player) {
		case(1):
			for(int i = STARTOFBLUE; i <= ENDPOSITIONRED; i++){
				fields.add(i);
			}
			for(int i = 1; i <= ENDPOSITIONBLUE; i++) {
				fields.add(i);
			}
			for(int i = 41; i < 45; i++) {
				fields.add(i);
			}
			break;
		case(2):
			
			for(int i = STARTOFGREEN; i <= ENDPOSITIONRED; i++){
				fields.add(i);
			}
			for(int i = 1; i <= ENDPOSITIONGREEN; i++) {
				fields.add(i);
			}
			for(int i = 51; i < 55; i++) {
				fields.add(i);
			}
			break;
		case(THIRDCASE):

			for(int i = STARTOFYELLOW; i <= ENDPOSITIONRED; i++){
				fields.add(i);
			}
			for(int i = 1; i <= ENDPOSITIONYELLOW; i++) {
				fields.add(i);
			}
			for(int i = 61; i < 65; i++) {
				fields.add(i);
			}
			break;
		case(FOURTHCASE):
			
			for(int i = 1; i <= ENDPOSITIONRED; i++){
				fields.add(i);
			}
			for(int i = 71; i < 75; i++) {
				fields.add(i);
			}
			break;
		}
	}
	public void setPosition() {
		this.position = fields.remove(0);
	}
	
	public int getPosition() {
		return position;
	}
	
	public void move(int roll) {
		if(roll < fields.size()) {
			for(int i = 0; i < roll; i++){
				if(!fields.isEmpty()) {
					setPosition();
				} 
			}
		}
	}
	
	public void putOnField() {
		setOnField(true);
		setPosition();
	}
	
	public void kickFromField() {
		setOnField(false);
	}
	
	public boolean isOnField() {
		return onField;
	}
	public void setOnField(boolean onField) {
		this.onField = onField;
	}
	
	//**********************Get List, Set List****************************
	public List<Integer> getList(){
		return fields;
	}
	
	public void setList(List<Integer> newList){
		fields = newList;
	}
}
