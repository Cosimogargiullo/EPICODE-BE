package it.epicode.bw.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tratta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Enumerated(EnumType.STRING)
	private TratteEnum tratte;
	
	private double tempoMedio;
	private double tempoEffettivo;

	@OneToMany
	private List<MezzoTrasporto> mezzo = new ArrayList<MezzoTrasporto>();

	public Tratta(TratteEnum tratte) {
		this.tratte = tratte;
		this.tempoMedio = this.tratte.tempoPercorrenzaPrevisto;;
	}
	public Tratta() {
	}

	public void setMezzo(MezzoTrasporto mezzo) {
		this.mezzo.add(mezzo);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public TratteEnum getTratte() {
		return tratte;
	}
	public void setTratte(TratteEnum tratte) {
		this.tratte = tratte;
	}
	public double getTempoMedio() {
		return tempoMedio;
	}
	public void setTempoMedio(double tempoMedio) {
		this.tempoMedio = tempoMedio;
	}
	public double getTempoEffettivo() {
		return tempoEffettivo;
	}
	public void setTempoEffettivo(double tempoEffettivo) {
		this.tempoEffettivo = tempoEffettivo;
	}
	public List<MezzoTrasporto> getMezzo() {
		return mezzo;
	}
	public void setMezzo(List<MezzoTrasporto> mezzo) {
		this.mezzo = mezzo;
	}

	
}
