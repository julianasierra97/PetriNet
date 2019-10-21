package world;

import java.util.ArrayList;

public class Place {

	private int nbrTokens;
	private int idPlace;




	public Place (int idPlace) {
		this.nbrTokens = 0;
		this.idPlace=idPlace;
	
	}

	public int getNbrTokens() {
		return nbrTokens;
	}

	public void deleteTokens() {
		nbrTokens = 0;
	}

	public void addTokens(int tokensToAdd) {
		nbrTokens += tokensToAdd;
	}

	public int getId() {

		return idPlace;
	}

	public void setTokens(int i) {
		nbrTokens=i;

	}



}

