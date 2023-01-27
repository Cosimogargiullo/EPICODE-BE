package it.epicode.be.gestioneventi.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "concerti")
public class Concerto extends Evento {

	private GenereConcerto genere;
	@Column(name = "in_streaming")
	private boolean inStreaming;

//	CONSTRUCTORS ----------------------------------------
	public Concerto(String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento,
			Integer numeroMassimoPartecipanti, Location location,
			GenereConcerto genere, boolean inStreaming) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
		this.genere = genere;
		this.inStreaming = inStreaming;
	}

	public Concerto() {
	}

//	GETTERS / SETTERS ----------------------------------------
	public GenereConcerto getGenere() {
		return genere;
	}

	public void setGenere(GenereConcerto genere) {
		this.genere = genere;
	}

	public boolean isInStreaming() {
		return inStreaming;
	}

	public void setInStreaming(boolean inStreaming) {
		this.inStreaming = inStreaming;
	}

	@Override
	public String toString() {
		return "Concerto [id=" + getId() + ", titolo=" + getTitolo() + ", dataEvento=" + getDataEvento() + ", descrizione=" + getDescrizione()
				+ ", tipoEvento=" + getTipoEvento() + ", numeroMassimoPartecipanti=" + getNumeroMassimoPartecipanti()
				+ ", location=" + getLocation() + ", genere=" + genere + ", inStreaming=" + inStreaming + "]";
	}

	

	
}
