package it.epicode.bw.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "abbonamenti")
@Getter
@Setter
@NoArgsConstructor

@NamedQuery(name = "getDateByCod", query= "SELECT a.dataEmissione FROM Abbonamento a WHERE a.tessera.codTessera = :c")
@NamedQuery(name = "getDurataByCod", query= "SELECT a.durataAbbonamento FROM Abbonamento a WHERE a.tessera.codTessera = :d")

public class Abbonamento extends TitoloViaggio{
	
	
//	private Utente utente;
	
	public Abbonamento(String codUnivoco, boolean convalida) {
		super(codUnivoco, convalida);
	}
	public Abbonamento() {
		super("admin", true);
	}
	
	@OneToOne
	@JoinColumn(name = "cod_tessera", referencedColumnName = "cod_tessera")
	private Tessera tessera;
	@Enumerated(EnumType.STRING)
	private DurataAbbonamento durataAbbonamento;
	
	private boolean isValid;

	public Tessera getTessera() {
		return tessera;
	}

	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}

	public DurataAbbonamento getDurataAbbonamento() {
		return durataAbbonamento;
	}

	public void setDurataAbbonamento(DurataAbbonamento durataAbbonamento) {
		this.durataAbbonamento = durataAbbonamento;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	
	
}
