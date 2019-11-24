package world;

public class EmptyArc extends Arc{


	
	public EmptyArc( int weight) {
		super( weight);

		
	}
	//TODO  AskTeacher
	public boolean verifyActive() {
		if(!outputFromTransition &&place.getNbrTokens()>0) {
			active=true;
			emptyAll();
			
		}
		else {
			active=false;
		}
		return active;
	}


	public void emptyAll() {
		if(verifyActive()) {
			place.deleteTokens();
			active=false;
			
		}
	}
	
	
	
}
