package world;


public class Place {

	private int nbrTokens;

	public Place (int nbrTokens) {
		this.nbrTokens = nbrTokens;
	
	}

	public int getNbrTokens() {
		return nbrTokens;
	}

	public void deleteTokens() {
		nbrTokens = 0;
	}


	public void setTokens(int i) throws UnsupportedNegativeNumberException {
		if(i>=0) {
		nbrTokens=i;
		}
		else {
			throw new UnsupportedNegativeNumberException();
		}

	}



}

