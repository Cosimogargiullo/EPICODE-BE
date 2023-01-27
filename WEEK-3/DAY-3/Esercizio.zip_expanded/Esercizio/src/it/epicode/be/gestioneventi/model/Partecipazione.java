package it.epicode.be.gestioneventi.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Partecipazione {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	private Persona persona;
	private Evento evento;
	@Enumerated(EnumType.STRING)
	private Stato stato;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public Stato getStato() {
		return stato;
	}
	public void setStato(Stato stato) {
		this.stato = stato;
	}
	public Partecipazione(String id, Persona persona, Evento evento, Stato stato) {
		super();
		this.id = id;
		this.persona = persona;
		this.evento = evento;
		this.stato = stato;
	}
	
	

}
