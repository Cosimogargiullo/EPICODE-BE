package it.epicode.G4;

public class Dipendente {

//	Properties ------------------------------------------------------------------
	public static double stipendioBase = 1000;

	private String matricola; 	
	private double stipendio;
	private double importoOrarioStraordinario;
	private Livello livello;
	private Dipartimento dipartimento;

//	Constructors ------------------------------------------------------------------
	public Dipendente(String matricola, Dipartimento dipartimento) {
		this.matricola = matricola;
		this.importoOrarioStraordinario = 30;
		this.livello = Livello.OPERAIO;
		this.stipendio = Dipendente.stipendioBase;
		this.dipartimento = dipartimento;
	}
	
	public Dipendente(String matricola, double importoS,  Livello string, double stipendio, Dipartimento string2) {
		this.matricola = matricola;
		this.importoOrarioStraordinario = importoS;
		this.livello = string;
		this.stipendio = stipendio;
		this.dipartimento = string2;
	}

//	Getters ------------------------------------------------------------------
	public String getMatricola() {
		return matricola;
	}

	public double getStipendio() {
		return stipendio;
	}

	public Livello getLivello() {
		return livello;
	}

	public Dipartimento getDipartimento() {
		return dipartimento;
	}

	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}

//	Setters ------------------------------------------------------------------
	public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}

//	Methods
	public void stampaDatiDipendente() {
		System.out.printf("Dipendente: %n - Matricola: %s:%n - Livello: %s;%n - Dipartimento: %s;%n - Stipendio: %f%n",
				matricola, livello, dipartimento, stipendio);
	}

	public Livello promuovi() {
		if (this.livello == Livello.OPERAIO) {
			this.stipendio = Dipendente.stipendioBase*Livello.IMPIEGATO.getMoltiplicatoreStipendio();
			return Livello.IMPIEGATO;
		} else if (this.livello == Livello.IMPIEGATO) {
			this.stipendio = Dipendente.stipendioBase*Livello.QUADRO.getMoltiplicatoreStipendio();
			return Livello.QUADRO;
		} else if (this.livello == Livello.QUADRO) {
			this.stipendio = Dipendente.stipendioBase*Livello.DIRIGENTE.getMoltiplicatoreStipendio();
			return Livello.DIRIGENTE;
		} else {
			System.out.println("Errore,il tuo ruolo e gia il piu importante:");
			return this.livello;
		}
	}
	
//	Static Method 
	public static double calcolaPaga(Dipendente d) {
		return d.getStipendio();
	}
	
	public static double calcolaPaga(Dipendente d, int n) {
		return (d.getStipendio()) + (d.getImportoOrarioStraordinario() * n);
	}

}
