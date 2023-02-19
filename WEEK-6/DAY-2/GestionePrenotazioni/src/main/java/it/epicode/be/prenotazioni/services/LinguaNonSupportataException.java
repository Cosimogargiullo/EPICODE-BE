package it.epicode.be.prenotazioni.services;

public class LinguaNonSupportataException extends RuntimeException {

	private String info = "Lingua non Supportata";
	
	@Override
	public String getMessage() {
		System.out.println("-----------------------------------ERRORE LINGUA-----------------------------------");
		return info;
		
	};
}
