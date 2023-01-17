package it.epicode.giorno2;

public class Main {

	public static void main(String[] args) {
		
		RubricaTelefonica r1 = new RubricaTelefonica();
		
		r1.inserisciContatto("Laura", "3647589934");
		r1.inserisciContatto("Cosimo", "3649589934");
		r1.inserisciContatto("Giovanni", "3647589657");
		
		r1.stampaContatti();
		
		r1.cancellaContatto("Laura");
		
		r1.stampaContatti();
		
		System.out.println(r1.cercaContattoPerNumero("3647589657"));
		System.out.println(r1.cercaNumeroPerContatto("Giovanni"));
		
		
		
		

	}

}
