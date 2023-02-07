package it.epicode.be.godfather.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCreation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ordine {

	private int idOrdine;
	private Tavolo tavolo;
	private HashMap<MenuItem, String> menuItems;
	private StatoOrdine statoOrdine;
	private int numeroCoperti;
	private LocalDateTime oraCreazione;
	private double prezzoCoperto;
	private double costoTot;

	public Ordine(int id, Tavolo tavolo, int coperti) {
		this.idOrdine = id;
		this.tavolo = tavolo;
		this.numeroCoperti = coperti;
	}

	public void setMenuItems(MenuItem item, String nota) {
		this.menuItems.put(item, nota);
	}
	
	public void getTotale() {
		this.menuItems.forEach((key, value)-> this.costoTot+= key.getPrice());
		this.costoTot = this.costoTot + (this.prezzoCoperto * this.numeroCoperti);
	}
	
}
