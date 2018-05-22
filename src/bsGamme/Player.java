package bsGamme;

public class Player {
	
	private int nb;
	private Map map;
	private Shoots shoots;
	private Fleet fleet;
	
	public Player(int nb, Shoots shoots, Fleet fleet) {
		super();
		this.nb = nb;
		this.shoots = shoots;
		this.fleet = fleet;
	}
	
	public Player(int nb){
		this.nb = nb;
	}

	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}

	public Shoots getShoots() {
		return shoots;
	}

	public void setShoots(Shoots shoots) {
		this.shoots = shoots;
	}

	public Fleet getFleet() {
		return fleet;
	}

	public void setFleet(Fleet fleet) {
		this.fleet = fleet;
	}

	@Override
	public String toString() {
		return "Player [nb=" + nb + ", map=" + map + ", shoots=" + shoots + ", fleet=" + fleet + "]";
	}
	
	

	
	

}
