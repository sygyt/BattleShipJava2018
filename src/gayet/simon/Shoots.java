package gayet.simon;

import java.util.ArrayList;
import java.util.List;

public class Shoots {
	
	private List<Coordinate> shootsList;
	public Shoots() {
		this.shootsList = new ArrayList<Coordinate>();
	} 
	
	// add shoot at good position in list
	// shoot don't need good position
	public void addShoot(Coordinate shoot){
		boolean finish = false;
		int i = 0;
		if (this.shootsList.isEmpty()) {
			this.shootsList.add(i, shoot);
			finish = true;
		}
		else {	
			while( i<this.shootsList.size() && !finish ){
				if (shoot.hasPriority(this.shootsList.get(i))) {
					this.shootsList.add(i, shoot);
					finish = true;
				}
				i = i + 1;
			}
		}
		
		if (!finish){
			this.shootsList.add(i, shoot);
		}
		
	}
	
	public boolean alreadyContains(Coordinate coord){
		boolean contains = false;
		int i = 0;
		while( i<this.shootsList.size() && !contains ){
			if (this.shootsList.get(i).equals(coord)) {
				contains = true;
			}
			i = i + 1;
		}
		return contains; 
	}

	public List<Coordinate> getShootsList() {
		return shootsList;
	}

	public String printShoot() {
		StringBuilder shootMap = new StringBuilder("ShootMap player : \n"
				+ "  | A | B | C | D | E | F | G | H | I | J \n");
		Coordinate currentCoord = new Coordinate("A0");
		char A = 'A';
		char zero = '0';
		for (int line=0; line<=9; line++){
			shootMap.append(line);
			for (int col=0; col<=9; col++){
				shootMap.append(" | ");
				currentCoord.setCoord(Character.toString((char)(A+col)) + Character.toString((char)(zero+line)));
				if (this.alreadyContains(currentCoord)){
					shootMap.append('X');
				}
				else{
					shootMap.append('~');
				}
			}
			shootMap.append(" \n");
		}
		return shootMap.toString();
	}
}
