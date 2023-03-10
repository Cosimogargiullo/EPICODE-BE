package it.epicode.bw.models;

import java.time.LocalDate;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class MezzoTrasporto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column (name = "stato_mezzo")
	private StatoMezzo statoMezzo;
	
	@Column (name = "inizio_manutenzione")
	private LocalDate inizioManutenzione;
	
	@Column (name = "fine_manutenzione")
	private LocalDate fineManutenzione;
	
	@Column (name = "inizio_servizio")
	private LocalDate inizioServizio;
	
	@Column (name = "fine_servizio")
	private LocalDate fineServizio;
	
	@Column (name = "numero_biglietti")
	private int trattePercorse= 0;
	
	@Enumerated(EnumType.STRING)
	private TipoMezzo tipoMezzo;
	
	@ManyToOne
	private Tratta tratta;
	

	private int capienza;

//	CONSTRUCTORS

	public MezzoTrasporto(StatoMezzo statoMezzo, LocalDate inizioManutenzione, LocalDate fineManutenzione,
			LocalDate inizioServizio, LocalDate fineServizio, int numeroBiglietti, TipoMezzo tipoMezzo, Tratta tratta) {
		
		this.statoMezzo = statoMezzo;
		this.inizioManutenzione = inizioManutenzione;
		this.fineManutenzione = fineManutenzione;
		this.inizioServizio = inizioServizio;
		this.fineServizio = fineServizio;
		this.tipoMezzo = tipoMezzo;
		this.tratta = tratta;
		this.capienza = tipoMezzo.capienza;
	}
	public MezzoTrasporto() {		
	}

//	GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StatoMezzo getStatoMezzo() {
		return statoMezzo;
	}

	public void setStatoMezzo(StatoMezzo statoMezzo) {
		this.statoMezzo = statoMezzo;
	}

	public LocalDate getInizioManutenzione() {
		return inizioManutenzione;
	}

	public void setInizioManutenzione(LocalDate inizioManutenzione) {
		this.inizioManutenzione = inizioManutenzione;
	}

	public LocalDate getFineManutenzione() {
		return fineManutenzione;
	}

	public void setFineManutenzione(LocalDate fineManutenzione) {
		this.fineManutenzione = fineManutenzione;
	}

	public LocalDate getInizioServizio() {
		return inizioServizio;
	}

	public void setInizioServizio(LocalDate inizioServizio) {
		this.inizioServizio = inizioServizio;
	}

	public LocalDate getFineServizio() {
		return fineServizio;
	}

	public void setFineServizio(LocalDate fineServizio) {
		this.fineServizio = fineServizio;
	}

	public int getTrattePercorse() {
		return trattePercorse;
	}

	public void setTrattePercorse(int trattePercorse) {
		this.trattePercorse = trattePercorse;
	}

	public TipoMezzo getTipoMezzo() {
		return tipoMezzo;
	}

	public void setTipoMezzo(TipoMezzo tipoMezzo) {
		this.tipoMezzo = tipoMezzo;
	}

	public Tratta getTratta() {
		return tratta;
	}

	public void setTratta(Tratta tratta) {
		this.tratta = tratta;
	}

	public int getCapienza() {
		return capienza;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}
	
	@Override
	public String toString() {
		return "MezzoTrasporto [id=" + id + ", statoMezzo=" + statoMezzo + ", inizioManutenzione=" + inizioManutenzione
				+ ", fineManutenzione=" + fineManutenzione + ", inizioServizio=" + inizioServizio + ", fineServizio="
				+ fineServizio + ", tipoMezzo=" + tipoMezzo + ", capienza=" + capienza + "]";
	}
	
	
}