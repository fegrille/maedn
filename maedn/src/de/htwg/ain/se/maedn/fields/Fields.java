package de.htwg.ain.se.maedn.fields;

import java.util.TreeMap;

public class Fields implements Ifields{
	
	//**********************Objects****************************
	private TreeMap<Integer,int[]> allFields = new TreeMap<Integer,int[]>();
	
	//**********************Constructor****************************
	public Fields() {
		for(int i = 1; i <= 40; i++) {
			allFields.put(i,createfield());
		}
		for(int i = 41; i < 45; i++) {
			allFields.put(i,createfield());
		}
		for(int i = 51; i < 55; i++) {
			allFields.put(i,createfield());
		}
		for(int i = 61; i < 65; i++) {
			allFields.put(i,createfield());
		}
		for(int i = 71; i < 75; i++) {
			allFields.put(i,createfield());
		}
	}

	//**********************Get Fieldstatus, Set Fieldstatus****************************
	@Override
	public void setFieldStatus(int number, int[] figure){
		allFields.put(number, figure);		
	}

	@Override
	public int[] getFieldStatus(int number){
		
		return allFields.get(number);
		
	}
	
	private int[] createfield() {
		return newfield();
	}
	
	@Override
	public int[] newfield() {
		int[] a = null;
		a[0] = 0;
		a[1] = 0;
		return a;
	}
}
