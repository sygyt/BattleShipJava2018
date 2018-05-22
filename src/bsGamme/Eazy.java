package bsGamme;

public class Eazy extends IA {

	public Eazy(int nb) {
		super(nb,"Eazy");
	}

	@Override
	public void generateShoot(IPlayer advrs) {
		Coordinate crd = super.generateCoord();
		advrs.getFleet().shootFleet(crd);
		super.getShoots().addShoot(crd);
	}
	
	
}
