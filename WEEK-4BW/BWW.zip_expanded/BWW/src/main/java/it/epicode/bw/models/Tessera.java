package it.epicode.bw.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "tessere")
@Getter
@Setter
@NoArgsConstructor
@NamedQuery (name ="getDataEmissione", query = "SELECT t.dataEmissione FROM Tessera t WHERE t.codTessera = :t")
public class Tessera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "cod_tessera")
	private String codTessera;
	
	@Column(name = "data_emissione")
	private LocalDate dataEmissione;
	
	@OneToOne
	@JoinColumn(name = "utente_id", referencedColumnName = "id")
	private Utente utente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodTessera() {
		return codTessera;
	}

	public void setCodTessera(String codTessera) {
		this.codTessera = codTessera;
	}

	public LocalDate getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(LocalDate dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	
	
}
