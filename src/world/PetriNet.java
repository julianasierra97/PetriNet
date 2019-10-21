package world;

import java.util.ArrayList;

public class PetriNet implements PetriNetInterface{


	private static ArrayList<Place> places;
	private static ArrayList<Arc> arcs;
	private static ArrayList<Transition> transitions;
	private int nextPlaceId;
	private int nextArcId;
	private int nextTransitionId;



	public PetriNet() {
		super();
		this.places = new ArrayList<>();
		this.arcs = new ArrayList<>();
		this.transitions = new ArrayList<>();
		this.nextPlaceId = 0;
		this.nextTransitionId=0;
	}

	@Override
	public void addPlace() {
		places.add(new Place(nextPlaceId));
		nextPlaceId++;


	}

	@Override
	public void addArc() {
		arcs.add(new Arc(nextArcId));
		nextArcId++;

	}

	@Override
	public void addTransition() {
		transitions.add(new Transition(nextTransitionId));
		nextTransitionId++;

	}

	public void relateArcPlace(Place place, Arc arc) {
		arc.setPlace(place);

	}


	public void relateArcTransition(Transition transition,Arc arc,  boolean output) {
		arc.setTransition(transition);
		arc.setOutput(output);
		if(output) {
			transition.addOutput(arc);
		}
		else {
			transition.addInput(arc);
		}
	}

	@Override
	public void deletePlace(int idPlace) {
		for (Place place : places) {
			if(place.getId()==idPlace) {
				places.remove(place);
				for (Arc arc : arcs) {
					if (arc.getPlace().equals(place)) {
						deleteArc(arc.getId());
					}
				}
			}
			

		}
	}


	@Override
	public void deleteArc(int idArc) {
		for (Arc arc : arcs) {
			if(arc.getId()==idArc) {
				arcs.remove(arc);
			}
		}

	}

	@Override
	public void deleteTransition(int idTransition) {
		for (Transition transition : transitions) {
			if(transition.getIdTransition()==idTransition) {
				transitions.remove(transition);
				for (Arc arc : arcs) {
					if (arc.getTransition().equals(transition)) {
						deleteArc(arc.getId());
					}
				}
			}
		}


	}


	

	@Override
	public void fireAllTransitions() {
		for (Transition transition : transitions) {
			transition.fire();
		}

	}

	@Override
	public void fireTransition(int idTransition) {
		for (Transition transition : transitions) {
			if(transition.getIdTransition()==idTransition) {
				transition.fire();
			}
		}

	}


	public static void main(String[] args) {
		PetriNet pn= new PetriNet();
		
		pn.addPlace();
		pn.addPlace();
		pn.addPlace();
		pn.addPlace();
		pn.addPlace();
		
		pn.addTransition();
			
		pn.addArc();
		pn.addArc();
		pn.addArc();
		pn.addArc();
		pn.addArc();
		
		pn.relateArcPlace(places.get(0), arcs.get(0));
		pn.relateArcPlace(places.get(1), arcs.get(1));
		pn.relateArcPlace(places.get(2), arcs.get(2));
		pn.relateArcPlace(places.get(3), arcs.get(3));
		pn.relateArcPlace(places.get(4), arcs.get(4));
		
		pn.relateArcTransition(transitions.get(0), arcs.get(0), false);
		pn.relateArcTransition(transitions.get(0), arcs.get(1), false);
		pn.relateArcTransition(transitions.get(0), arcs.get(2), true);
		pn.relateArcTransition(transitions.get(0), arcs.get(3), true);
		pn.relateArcTransition(transitions.get(0), arcs.get(4), true);
		
		
		arcs.get(0).setWeight(1);
		arcs.get(1).setWeight(2);
		arcs.get(2).setWeight(1);
		arcs.get(3).setWeight(1);
		arcs.get(4).setWeight(3);
		

		places.get(0).setTokens(2);
		places.get(1).setTokens(3);
		
		
		pn.fireAllTransitions();
		
		System.out.println(arcs.get(0).getPlace().getNbrTokens());
		System.out.println(arcs.get(1).getPlace().getNbrTokens());
		System.out.println(arcs.get(4).getPlace().getNbrTokens());
		
		
	}

}
