package bsGamme;


public class Map {
	/*
	private char[][] grid = new char[10][10];
	
	public Map(){
		for (int line=0; line<=9; line++){
			for (int col=0; col<=9; col++){
				grid[line][col]='0';
			}
		}
	}
	
	
	public String printMap() {
		StringBuilder map = new StringBuilder("  | A | B | C | D | E | F | G | H | I | J \n");
		for (int line=0; line<=9; line++){
			map.append(line);
			for (int col=0; col<=9; col++){
				map.append(" | ");
				map.append(this.grid[line][col]);
			}
			map.append(" \n");
		}
		return map.toString();
	}
	
	// a and b must be enter 0..9 //
	public char getBox(Coordinate coord){
		//System.out.println(grid[a][b]);
		int line = coord.getIntLine();
		int col = coord.getIntColumn();
		//System.out.println(this.grid[line][col]);
		return this.grid[line][col];
	}
	
	public void addBoat(Ship shp){
		int colGap = (shp.getStartCoord().colunnGap(shp.getEndCoord())); // height size
		int lineGap = (shp.getStartCoord().lineGap(shp.getEndCoord())); //lenght size
		int line = (shp.getStartCoord().getLine() - '0'); //can be replace by shp.getStartCoord().getIntLine
		//System.out.println(shp.getStartCoord());
		//System.out.println(line);
		int col = (shp.getStartCoord().getColumn() - 'A'); 
		int index = 0;
		Boolean[] hitsTab = shp.getHitsTab();
		for ( int i=line ; i<=(line + lineGap); i++){ //(line + lineGap) is last position of boat on lenght
			for (int j=col; j<=(col + colGap); j++){ //(line + colGap) is last position of boat on height
				//System.out.println(i);
				//System.out.println(j);
				if (hitsTab[index]) {
					this.grid[i][j]='t';
				}
				else {
					this.grid[i][j]='s';
				}
				index = index + 1;
			}
		}
	}
		
	public void suprBoat(Ship shp){
		int colGap = (shp.getStartCoord().colunnGap(shp.getEndCoord())); // height size
		int lineGap = (shp.getStartCoord().lineGap(shp.getEndCoord())); //lenght size
		int line = (shp.getStartCoord().getLine() - '0'); //can be replace by shp.getStartCoord().getIntLine
		int col = (shp.getStartCoord().getColumn() - 'A'); 
		int index = 0;
		//Boolean[] hitsTab = shp.getHitsTab();
		for ( int i=line ; i<=(line + lineGap); i++){ //(line + lineGap) is last position of boat on lenght
			for (int j=col; j<=(col + colGap); j++){ //(line + colGap) is last position of boat on height
				//System.out.println(i);
				//System.out.println(j);
				this.grid[i][j]='0';
				index = index + 1;
			}
		}
	}
	
	public void addFleet(Fleet fleet){
		for (int i =0; i<fleet.getShipList().size(); i++){
			this.addBoat(fleet.getShipList().get(1));
		}
	}*/
	
	public String printFleet(Fleet flt){
		StringBuilder fleetMap = new StringBuilder("ShootMap player : \n"
				+ "  | A | B | C | D | E | F | G | H | I | J \n");
		Coordinate currentCoord = new Coordinate("A0");
		char A = 'A';
		char zero = '0';
		for (int line=0; line<=9; line++){
			fleetMap.append(line);
			for (int col=0; col<=9; col++){
				fleetMap.append(" | ");
				currentCoord.setCoord(toASCII(A+col) + toASCII(zero+line));
				for (Ship s : flt.getShipList()){
					if (s.getHitsTab().containsKey(currentCoord.getCoord())){
						if ((boolean)s.getHitsTab().get(currentCoord.getCoord()))
							fleetMap.append('X');
						else{
							fleetMap.append('B');
						}
					}
					else {
						fleetMap.append('~');
					}
				}
			}
			fleetMap.append(" \n");
		}
		return fleetMap.toString();
	}
	
	private static String toASCII(int value) {
	    int length = 1;
	    StringBuilder builder = new StringBuilder(length);
	    for (int i = length - 1; i >= 0; i--) {
	        builder.append((char) ((value >> (8 * i)) & 0xFF));
	    }
	    return builder.toString();
	}
	
}
