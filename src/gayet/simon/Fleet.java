package gayet.simon;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
	
	private List<Ship> shipList;
	
	public Fleet() {
		this.shipList = new ArrayList<Ship>();
	}
	
	public void AddShip(Ship s){
		this.shipList.add(s);
	}
	
	// this function test if one coordinate of shp is already used by another ship in fleet 
	public boolean alreadyContains(Ship shp){
		boolean contains = false; 
		int i = 0;
		Coordinate initial = new Coordinate(shp.getStartCoord().getCoord());
		Coordinate currentCoord = new Coordinate(shp.getStartCoord().getCoord());
		if (shp.getIsHorizontal()){
			int j = initial.getColumn();
			int last = j + shp.shipLenght();
			while (i<this.shipList.size() && !contains){
				j = initial.getColumn();
				while(j<last && !contains){
					currentCoord.setCoord(Character.toString((char)(j))+initial.getLine());
					if (currentCoord.isBetween(this.shipList.get(i).getStartCoord(), this.shipList.get(i).getEndCoord())){
						contains = true; 
					}
					j = j + 1;
				}// stop when find coord of shp which is already used by ship:this.shipList.get(i) or when look all coord of shp
				i=i+1;
			}// stop when find ship in conflict with shp or when we look all ship
		}
		else {
			int j = initial.getLine();
			//System.out.println("start j =" + j);
			int last = j + shp.shipLenght();
			//System.out.println("last =" + last);
			while (i<this.shipList.size() && !contains){
				//System.out.println("i = "+i+" j= "+j);
				j = initial.getLine();
				while(j<last && !contains){
					//System.out.println("j = " +j);
					currentCoord.setCoord(initial.getColumn()+Character.toString((char)(j)));
					//System.out.println(currentCoord.getCoord());
					if (currentCoord.isBetween(this.shipList.get(i).getStartCoord(), this.shipList.get(i).getEndCoord())){
						contains = true; 
					}
					j = j + 1;
				}// stop when find coord of shp which is already used by ship:this.shipList.get(i) or when look all coord of shp
				i=i+1;
			}// stop when find ship in conflict with shp or when we look all ship
			
		}
	return contains;
	}
	
	
	public List<Ship> getShipList() {
		return shipList;
	}

	public void setShipList(List<Ship> shipList) {
		this.shipList = shipList;
	}

	// return true if all ship in fleet are destroy
	public boolean isDestroyFleet(){
		boolean finish = false;
		int i = 0;
		if (this.shipList.isEmpty()) {
			finish = true;
		}
		else {
			while (i<this.shipList.size() && !finish){
				finish = !(this.shipList.get(i).isDestroy());
				i = i + 1; 
			}// loop stop when find ship not destroy or all ship has been check
		}
		return !finish;
	}
	
	// if shoot touch a ship return 1 and add shoot if ship is destroy return 2 if shoot in water return 0
	public int shootFleet(Coordinate shootCoord){
		int res;
		int i = 0;
		while ( (i<this.shipList.size()) && (!(this.shipList.get(i).boatHitRecord(shootCoord))) ){
			i = i + 1;
		}//stop when all ships are look or one ship is shoot
		if ((i == this.shipList.size())) { // if i = size then no ship are touch
			res = 0;
		}
		else { 
			if (this.shipList.get(i).isDestroy()) {
				res = 2;
			}
			else {
				res = 1; 
			}
		}
		return res;
	}
	
	public String printFleet(){
		StringBuilder fleetMap = new StringBuilder("Fleet player : \n"
				+ "  | A | B | C | D | E | F | G | H | I | J \n");
		Coordinate currentCoord = new Coordinate("A0");
		char A = 'A';
		char zero = '0';
		for (int line=0; line<=9; line++){
			fleetMap.append(line);
			for (int col=0; col<=9; col++){
				fleetMap.append(" | ");
				currentCoord.setCoord(Character.toString((char)(A+col)) + Character.toString((char)(zero+line)));
				boolean find = false;
				int i = 0;
				while (i<this.shipList.size() && !find){
					if (this.shipList.get(i).getHitsTab().containsKey(currentCoord.getCoord())){
						if ((boolean)this.shipList.get(i).getHitsTab().get(currentCoord.getCoord())){
							fleetMap.append('X');
							find = true;
						}
						else{
							fleetMap.append('B');
							find = true;
						}
					}
					i=i+1;
				}
				if (!find){
					fleetMap.append('~');
				}
			}
			fleetMap.append(" \n");
		}
		return fleetMap.toString();
	}
	
	public String toString(){
		StringBuilder fleet = new StringBuilder("fleet of player contains ");
		fleet.append(this.shipList.size());
		fleet.append(" ship :");
		for (int i=0; i<this.shipList.size(); i++){
			fleet.append(" n°");
			fleet.append(i+1);
			fleet.append(" size ");
			fleet.append(this.shipList.get(i).shipLenght());
			fleet.append(" is destroy ");
			fleet.append(this.shipList.get(i).isDestroy());
		}
		return fleet.toString();
	}
}
