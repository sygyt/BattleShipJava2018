package gayet.simon;

public class Game {
	
	private IPlayer p1,p2;
	private IPlayer currentplr;
	private IPlayer beginer; 
	static char[] columnChar = {'A','B','C','D','E','F','G','H','I','J'};
	static char[] lineChar = {'0','1','2','3','4','5','6','7','8','9'};
	
	public Game(IPlayer p1, IPlayer p2, IPlayer currentplr) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.currentplr = p1;
		this.beginer = p1;
	}
	
	public IPlayer getP1() {
		return p1;
	}

	public void setP1(IPlayer p1) {
		this.p1 = p1;
	}

	public IPlayer getP2() {
		return p2;
	}

	public void setP2(IPlayer p2) {
		this.p2 = p2;
	}

	public IPlayer getCurrentplr() {
		return currentplr;
	}
	
	public IPlayer getBeginer(){
		return beginer;
	}

	public void setCurrentplr(IPlayer currentplr) {
		this.currentplr = currentplr;
	}
	
	public IPlayer getOtherIPlayer(){
		if (this.currentplr.getNb() == this.p1.getNb()){
			return this.p2;
		}
		else {
			return this.p1;
		}
	}
	
	public void changeBeginer(){
		if (this.beginer.getNb() == this.p1.getNb()){
			this.beginer = p2;
		}
		else {
			this.beginer = p1;
		}
	}
	
	public void changeCurrentPlr(){
		this.currentplr = this.getOtherIPlayer();
	}
}
