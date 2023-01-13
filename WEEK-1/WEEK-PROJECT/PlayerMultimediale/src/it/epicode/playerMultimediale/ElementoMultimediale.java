package it.epicode.playerMultimediale;

public abstract class ElementoMultimediale {
//	Static default value
	static int def = 5;
//	Properties
	private String titolo;
//	Constructor
	public ElementoMultimediale(String titolo) {
		this.titolo = titolo;
	}
//	Getter
	public String getTitolo() {
		return titolo;
	}
//	Setter
	protected void setTitolo(String titolo) {
		this.titolo = titolo;
	}
//	Method
//	Abstract Execute
	abstract public void esegui();
}
