package world;

public interface PetriNetInterface {
	
	public void addPlace();
	
	public void addArc();

	public void addTransition();
	
	public void deletePlace(int idPlace);
	
	public void deleteArc(int idArc);

	public void deleteTransition(int idTransition);
	
	
	public void fireAllTransitions();
	
	public void fireTransition(int idTransition);

}
