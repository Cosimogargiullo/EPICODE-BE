package it.epicode.G4;

public class GestioneDipendenti {

	public static void main(String[] args) {

		Dipendente d1 = new Dipendente("1",1, Livello.OPERAIO, Dipendente.stipendioBase ,  Dipartimento.PRODUZIONE);
		Dipendente d2 = new Dipendente("1",1, Livello.OPERAIO, 1200,  Dipartimento.PRODUZIONE);
		Dipendente d3 = new Dipendente("1",1,Livello.IMPIEGATO, 1500, Dipartimento.AMMINISTRAZIONE);
		Dipendente d4 = new Dipendente("1",1,Livello.DIRIGENTE, 2000, Dipartimento.VENDITE);

		d2.promuovi();
		d3.promuovi();
		print2(d1,d2,d3,d4);
		
		System.out.println(d4.getStipendio());
		
		System.out.println("La somma douta a tutti dipendenti inclusi 5 ore di straordinario ammonta a: " + print(d1,d2,d3,d4));
		
	}

	public static double print(Dipendente p, Dipendente s, Dipendente t, Dipendente q) {
		Dipendente[] arr = { p, s, t, q };
		double sum = 0;
		for (Dipendente a : arr) {
			sum += Dipendente.calcolaPaga(a, 5);
		}
		return sum;
	}

	public static void print2(Dipendente p, Dipendente s, Dipendente t, Dipendente q) {
		Dipendente[] arr = { p, s, t, q };
		for (Dipendente a : arr) {
			a.stampaDatiDipendente();
			System.out.println("---------------------------");
		}
	}
}
