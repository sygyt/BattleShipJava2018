package gayet.simon;

public interface IPlayer {
	
	public String getName();
	public int getNb();
	public void setNb(int nb);
	public Fleet getFleet();
	public void setFleet(Fleet fleet);
	public Shoots getShoots();
	public void setShoots(Shoots shoot);
	
	public Coordinate generateCoord();
	public Ship generateShip(int lenght);
	public void initFleet();
	public void generateShoot(IPlayer advrs);

}
