package world;

public class ZeroArc extends Arc {

	public ZeroArc( int weight) {
		super( weight );
	}

	public void changeState() {
		if (this.active == true) {
			this.active = false;
		}
		else {
			this.active = true;
		}
	}


	public boolean verifyActive() {
		if(outputFromTransition && (place.getNbrTokens()==0 )){
			active=true;
		}
		else {
			active=false;
		}
		return active;
	}

}