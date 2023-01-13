package it.epicode.playerMultimediale;

public class Registrazione extends ElementoMultimediale implements Riproducibile {
//	Properties
	private int durata;
	private int volume;
//	Constructors Overload
	public Registrazione(String titolo) {
		super(titolo);
		this.durata = ElementoMultimediale.def;
		this.volume = ElementoMultimediale.def;
	}
	public Registrazione(String titolo, int durata, int volume) {
		super(titolo);
		this.durata = durata;
		this.volume = volume;
	}
//	Getters
	public int getDurata() {
		return durata;
	}
	public int getVolume() {
		return volume;
	}
//	Setters 
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
//	Methods
	public int abbassaVolume() {
		return this.volume--;
	}
	public int alzaVolume() {
		return this.volume--;
	}
	public void esegui() {
		play();
	}
	public void play() {
		System.out.println("Reg, " + getTitolo() + " " + "!".repeat(this.volume));
	}

}
