package utils;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="eventi")
@Getter
@Setter
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String titolo;
	
	private LocalDate data_evento;
	
	private String descrizione;
	
	@Enumerated(EnumType.STRING)
	private TipoEvento tipo_evento;
	
	private int numero_massimo_partecipanti;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData_evento() {
		return data_evento;
	}

	public void setData_evento(LocalDate data_evento) {
		this.data_evento = data_evento;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public TipoEvento getTipo_evento() {
		return tipo_evento;
	}

	public void setTipo_evento(TipoEvento tipo_evento) {
		this.tipo_evento = tipo_evento;
	}

	public int getNumero_massimo_partecipanti() {
		return numero_massimo_partecipanti;
	}

	public void setNumero_massimo_partecipanti(int numero_massimo_partecipanti) {
		this.numero_massimo_partecipanti = numero_massimo_partecipanti;
	}
	
	

}