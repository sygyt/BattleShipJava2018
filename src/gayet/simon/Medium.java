package gayet.simon;

public class Medium extends IA {

	public Medium(int nb) {
		super(nb,"Medium");
		// TODO Auto-generated constructor stub
	}
 
	@Override
	public void generateShoot(IPlayer advrs) {
		Coordinate crd = super.generateCoord();
		while (super.getShoots().alreadyContains(crd)){
			crd = super.generateCoord();
		}
		advrs.getFleet().shootFleet(crd);
		super.getShoots().addShoot(crd);
	}
	
	

}
