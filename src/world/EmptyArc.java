package world;

public class EmptyArc extends Arc{


	
	public EmptyArc(int id) {
		super(id);

		
	}
	//TODO  AskTeacher
	public boolean verifyActive() {
		if(place.getNbrTokens()>0&&!output) {
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
