package bsGamme;

import java.util.Hashtable;

public class Ship {
//  ship coords are box of matrix enter A0..J9  
	private Coordinate startCoord ;
	private Coordinate endCoord ;
	private Boolean isHorizontal;
	// all box of hitsTab = false => ship never shoot 
	private Hashtable hitsTab;
	
	public Ship(Coordinate startCoord, Coordinate endCoord) {
		super();
		this.startCoord = startCoord;
		this.endCoord = endCoord;
		this.isHorizontal = (startCoord.getLine()==endCoord.getLine());
		
		hitsTab = new Hashtable(this.shipLenght());
		int i = this.startCoord.getLine();
		int j = this.startCoord.getColumn();
		String currentC; //I use string because i think hashtable function cant comparate 2 coordinate 
 		if (isHorizontal){
			for (int t=0; t<(this.shipLenght()); t++){
				currentC= toASCII(j+t) +toASCII(i);
				hitsTab.put(currentC,false);
			}
		}
 		else {
			for (int t=0; t<(this.shipLenght()); t++){
				currentC= toASCII(j) +toASCII(i+t);
				hitsTab.put(currentC,false);
			}
 		}
	}
	
	public Coordinate getStartCoord() {
		return startCoord;
	}

	public void setStartCoord(Coordinate startCoord) {
		this.startCoord = startCoord;
	}

	public Coordinate getEndCoord() {
		return endCoord;
	}

	public void setEndCoord(Coordinate endCoord) {
		this.endCoord = endCoord;
	}

	public Boolean getIsHorizontal() {
		return isHorizontal;
	}

	public void setIsHorizontal(Boolean isHorizontal) {
		this.isHorizontal = isHorizontal;
	}

	public Hashtable getHitsTab() {
		return hitsTab;
	}



	public void setHitsTab(Hashtable hitsTab) {
		this.hitsTab = hitsTab;
	}



	// return ship Lenght is between 2..5
	public int shipLenght(){
		int colGap = startCoord.colunnGap(endCoord);
		int lineGap = startCoord.lineGap(endCoord);
		return (Math.max(colGap,lineGap) + 1);
		
	}
	
	// return true if shoot is on current ship 
	public boolean isHit(Coordinate missileCoord) {
		return missileCoord.isBetween(startCoord,endCoord); 
	}
	
	// return true if all boxs of ship are shoot 
	public boolean isDestroy(){
		return !(this.hitsTab.containsValue(false));
	}
	
	//
	public boolean boatHitRecord(Coordinate missileCoord){
		if (this.isHit(missileCoord)){
			this.hitsTab.put(missileCoord.getCoord(),true);
			return true;
		}
		else {
			return false;
		}
	}
	
	private static String toASCII(int value) {
	    int length = 1;
	    StringBuilder builder = new StringBuilder(length);
	    for (int i = length - 1; i >= 0; i--) {
	        builder.append((char) ((value >> (8 * i)) & 0xFF));
	    }
	    return builder.toString();
	}
	
	
	@Override
	public String toString() {
		return "Ship [startCoord=" + startCoord + ", endCoord=" + endCoord
				+ ", hitsTab=" + hitsTab.toString() + "]";
	}
	
}
