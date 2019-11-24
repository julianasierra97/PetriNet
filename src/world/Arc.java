package world;

public class Arc {
	protected int weight;
	
	protected boolean outputFromTransition;
	
	protected Place place;
	
	protected boolean active;
	
	protected Transition transition;
	
	
	
	public Arc(  int weight) {

		this.weight = weight;
		this.outputFromTransition = false;
		
	}

	public void setWeight(int newWeight) throws UnsupportedNegativeNumberException {
		if(newWeight>=0) {
			this.weight=newWeight;
		}
		else {
			throw new UnsupportedNegativeNumberException();
		}
		
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
	
	public void setOutputFromTransition(boolean output2) {
		outputFromTransition=output2;
		
	}

	public boolean verifyActive() {
			
		if(!outputFromTransition && place.getNbrTokens()>=weight ) {
			active=true;
		}
		else {
			active=false;
		}
		
		
		return active;
	}

	
	
	
}
