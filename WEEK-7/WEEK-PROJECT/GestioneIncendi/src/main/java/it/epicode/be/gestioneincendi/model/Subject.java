package it.epicode.be.gestioneincendi.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public abstract class Subject {

	private final List<Observer> observers = new ArrayList<Observer>();

	public void updateObservers() {
		this.getObservers().forEach(o -> o.update(this));
	}
	

	public void addObserver(Observer obs) {
		this.getObservers().add(obs);
	}

	public boolean removeObserver(Observer obs) {
		return this.getObservers().remove(obs);
	}
}
