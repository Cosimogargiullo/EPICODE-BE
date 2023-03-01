package it.epicode.be.gestioneincendi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InfoSonda {
	private final int id;
	private final int smokeLevel;
	private final double latitudine;
	private final double longitudine;
}
