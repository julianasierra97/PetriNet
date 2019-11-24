package world;

import java.util.ArrayList;

public class PetriNet implements PetriNetInterface{

	public static final String ARC = "Arc";

	public static final String ZEROARC = "Zero Arc";

	public static final String EMPTYARC = "Empty Arc";

	private static ArrayList<Place> places;
	private static ArrayList<Arc> arcs;
	private static ArrayList<Transition> transitions;



	public PetriNet() {
		super();
		this.places = new ArrayList<>();
		this.arcs = new ArrayList<>();
		this.transitions = new ArrayList<>();

	}

	@Override
	public void addPlace( int weight) {
		places.add(new Place(weight));



	}

	@Override
	public void addArc(String type, int weight) {
		if(type.equals(PetriNet.ARC)) {
			arcs.add(new Arc( weight));
		}
		else if(type.equals(PetriNet.ZEROARC)) {
			arcs.add(new ZeroArc( weight));
		}
		else if(type.equals(PetriNet.EMPTYARC)) {
			arcs.add(new EmptyArc( weight));
		}


	}

	@Override
	public void addTransition() {
		transitions.add(new Transition());

	}

	@Override
	public void relateArcPlace(Place place, Arc arc) {
		if(arc!=null) {
			arc.setPlace(place);
		}
	}



	@Override
	public void relateArcTransition(Transition transition,Arc arc,  boolean output) {
		arc.setTransition(transition);
		arc.setOutputFromTransition(output);
		if(output) {
			transition.addOutput(arc);
		}
		else {
			transition.addInput(arc);
		}
	}

	@Override
	public void deletePlace(Place place) {

		places.remove(place);
		for (Arc arc : arcs) {
			if (arc.getPlace().equals(place)) {
				deleteArc(arc);
			}
		}



	}



	@Override
	public void deleteArc(Arc arc) {
		arcs.remove(arc);
	}

	@Override
	public void deleteTransition(Transition transition) {
		transitions.remove(transition);
		for (Arc arc : arcs) {
			if (arc.getTransition().equals(transition)) {
				deleteArc(arc);
			}
		}
	}

	@Override
	public void changeTokenNumber(Place place, int newWeight) {
		if(place!=null) {
			try {
				place.setTokens(newWeight);
				for (Arc arc : arcs) {
					if(arc.getPlace().equals(place)) {
						if(!arc.outputFromTransition && arc.getClass()==EmptyArc.class) {
							((EmptyArc)arc).emptyAll();						
						}
					}
				}
			} catch (UnsupportedNegativeNumberException e) {
				System.out.println(e.getMessage());
			}
		}

	}




	@Override
	public void fireAllTransitions() {
		try {
			for (Transition transition : transitions) {
				transition.fire();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


	}

	@Override
	public void fireTransition(Transition transition) {
		try {
			if(transition!=null) {
				transition.fire();	
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}



	}


	public static void main(String[] args) {
		PetriNet pn= new PetriNet();

	
		
		
		
		pn.addPlace(2);
		pn.addPlace(2);
		pn.addPlace(4);
		pn.addPlace(0);
		pn.addPlace(0);

		pn.addTransition();

		pn.addArc(PetriNet.ARC,1);
		pn.addArc(PetriNet.ARC,2);
		pn.addArc(PetriNet.ARC,1);
		pn.addArc(PetriNet.ARC,1);
		pn.addArc(PetriNet.ARC,3);

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







		pn.fireAllTransitions();

		System.out.println(arcs.get(0).getPlace().getNbrTokens());
		System.out.println(arcs.get(1).getPlace().getNbrTokens());
		System.out.println(arcs.get(4).getPlace().getNbrTokens());


	}



}
