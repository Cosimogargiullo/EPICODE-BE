package it.epicode.playerMultimediale;

public class Immagine extends ElementoMultimediale {

//	Properties
	private int luminosita;
	
//	Constructors
	public Immagine(String titolo) {
		super(titolo);
		this.luminosita = ElementoMultimediale.def;
	}
	
	public Immagine(String titolo, int luminosita) {
		super(titolo);
		this.luminosita = luminosita;
	}
//	Getters
	public int getLuminosita() {
		return luminosita;
	}
//	Setters
	public void setLuminosita(int luminosita) {
		this.luminosita = luminosita;
	}
//	Methods
	public int aumentaLuminosita() {
		return this.luminosita--;
	}
	public int diminuisciLuminosita() {
		return this.luminosita--;
	}
	public void esegui() {
		show();
	}
	public void show() {
		System.out.println("Imm, " + getTitolo() + " " + "*".repeat(this.luminosita));
	}
}
