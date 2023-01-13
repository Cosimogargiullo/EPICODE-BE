package it.epicode.playerMultimediale;

public abstract class ElementoMultimediale {
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
	
//	Method
//	Abstract Execute
	abstract public void esegui();
	
}
