package it.epicode.be.godfather.config;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.context.annotation.Bean;

import it.epicode.be.godfather.GestioneMenu;
import it.epicode.be.godfather.model.Ordine;
import it.epicode.be.godfather.model.StatoOrdine;


public class OrdineConfig {
	
	@Bean
	public Ordine ordine() {
		Ordine o = new Ordine();
		o.setStatoOrdine(StatoOrdine.INCORSO);
		o.setOraCreazione(LocalDateTime.now());
		o.setMenuItems(new HashMap());
		o.setPrezzoCoperto(2.50);
		return o;
	}
	
	
}
