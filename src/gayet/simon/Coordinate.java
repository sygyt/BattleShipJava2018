package gayet.simon;

public class Coordinate {

	private String coord;

	// Construct //
	public Coordinate(String coord) {
		super();
		this.coord = coord;
	}

	// Geters Seters //
	public String getCoord() {
		return coord;
	}
	public void setCoord(String coord) {
		this.coord = coord;
	} 

	public char getColumn(){ // return char between A..J 
		return this.coord.charAt(0);
	}  
	
	public int getIntColumn(){
		int col = (this.getColumn() - 'A');
		return col;
	}
	
	public char getLine(){ // return char between 0..9
		return this.coord.charAt(1);
	}
	
	public int getIntLine() {
		int line = (this.getLine() - '0');
		return line;
	}
	
	public boolean isBetween(Coordinate c1, Coordinate c2){
		
		boolean isBetween = false;
    // column coordinates		
		char col1 = c1.getColumn();
		char col2 = c2.getColumn();
		char colHit = this.getColumn();

    // lines coordinates
		char line1 = c1.getLine();
		char line2 = c2.getLine();
		char lineHit = this.getLine();
		
		if ((colHit>=col1 && col2>=colHit) && (line2>=lineHit && lineHit>=line1)){
			isBetween = true;
		}
		return isBetween; 
	}
	
	// column gap between current coordinate and one other
	// they can be negative
	public int colunnGap(Coordinate c){
		return (c.getColumn() - this.getColumn());
	}
	
	// line gap between current coordinate and one other
	// they can be negative
	public int lineGap(Coordinate c){
		return (c.getLine() - this.getLine());
	}	
	
	
	// coord has line priority on another if her line is lower 
	public boolean hasLinePriority(Coordinate c){
		return (this.getIntLine() < c.getIntLine());
	}
	
	// coord has column priority on another if her column is lower 
	public boolean hasColumnPriority(Coordinate coord){
		return (this.getIntColumn() < coord.getIntColumn());
	}
	
	public boolean isLineEquals(Coordinate coord){
		return (this.getIntLine() == coord.getIntLine());
	}
	
	public boolean isColumnEquals(Coordinate coord){
		return (this.getIntColumn() == coord.getIntColumn());
	}
	
	// priority of line 
	public boolean hasPriority(Coordinate coord) {
		boolean res;
		if (this.hasLinePriority(coord)) {
			res = true;
		}
		else {
			if (this.isLineEquals(coord) && this.hasColumnPriority(coord)) {
				res = true;
			}
			else {
				res=false;
			}
		}
		return res ;
	}
	
	public boolean equals(Coordinate coord){
		boolean res;
		if (this.isLineEquals(coord) && this.isColumnEquals(coord)) {
			res = true;
		}
		else {
			res = false;
		}
		return res; 
	}
	
	@Override
	public String toString() {
		return "Coordinate [" + coord + "]";
	}
}
