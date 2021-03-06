package gayet.simon;

abstract public class IA implements IPlayer {
	
	private String name;
	private int nb;
	private Fleet fleet;
	private Shoots shoots;
	
	public IA(int nb, String name) {
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




	@Override
	public Coordinate generateCoord() {
		int column = 'A' + (int)(Math.random() * (('J' - 'A') + 1 ));
		int line = '0' + (int)(Math.random() * (('9' - '0') + 1 ));
		Coordinate res = new Coordinate(Character.toString((char)(column))+Character.toString((char)(line)));
		return res;
	}
	
	

	public Ship generateShip(int lenght) {
		int column = 'A' + (int)(Math.random() * ((('J'-(lenght - 1)) - 'A') + 1 ));
		int line = '0' + (int)(Math.random() * ((('9'-(lenght - 1)) - '0') + 1 ));
		Coordinate startCoord = new Coordinate(Character.toString((char)(column))+Character.toString((char)(line)));
		Coordinate lastCoord;
		double isHorisontal = Math.random();
		if (isHorisontal < 0.5){
			lastCoord = new Coordinate(Character.toString((char)(column+lenght-1))+Character.toString((char)(line)));
		}
		else {
			lastCoord = new Coordinate(Character.toString((char)(column))+Character.toString((char)(line+lenght-1)));
		}
		Ship shp = new Ship(startCoord,lastCoord);
		return shp;
	}
	
	

	@Override
	public void initFleet() {
		Fleet fleet = new Fleet();
	    for (ShipsTypes shipType : ShipsTypes.values()) { 
			Ship carrier = generateShip(shipType.getSize());
			while (fleet.alreadyContains(carrier)){
				carrier = generateShip(shipType.getSize());
			}
			fleet.AddShip(carrier);
	    }
	    this.fleet = fleet;
	}		

	@Override
	public void generateShoot(IPlayer advrs) {
		
	}
 
}
