package de.htwg.ain.se.maedn.start;


import java.util.Scanner;



import de.htwg.ain.se.maedn.tui.TUI;

public class StartClass {

	public static void main(String[] args) {
		
			System.out.println("Insert Tui or Gui");
			Scanner scan = new Scanner(System.in);
			String s = scan.next(); 
			
			if(s.equals("Tui")){
				TUI.getInstance().TUIstart();
			}else if(s.equals("Gui")){
				
			}else{
				System.out.println("You made a wrong input so it starts the Gui");
				
			}
			scan.close();
	}

}
