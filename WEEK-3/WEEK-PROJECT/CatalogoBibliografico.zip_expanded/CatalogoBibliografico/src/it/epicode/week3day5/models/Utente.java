package it.epicode.week3day5.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Utente {
	@Id
	@SequenceGenerator(name = "utente_seq", sequenceName = "utente_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "utente_seq")
	private Long id;
	
	private String nome;
	private String cognome;
//	@Column(name = "data_nascita")
	private LocalDate dataNascita;
//	@Column(name = "numero_tessera")
	private int numeroTessera;

//	CONSTRUCTORS -----------------------------------------
	public Utente() {

	}

	public Utente(String nome, String cognome, LocalDate dataNascita, int numeroTessera) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.numeroTessera = numeroTessera;
	}

//	GETTERS / SETTERS -----------------------------------------
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public int getNumeroTessera() {
		return numeroTessera;
	}

	public void setNumeroTessera(int numeroTessera) {
		this.numeroTessera = numeroTessera;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita
				+ ", numeroTessera=" + numeroTessera + "]";
	}

}
