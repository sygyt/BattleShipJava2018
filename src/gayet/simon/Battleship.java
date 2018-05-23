package gayet.simon;

import java.util.Scanner;

public class Battleship {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
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
