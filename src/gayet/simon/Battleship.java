package gayet.simon;

import java.util.Scanner;

//les class map, shoots, fleet devrait extend de partie
//elle ne devrait pas avoir d'attribut de partie fixe comme la taille de la map 

// on a un prof qui nous fesait taper tout le code main puis a partir des erreur on creait les classes, bonne ou mauvaise idee? 
public class Battleship {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//Coordinate coord1 = new Coordinate("A0");
		//Coordinate coord2 = new Coordinate("A4");
		/*Coordinate shoot = new Coordinate("J9"); 
		Coordinate shoot1 = new Coordinate("H9");
		Coordinate shoot2 = new Coordinate("C7");
		Coordinate shoot3 = new Coordinate("I9");*/
		
		/* test boat creation
		Ship s1 = new Ship(coord1,coord2);
		System.out.println(s1.toString()); 
		*/
		
		/* test shoot boat
		System.out.print(s1.toString());
		Boolean toucher = s1.isHit(shoot); 
		System.out.println(toucher.toString());
		s1.boatHitRecord(shoot);
		System.out.println(s1.isDestroy());
		
		System.out.print(s1.toString());
		Boolean toucher1 = s1.isHit(shoot1); 
		System.out.println(toucher.toString());
		s1.boatHitRecord(shoot1);
		System.out.println(s1.isDestroy());
		
		System.out.print(s1.toString());
		Boolean toucher2 = s1.isHit(shoot2); 
		System.out.println(toucher2.toString());
		System.out.println(s1.isDestroy());
		
		System.out.print(s1.toString());
		Boolean toucher3 = s1.isHit(shoot3); 
		System.out.println(toucher3.toString());
		s1.boatHitRecord(shoot3);
		System.out.println(s1.isDestroy());
		
		System.out.print(s1.toString());*/
		
		// test map // 
		/*
		Map mptest = new Map();
		mptest.printMap();
		mptest.addBoat(s1);
		mptest.printMap();
		//Coordinate tst1 = new Coordinate("A2");
		//mptest.getBox(tst1);
		 */
		
		/*Coordinate coord3 = new Coordinate("B0");
		Shoots plyr1Sht = new Shoots();
		plyr1Sht.addShoot(coord2);
		System.out.println(plyr1Sht.getShootsList().size()); 
		plyr1Sht.addShoot(coord1);
		System.out.println(plyr1Sht.getShootsList().size());
		System.out.println(plyr1Sht.alreadyContains(coord3));*/
		/*plyr1Sht.addShoot(coord1);
		System.out.println(plyr1Sht.getShootsList().size());
		System.out.println(plyr1Sht.getShootsList().get(2).toString());
		*/
		
		/*plyr1Sht.addShoot(coord3);
		System.out.println(plyr1Sht.getShootsList().size());
		plyr1Sht.printShoot(); */
		
		
		/*
		//Player test all 
		Coordinate coord1 = new Coordinate("B1");
		Coordinate coord2 = new Coordinate("F1");
		Ship shp1 =new Ship(coord1,coord2);
				
		Coordinate coord5 = new Coordinate("E2");
		Coordinate coord6 = new Coordinate("E5");
		Ship shp2 =new Ship(coord5,coord6);
		
		Coordinate coord3 = new Coordinate("C5");
		Coordinate coord4 = new Coordinate("E5");
		Ship shp3 =new Ship(coord3,coord4);
		
		Coordinate coord7 = new Coordinate("C4");
		Coordinate coord8 = new Coordinate("C6");
		Ship shp4 =new Ship(coord7,coord8);
		
		Coordinate coord9 = new Coordinate("H6");
		Coordinate coord10 = new Coordinate("H7");
		Ship shp5 =new Ship(coord9,coord10);
		
		
		System.out.println("here");
		Fleet flt1 = new Fleet();
		flt1.AddShip(shp1);
		System.out.println(flt1.alreadyContains(shp2));
		flt1.AddShip(shp2);
		System.out.println(flt1.alreadyContains(shp3));
		flt1.AddShip(shp3);
		System.out.println(flt1.alreadyContains(shp4));
		flt1.AddShip(shp4);
		flt1.AddShip(shp5);
		System.out.println(flt1.printFleet());
		*/
		/*Map mp = new Map();
		mp.addBoat(shp1);
		mp.addBoat(shp2);
		mp.addBoat(shp3);
	    mp.addBoat(shp4);
		mp.addBoat(shp5);
		mp.printMap();
		 
		// test fleet for shp1 shp2
		Coordinate coord11 = new Coordinate("B0");
		Coordinate coord12 = new Coordinate("C0");
		Coordinate coord13 = new Coordinate("D0");
		Coordinate coord14 = new Coordinate("B9");
		Coordinate coord15 = new Coordinate("C9");
		System.out.println(flt1.toString());
		flt1.shootFleet(coord11);
		flt1.shootFleet(coord12);
		System.out.println(flt1.shootFleet(coord13));
		flt1.shootFleet(coord14);
		flt1.shootFleet(coord15);
		flt1.shootFleet(coord1);
		flt1.shootFleet(coord2);
		System.out.println(flt1.printFleet());
		System.out.println(flt1.shootFleet(coord5));
		System.out.println(flt1.printFleet());
		flt1.shootFleet(coord6);
		System.out.println(flt1.printFleet());/*
		System.out.println(flt1.toString());
		
		System.out.println(flt1.toString());
		
		Shoots shts = new Shoots();
		shts.addShoot(coord11);
		shts.addShoot(coord12);
		shts.addShoot(coord13);
		shts.addShoot(coord14);
		shts.addShoot(coord15);
		
		shts.printShoot();
		Player plyr1 = new Player(1,mp,shts,flt1);
		plyr1.getMap().printMap();
		System.out.println(plyr1.getFleet().isDestroyFleet());
		System.out.println(plyr1.toString());
		*/
		/*
		Coordinate coord1 = new Coordinate("B1");
		Coordinate coord2 = new Coordinate("F1");
		Ship shp1 =new Ship(coord1,coord2,true);
		Shoots sht = new Shoots();
		Fleet flt1 = new Fleet();
		
		plyr1.setFleet(flt1);
		
		gm.getCurrentplr().getFleet().AddShip(shp1);
		gm.changeCurrentPlr();
		gm.getCurrentplr().setShoots(sht);
		
		gm.playerShoot();*/
		
		/*
		Shoots sht = new Shoots();
		Coordinate coord1 = new Coordinate("B1");
		Coordinate coord2 = new Coordinate("F1");
		
		sht.addShoot(coord1);
		sht.addShoot(coord2);
		System.out.println(sht.printShoot());
		
		Coordinate coord3 = new Coordinate("B1");
		sht.addShoot(coord3);
		System.out.println(sht.printShoot()); */
		
		// test IA fleet
		/*
		IA test = new IA(1);
		IA test2 = new IA(1);
		Game gm = new Game(test,test2,test);
		System.out.println(test.generateCoord());
		System.out.println(test.generateCoord());
		System.out.println(test.generateShip(5));
		System.out.println(test.generateShip(4));
		
		test.initFleet();
		System.out.println("la");
		System.out.println(test.getFleet().printFleet());
		*/

		System.out.println("Hello, you are on battle ship game :");
		System.out.println("Please choose name : ");
		String str = sc.nextLine();
		IPlayer plyr1 = new Human(1,str);
		System.out.println("You are player one ");
		System.out.println("You want play against : 1 Human, 2 IA Eazy, 3 IA Medium, 4 IA Hard ?");
		System.out.println("enter your choice :");
		IPlayer plyr2 = chooseOpponent();
		
		Game gm = new Game(plyr1,plyr2,plyr1);
		boolean playAgain = true;
		while (playAgain){

			System.out.println("Player " + gm.getCurrentplr().getName() + " will initialise her fleet \n");
			gm.getCurrentplr().setShoots(new Shoots());
			gm.getCurrentplr().initFleet();
			System.out.println(gm.getCurrentplr().getFleet().printFleet());
			gm.changeCurrentPlr();
			System.out.println("Player " + gm.getCurrentplr().getName() + " will initialise her fleet \n");
			gm.getCurrentplr().setShoots(new Shoots());
			gm.getCurrentplr().initFleet();
			System.out.println(gm.getCurrentplr().getFleet().printFleet());
			
			//choose beginer
			gm.setCurrentplr(gm.getBeginer());
			boolean finish = false;
			while (!finish){
				System.out.println("Player " + gm.getCurrentplr().getName() + " will choose shoot \n");
				System.out.println("Your shoot");
				System.out.println(gm.getCurrentplr().getShoots().printShoot());
				System.out.println("Your fleet");
				System.out.println(gm.getCurrentplr().getFleet().printFleet());
				gm.getCurrentplr().generateShoot(gm.getOtherIPlayer());
				gm.changeCurrentPlr();
				finish = gm.getCurrentplr().getFleet().isDestroyFleet();
			}
			gm.changeCurrentPlr();
			System.out.println("Player " + gm.getCurrentplr().getName() + " n° " + gm.getCurrentplr().getNb() + " Win battleShip in ");
			System.out.println("You want play again? : enter yes or not ");
			playAgain = chooseEndGame();
			gm.changeBeginer();
			
		}

	
	}
	
	private static boolean chooseEndGame() {
		boolean res = false;
		boolean rightInstruction = false;
		while (!rightInstruction){
			String str = sc.nextLine();
			switch (str)
			{
			  case "yes": {
			    System.out.println("you replay");
			    rightInstruction = true;
			    res = true;
			    break;
			  }
			  case "not": {
			    System.out.println("It's end of game");
			    rightInstruction = true;
			    res = false;
			    break;
			  }
			  default:{
			    System.out.println("Your answer is wrong please choose again : yes or not");
			  }
			}
		}
		return res;
	}

	public static IPlayer chooseOpponent(){
		IPlayer plyr2 = null;
		boolean rightInstruction = false;
		while (!rightInstruction){
			String str = sc.nextLine();
			switch (str)
			{
			  case "1": {
			    System.out.println("Human vs Human");
			    System.out.println("Please player 2 choose name :");
				str = sc.nextLine();
			    rightInstruction = true;
			     plyr2 = new Human(2,str);
			    break;
			  }
			  case "2": {
			    System.out.println("Human vs Eazy");
			    rightInstruction = true;
			     plyr2 = new Eazy(2);
			    break;
			  }
			  case "3": {
			    System.out.println("Human vs Medium");
			    rightInstruction = true;
			     plyr2 = new Medium(2);
			    break;
			  }
			  case "4":{
				System.out.println("Human vs Hard");
				rightInstruction = true;
				 plyr2 = new Hard(2);
			    break;
			  }
			  default:{
			    System.out.println("Your answer is wrong please choose again :");
			  }
			}
		}
		return plyr2;
	}

}
