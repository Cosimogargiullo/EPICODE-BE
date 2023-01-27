package it.epicode.be.gestioneventi.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="partite_di_calcio")
@NamedQuery(name = "getPartiteVinteInCasa", query = "SELECT c FROM PartitaDiCalcio c WHERE c.squadraVincente = c.squadraDiCasa")
public class PartitaDiCalcio extends Evento {

	@Column(name="squadra_di_casa")
	private String squadraDiCasa;
	@Column(name="squadra_ospite")
	private String squadraOspite;
	@Column(name="squadra_vincente")
	private String squadraVincente;
	@Column(name="goal_squadra_di_casa")
	private int goalSquadraDiCasa;
	@Column(name="goal_squadra_ospite")
	private int goalSquadraOspite;

//	CONSTRUCTORS ----------------------------------------
	
	public PartitaDiCalcio(String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento,
			Integer numeroMassimoPartecipanti, Location location, String squadraDiCasa, String squadraOspite, String squadraVincente, int goalSquadraDiCasa,
			int goalSquadraOspite) {
		super(titolo,dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
		this.squadraDiCasa = squadraDiCasa;
		this.squadraOspite = squadraOspite;
		this.squadraVincente = squadraVincente;
		this.goalSquadraDiCasa = goalSquadraDiCasa;
		this.goalSquadraOspite = goalSquadraOspite;
	}
	
	public PartitaDiCalcio() {
		
	}
	
//	GETTERS / SETTERS ----------------------------------------
	public String getSquadraDiCasa() {
		return squadraDiCasa;
	}

	public void setSquadraDiCasa(String squadraDiCasa) {
		this.squadraDiCasa = squadraDiCasa;
	}

	public String getSquadraOspite() {
		return squadraOspite;
	}

	public void setSquadraOspite(String squadraOspite) {
		this.squadraOspite = squadraOspite;
	}

	public String getSquadraVincente() {
		return squadraVincente;
	}

	public void setSquadraVincente(String squadraVincente) {
		this.squadraVincente = squadraVincente;
	}

	public int getGoalSquadraDiCasa() {
		return goalSquadraDiCasa;
	}

	public void setGoalSquadraDiCasa(int goalSquadraDiCasa) {
		this.goalSquadraDiCasa = goalSquadraDiCasa;
	}

	public int getGoalSquadraOspite() {
		return goalSquadraOspite;
	}

	public void setGoalSquadraOspite(int goalSquadraOspite) {
		this.goalSquadraOspite = goalSquadraOspite;
	}

	@Override
	public String toString() {
		return "Concerto [id=" + getId() + ", titolo=" + getTitolo() + ", dataEvento=" + getDataEvento() + ", descrizione=" + getDescrizione()
				+ ", tipoEvento=" + getTipoEvento() + ", numeroMassimoPartecipanti=" + getNumeroMassimoPartecipanti()
				+ ", location=" + getLocation() + ", squadra in casa=" + getSquadraDiCasa() + ", squadra ospite=" + getSquadraOspite() + ", squadra vincente=" + getSquadraVincente() +"]";
	}
}
