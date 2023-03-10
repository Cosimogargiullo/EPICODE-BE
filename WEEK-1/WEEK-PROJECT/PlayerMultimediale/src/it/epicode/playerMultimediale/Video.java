package it.epicode.playerMultimediale;

public class Video extends Registrazione {

//	Properties 
	private int luminosita;
//	Constructors
	public Video(String titolo) {
		super(titolo);
		this.luminosita = 5;
	}
	public Video(String titolo, int durata, int volume, int luminosita) {
		super(titolo, durata, volume);
		this.luminosita = luminosita;
	}
//	Methods
	public int aumentaLuminosita() {
		return this.luminosita--;
	}
	public int diminuisciLuminosita() {
		return this.luminosita--;
	}
	@Override
	public void play() {
		for (int i = 1; i <= getDurata(); i++) {
			System.out.println( i + "  Hai eseguito l'elemento nome: " + getTitolo() + " volume: " + "!".repeat(this.getVolume()) + " durata: " + getDurata() + "s" + " luminosita: " + "*".repeat(this.luminosita));
		};	}
}
