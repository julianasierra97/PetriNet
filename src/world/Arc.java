package world;

public class Arc {

	
	protected int weight;
	
	protected boolean output;
	
	protected Place place;
	
	protected boolean active;
	
	protected int id;
	
	protected Transition transition;
	
	
	
	public Arc( int idArc ) {

		this.weight = 1;
		this.output = false;
		this.id=idArc;
		
	}

	public void setWeight(int newWeight) {
		this.weight=newWeight;
	}
	
	public int getWeight() {
		return weight;
	}
	public Place getPlace() {
		return place;
	}
	
	
	public Transition getTransition() {
		return transition;
	}

	public void setTransition(Transition transition) {
		this.transition = transition;
	}

	public void setPlace(Place place) {
		this.place = place;
	}


	public boolean verifyActive() {
			
		if(place.getNbrTokens()>=weight&& !output) {
			active=true;
		}
		else {
			active=false;
		}
		
		
		return active;
	}

	public void setOutput(boolean output2) {
		output=output2;
		
	}

	public int getId() {
		
		return id;
	}
	
}
