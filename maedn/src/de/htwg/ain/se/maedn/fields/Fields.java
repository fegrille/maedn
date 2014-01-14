package de.htwg.ain.se.maedn.fields;

import java.util.Map;
import java.util.TreeMap;

public class Fields implements Ifields{
	
	//**********************Objects****************************
	Map<Integer,Integer[]> allFields = new TreeMap<>();
	
	//**********************Constructor****************************
	public Fields() {
		for(int i = 1; i <= 40; i++) {
			Integer[] a = new Integer[2];
			a[0] = 0;
			a[1] = 0;
			allFields.put(i,a);
		}
		for(int i = 41; i < 45; i++) {
			Integer[] a = new Integer[2];
			a[0] = 0;
			a[1] = 0;
			allFields.put(i,a);
		}
		for(int i = 51; i < 55; i++) {
			Integer[] a = new Integer[2];
			a[0] = 0;
			a[1] = 0;
			allFields.put(i,a);
		}
		for(int i = 61; i < 65; i++) {
			Integer[] a = new Integer[2];
			a[0] = 0;
			a[1] = 0;
			allFields.put(i,a);
		}
		for(int i = 71; i < 75; i++) {
			Integer[] a = new Integer[2];
			a[0] = 0;
			a[1] = 0;
			allFields.put(i,a);
		}
	}

	//**********************Get Fieldstatus, Set Fieldstatus****************************
	@Override
	public void setFieldStatus(int number, Integer[] figure){
		allFields.put(number, figure);		
	}

	@Override
	public Integer[] getFieldStatus(int number){
		
		return allFields.get(number);
		
	}
	
}
