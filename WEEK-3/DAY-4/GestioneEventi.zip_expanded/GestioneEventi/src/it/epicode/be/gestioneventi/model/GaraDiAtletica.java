package it.epicode.be.gestioneventi.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gare_di_atletica")
public class GaraDiAtletica extends Evento {

//	private Set<Persona> atleti;
//	private Persona vincitore;

//	CONSTRUCTORS ----------------------------------------
	public GaraDiAtletica(String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento,
			Integer numeroMassimoPartecipanti, Location location, Persona vincitore) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti,  location);
//		this.atleti = atleti;
//		this.vincitore = vincitore;
	}

	public GaraDiAtletica() {
	}

//	GETTERS / SETTERS ----------------------------------------
//	public Set<Persona> getAtleti() {
//		return atleti;
//	}
//
//	public void setAtleti(Set<Persona> atleti) {
//		this.atleti = atleti;
//	}

//	public Persona getVincitore() {
//		return vincitore;
//	}
//
//	public void setVincitore(Persona vincitore) {
//		this.vincitore = vincitore;
//	}

}
