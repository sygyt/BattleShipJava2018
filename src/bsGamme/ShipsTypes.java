package bsGamme;

public enum ShipsTypes {
	    CARRIER(5),
	    BATTLESHIP(4),
	    CRUISER(3),
	    SUBMARINE(3),
	    DESTROYER(2);
	    

	    private int size;
	    
	    
	    private ShipsTypes(int size) {
			this.size = size;
		}

	    public int getSize() {
	        return size;
	    }
	    

	}