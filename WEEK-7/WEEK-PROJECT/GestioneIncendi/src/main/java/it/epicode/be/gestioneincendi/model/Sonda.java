package it.epicode.be.gestioneincendi.model;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Sonda extends Subject {
	
	private int id;
	private double latitudine;
	private double longitudine;
	
	@Setter(value=AccessLevel.NONE)
	private int smokeLevel = 0;
	private final int maxSmokeLevel = 5;

	public Sonda(int id, double latitudine, double longitudine) {
		this.id = id;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}
	
	public void setSmokeLevel(int smokeLevel) {
		this.smokeLevel = smokeLevel;
		
		if (smokeLevel > maxSmokeLevel) {
			super.updateObservers();
		}
	}
}
