package world;

public interface PetriNetInterface {
	
	public void addPlace(int weight);

	public void addTransition();
	
	public void deletePlace(Place place);
	
	public void deleteArc(Arc arc);

	public void deleteTransition(Transition transition);
	
	
	public void fireAllTransitions();
	
	public void fireTransition(Transition transition);

	public void addArc(String type, int weight);
	
	public void changeTokenNumber(Place place, int newWeight);
	
	public void relateArcPlace(Place place, Arc arc);
	
	public void relateArcTransition(Transition transition,Arc arc,  boolean output);

}
