package gayet.simon;

public class Hard extends IA {
	private boolean lostMode; 
	private boolean searchMode; 
	private Coordinate searchCoord;
	//private boolean destroyMode; nerver used, destroy is when lostMode = false and searchMode = false 
	private Coordinate destroyCoord;
	private int besideValue;
	private boolean onRightBottom;
	
	public Hard(int nb) {
		super(nb, "Hard");
		this.lostMode = true;
		this.searchMode = false;
		//this.destroyMode = false;
		this.besideValue = 0;
		this.onRightBottom = true;
	}

	@Override
	public void generateShoot(IPlayer advrs) {
		Coordinate crd;
		if (lostMode){
			crd = super.generateCoord();
			while (super.getShoots().alreadyContains(crd)){
				crd = super.generateCoord();
			}
			int result = advrs.getFleet().shootFleet(crd);
			if (result == 1){
				lostMode = false;
				searchMode = true;
				searchCoord  = crd;
			}
			super.getShoots().addShoot(crd);
		}
		else {
			if (searchMode){
				crd = shootBeside();
				int result = advrs.getFleet().shootFleet(crd);
				if (result == 0){
					besideValue = besideValue + 1;
				}
				else {
					if (lostMode){
						besideValue = 0;
						if (result == 1){
							lostMode = false;
							searchMode = true;
							searchCoord = crd;
						
						}
						else {
							searchMode = false;
						}
					}
					else {
						if (result == 1) {
							searchMode = false;
							//destroyMode = true;
							destroyCoord  = crd;
							besideValue = 0;
							}
						else{ //result = 2 exemple for ship of 2 I dont need to past on destroyMode
							besideValue = 0;
							searchMode = false;
							lostMode = true;
						}

					}
				}
				super.getShoots().addShoot(crd);
			}
			else {
				crd = shootOnside();
				int result = advrs.getFleet().shootFleet(crd);
				if (lostMode){
					if (result == 1){
						lostMode = false;
						searchMode = true;
						searchCoord = crd;
					}
					else{
						//destroyMode = false;
						onRightBottom = true;
					}
				}
				else {
					if (result == 0){
						if (onRightBottom){
							onRightBottom = false;
						}
						else { 
							onRightBottom = true;
							//destroyMode = false;
							lostMode = true;
						}
					}
					else {
						if(result == 2){
							//destroyMode = false;
							lostMode = true;
							onRightBottom = true;
						}
					}
				}
				super.getShoots().addShoot(crd);
			}
		}
	}
	


	private Coordinate shootBeside() {
		Coordinate currentCoord = new Coordinate("A0");
		if (besideValue == 0){
			if (isRightCoord(Character.toString((char)(this.searchCoord.getLine() - 1)).charAt(0), Game.lineChar)){
				currentCoord = new Coordinate(this.searchCoord.getColumn() + Character.toString((char)(this.searchCoord.getLine() - 1)));
				if (super.getShoots().alreadyContains(currentCoord)){
					besideValue = 1;
				}
			}
			else {
				besideValue = 1;
			}
		}
		if (besideValue == 1){
			if (isRightCoord(Character.toString((char)(this.searchCoord.getColumn() - 1)).charAt(0), Game.columnChar)){
				currentCoord = new Coordinate(Character.toString((char)(this.searchCoord.getColumn() - 1)) + this.searchCoord.getLine());
				if (super.getShoots().alreadyContains(currentCoord)){
					besideValue = 2;
				}
			}
			else {
				besideValue = 2;
			}
		}
		if (besideValue == 2){
			if (isRightCoord(Character.toString((char)(this.searchCoord.getLine() + 1)).charAt(0), Game.lineChar)){
				currentCoord = new Coordinate(this.searchCoord.getColumn() + Character.toString((char)(this.searchCoord.getLine() + 1)));
				if (super.getShoots().alreadyContains(currentCoord)){
					besideValue = 3;
				}
			}
			else {
				besideValue = 3;
			}
		}
		if (besideValue == 3){
			if (isRightCoord(Character.toString((char)(this.searchCoord.getColumn() + 1)).charAt(0), Game.columnChar)){
				currentCoord = new Coordinate(Character.toString((char)(this.searchCoord.getColumn() + 1)) + this.searchCoord.getLine());
				if (super.getShoots().alreadyContains(currentCoord)){
					besideValue = 4;
				}
			}
			else {
				besideValue = 4;
			}
		}
		if (besideValue  < 0 || besideValue > 3){
			currentCoord = super.generateCoord();
			if (super.getShoots().alreadyContains(currentCoord)){
				currentCoord = super.generateCoord();
			}
			besideValue = 0;
			this.lostMode = true;
			this.searchMode = false;
		}
		return currentCoord;
	}


	private Coordinate shootOnside() {
		Coordinate currentCoord = new Coordinate("A0");
		boolean isHorizontale = (searchCoord.getLine()==destroyCoord.getLine());
		if (isHorizontale){
			if (onRightBottom){
				currentCoord = new Coordinate(Character.toString((char)(this.destroyCoord.getColumn() + 1)) + this.searchCoord.getLine());
				while (super.getShoots().alreadyContains(currentCoord)){
					currentCoord = new Coordinate(Character.toString((char)(currentCoord.getColumn() + 1)) + this.searchCoord.getLine());
				}
				if (!(isRightCoord(currentCoord.getColumn(), Game.columnChar))){
						onRightBottom = false;
				}
			}
			if (!(onRightBottom)){
				currentCoord = new Coordinate(Character.toString((char)(this.destroyCoord.getColumn() - 1)) + this.searchCoord.getLine());
				while (super.getShoots().alreadyContains(currentCoord)){
					currentCoord = new Coordinate(Character.toString((char)(currentCoord.getColumn() - 1)) + this.searchCoord.getLine());
				}
				if (!(isRightCoord(currentCoord.getColumn(), Game.columnChar))){
						currentCoord = super.generateCoord();
						onRightBottom = true;
						//destroyMode = false;
						lostMode = true; 
				}
				
			}
		}
		else{
			if (onRightBottom){
				currentCoord = new Coordinate(this.searchCoord.getColumn() + Character.toString((char)(this.destroyCoord.getLine() + 1)));
				while (super.getShoots().alreadyContains(currentCoord)){
					currentCoord = new Coordinate(this.searchCoord.getColumn() + Character.toString((char)(currentCoord.getLine() + 1)));
				}
				if (!(isRightCoord(currentCoord.getLine(), Game.lineChar))){
						onRightBottom = false;
				}
			}
			if (!(onRightBottom)){
				currentCoord = new Coordinate(this.searchCoord.getColumn() + Character.toString((char)(this.destroyCoord.getLine() - 1)));
				while (super.getShoots().alreadyContains(currentCoord)){
					currentCoord = new Coordinate(this.searchCoord.getColumn() + Character.toString((char)(currentCoord.getLine() - 1)));
				}
				if (!(isRightCoord(currentCoord.getColumn(), Game.columnChar))){
						currentCoord = super.generateCoord();
						onRightBottom = true;
						//destroyMode = false;
						lostMode = true; 
				}
			}
		}
		return currentCoord;
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
