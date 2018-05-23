package fr.battleship;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import gayet.simon.Eazy;
import gayet.simon.Game;
import gayet.simon.Hard;
import gayet.simon.IPlayer;
import gayet.simon.Medium;
import gayet.simon.Shoots;

public class TestIA {
	
	
	public static void main(String[] args) {
		
		
		//csv file 
		//creation of file
		File file = new File(System.getProperty("user.dir") + File.separator + "ai_proof.csv");
		try {
			file.createNewFile();
			
		} catch(IOException e){
			System.out.println("error, file creation fail ");
			System.out.println("Perhaps, file already exist");
		}
		System.out.println("Le fichier ai_proof.csv est à la racine du projet");
		
		//Delimiter 
	    String DELIMITER = File.pathSeparator;
	    String NEW_LINE_SEPARATOR = "\n";

	    //file header
	    
	    
	    
		IPlayer plyr1 = new Eazy(1);
		IPlayer plyr2 = new Medium(2);
		
		Game gm = new Game(plyr1,plyr2,plyr1);
		int i = 0;
		int winPlyr11 = 0;
		int winPlyr21 = 0;
		while (i<100){
			
			gm.getCurrentplr().setShoots(new Shoots());
			gm.getCurrentplr().initFleet();
			gm.changeCurrentPlr();
			gm.getCurrentplr().setShoots(new Shoots());
			gm.getCurrentplr().initFleet();
			
			//choose beginer
			gm.setCurrentplr(gm.getBeginer());
			boolean finish = false;
			while (!finish){
				gm.getCurrentplr().generateShoot(gm.getOtherIPlayer());
				gm.changeCurrentPlr();
				finish = gm.getCurrentplr().getFleet().isDestroyFleet();
			}
			gm.changeCurrentPlr();
			if (gm.getCurrentplr().getNb() == 1){
				winPlyr11++;
			}
			else {
				winPlyr21++;
			}
			gm.changeBeginer();
			i++;
		}
		System.out.println("Game 1 " + plyr1.getName() + " againts " + plyr2.getName()); 
		System.out.println("For 100 game player " + plyr1.getName() + " win " + winPlyr11);
		System.out.println("For 100 game player " + plyr2.getName() + " win " + winPlyr21);
		
		
		plyr1 = new Eazy(1);
		plyr2 = new Hard(2);
		
		gm = new Game(plyr1,plyr2,plyr1);
		i = 0;
		int winPlyr12 = 0;
		int winPlyr22 = 0;
		while (i<100){
			
			gm.getCurrentplr().setShoots(new Shoots());
			gm.getCurrentplr().initFleet();
			gm.changeCurrentPlr();
			gm.getCurrentplr().setShoots(new Shoots());
			gm.getCurrentplr().initFleet();
			
			//choose beginer
			gm.setCurrentplr(gm.getBeginer());
			boolean finish = false;
			while (!finish){
				gm.getCurrentplr().generateShoot(gm.getOtherIPlayer());
				gm.changeCurrentPlr();
				finish = gm.getCurrentplr().getFleet().isDestroyFleet();
			}
			gm.changeCurrentPlr();
			if (gm.getCurrentplr().getNb() == 1){
				winPlyr12++;
			}
			else {
				winPlyr22++;
			}
			gm.changeBeginer();
			i++;
		}
		System.out.println("Game 2 " + plyr1.getName() + " againts " + plyr2.getName()); 
		System.out.println("For 100 game player " + plyr1.getName() + " win " + winPlyr12);
		System.out.println("For 100 game player " + plyr2.getName() + " win " + winPlyr22);

		
		plyr1 = new Medium(1);
		plyr2 = new Hard(2);
		
		gm = new Game(plyr1,plyr2,plyr1);
		i = 0;
		int winPlyr13 = 0;
		int winPlyr23 = 0;
		while (i<100){
			
			gm.getCurrentplr().setShoots(new Shoots());
			gm.getCurrentplr().initFleet();
			gm.changeCurrentPlr();
			gm.getCurrentplr().setShoots(new Shoots());
			gm.getCurrentplr().initFleet();
			
			//choose beginer
			int j = 0;
			gm.setCurrentplr(gm.getBeginer());
			boolean finish = false;
			while (!finish){
				gm.getCurrentplr().generateShoot(gm.getOtherIPlayer());
				gm.changeCurrentPlr();
				finish = gm.getCurrentplr().getFleet().isDestroyFleet();
				j++;
			}
			gm.changeCurrentPlr();
			if (gm.getCurrentplr().getNb() == 1){
				winPlyr13++;
			}
			else {
				winPlyr23++;
			}
			gm.changeBeginer();
			i++;
			System.out.println(j);
		}
		System.out.println("Game 3 " + plyr1.getName() + " againts " + plyr2.getName()); 
		System.out.println("For 100 game player " + plyr1.getName() + " win " + winPlyr13);
		System.out.println("For 100 game player " + plyr2.getName() + " win " + winPlyr23);
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
		    fileWriter.append("AI Name");
		    fileWriter.append(DELIMITER);
		    fileWriter.append("score");
		    fileWriter.append(DELIMITER);
		    fileWriter.append("AI Name2");
		    fileWriter.append(DELIMITER);
		    fileWriter.append("score2");
		    fileWriter.append(NEW_LINE_SEPARATOR);
		    
		    
		    fileWriter.append("AI Level Beginner");
		    fileWriter.append(DELIMITER);
		    fileWriter.append(String.valueOf(winPlyr11));
		    fileWriter.append(DELIMITER);
		    fileWriter.append("Level Medium");
		    fileWriter.append(DELIMITER);
		    fileWriter.append(String.valueOf(winPlyr21));
		    fileWriter.append(NEW_LINE_SEPARATOR);
		    
		    fileWriter.append("AI Level Beginner");
		    fileWriter.append(DELIMITER);
		    fileWriter.append(String.valueOf(winPlyr12));
		    fileWriter.append(DELIMITER);
		    fileWriter.append("Level Hard");
		    fileWriter.append(DELIMITER);
		    fileWriter.append(String.valueOf(winPlyr22));
		    fileWriter.append(NEW_LINE_SEPARATOR);
		    
		    fileWriter.append("AI Level Medium");
		    fileWriter.append(DELIMITER);
		    fileWriter.append(String.valueOf(winPlyr13));
		    fileWriter.append(DELIMITER);
		    fileWriter.append("Level Hard");
		    fileWriter.append(DELIMITER);
		    fileWriter.append(String.valueOf(winPlyr23));
		    fileWriter.append(NEW_LINE_SEPARATOR);

		} catch(Exception e){
			System.out.println("error in file writter");
			e.printStackTrace();
	    } finally {
	        try {
	            //fileWriter.flush(); close do flushing
	            fileWriter.close();
	        } catch (IOException e) {
	            System.out.println("Error flushing/closing fileWriter !!!");
	            e.printStackTrace();
	        }
	    }

	}

}
