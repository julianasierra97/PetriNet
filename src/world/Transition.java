package world;

import java.util.ArrayList;

public class Transition {

	/**
	 * Attribute that shows if the transiton can be fired according to the arcs and places that are related to it 
	 */
	private boolean enabled;


	private int idTransition;

	private ArrayList<Arc> inputArcs;

	private ArrayList<Arc> outputArcs;

	public Transition( int idTransition) {

		this.idTransition = idTransition;
		inputArcs=  new  ArrayList<>();
		outputArcs=  new  ArrayList<>();
	}


	public boolean isEnabled() {


		return enabled;
	}

	
	public void addInput(Arc arc) {
		inputArcs.add(arc);
	}
	public void addOutput(Arc arc) {
		outputArcs.add(arc);
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public int getIdTransition() {
		return idTransition;
	}


	public void setIdTransition(int idTransition) {
		this.idTransition = idTransition;
	}


	public void fire() {

		for (Arc arc : inputArcs) {
			if(arc.verifyActive() ) {
				enabled=true;
			}
			else {
				enabled=false;
				break;
			}
		}
		if(enabled) {
			for (Arc arc : inputArcs) {
				arc.getPlace().setTokens(arc.place.getNbrTokens()-arc.getWeight());
			}
			for (Arc arc : outputArcs) {
				arc.getPlace().setTokens(arc.getPlace().getNbrTokens()+arc.getWeight());
			}
		}


	}








}
