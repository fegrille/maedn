package de.htwg.ain.se.maedn.start;


import java.util.Scanner;
import java.util.logging.Logger;



import de.htwg.ain.se.maedn.tui.TUI;

public class StartClass {

	public static void main(String[] args) {
		
		final String newLine = System.getProperty("line.separator");
		final Logger log = Logger.getLogger("htwgMaedn");
		
		log.info(newLine + "Please insert Tui or Gui: ");

		Scanner scan = new Scanner(System.in);
		String s = scan.next(); 
	
		while(!s.equals("Tui") && !s.equals("Gui")){
			log.info(newLine + "Please insert Tui or Gui: ");
			s = scan.next();
		}
		
		if(s.equals("Tui")){
			TUI.getInstance().TUIstart();
		}else if(s.equals("Gui")){
			
		}
		scan.close();
	}

}
