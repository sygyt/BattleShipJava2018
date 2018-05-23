package gayet.simon;

import java.util.Scanner;

public class Human implements IPlayer {
	
	private String name;
	private int nb;	
	private Fleet fleet;
	private Shoots shoots;
	
	
	public Human(int nb, String name) {
		super();
		this.nb = nb;
		this.shoots = new Shoots();
		this.name = name;
	}
	
	
	public int getNb() {
		return nb;
	}
	
	public String getName(){
		return name;
	}
	
	public void setNb(int nb) {
		this.nb = nb;
	}

	public Fleet getFleet() {
		return fleet;
	}
	
	public void setFleet(Fleet fleet) {
		this.fleet = fleet;
	}

	public Shoots getShoots() {
		return shoots;
	}

	public void setShoots(Shoots shoots) {
		this.shoots = shoots;
	}


	public Coordinate generateCoord() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Coordinate res;
		if ((str.length()==2) && isRightCoord(str.charAt(0),Game.columnChar) && isRightCoord(str.charAt(1),Game.lineChar)){
			res = new Coordinate(str);
		}
		else {
			System.out.println("Sorry you not writte good coordinate, please can restart? \n");
			res = generateCoord();
		}
		return res; 
	}
	

	public Ship generateShip(int lenght) {
		System.out.println("Write first coordinate of your ship : ");
		Coordinate c1 = generateCoord();
		System.out.println("Write last coordinate of your ship : ");
		Coordinate c2 = generateCoord();
		Ship shp;
		int linC1Gap = c1.lineGap(c2);
		int colC1Gap = c1.colunnGap(c2);
		if ((linC1Gap == (lenght - 1)) && (colC1Gap == 0)){
			shp = new Ship(c1,c2);
		}
		else{
			if ((colC1Gap == (lenght - 1)) && (linC1Gap == 0)){
			shp = new Ship(c1,c2);
			}
			else {
				System.out.println("Fail, your ship is possibly too lenght or last coordinate is more small than first ");
				System.out.println("Please restart with good coordinate \n");
				shp = generateShip(lenght);
			}
		}
		return shp; 
	}

	
	public void initFleet() {
		Fleet fleet = new Fleet();
		System.out.println(fleet.printFleet());
	    for (ShipsTypes shipType : ShipsTypes.values()){ 
			System.out.println("Please in first can you create a " + shipType +  " ship, it has lenght of " + shipType.getSize());
			Ship carrier = generateShip(shipType.getSize());
			while (fleet.alreadyContains(carrier)){
				System.out.println("Sorry you give ship which is already in your fleet ");
				System.out.println("Please can you create a " + shipType + " ship, it has lenght of " + shipType.getSize() + "\n");
				carrier = generateShip(shipType.getSize());
			}
			fleet.AddShip(carrier);
			System.out.println(shipType + " ship has been added to fleet");
			System.out.println("Fleet created: ");
			System.out.println(fleet.printFleet());
			
	    }
	    this.fleet = fleet;
	}

	
	public void generateShoot(IPlayer plyr){
		System.out.println("Write coordinate of your shoot : \n");
		Coordinate c1 = generateCoord();
		int result = plyr.getFleet().shootFleet(c1);
		if (result == 0){
			System.out.println("Your shoot fall in water");
		}
		else {
			if (result == 1) {
				System.out.println("Your shoot touch ship");
			}
			else {
				System.out.println("Your shoot destroy ship");
			}
		}
		this.shoots.addShoot(c1);
	}
	
	static boolean isRightCoord(char chr, char[] chrTab ){
		boolean res = false;
		int i=0;
		while ((i<chrTab.length) && (!res)){
			if (chrTab[i] == chr) {
				res = true;
			}
			i=i+1;
		}// Stop when find chr in chrTab or when look all tab
		return res;
	}

}
