package it.epicode.giorno2esercizio2;

public class Errori extends Exception {

	public Errori() {
		System.out.println( "I litri consumati devono essere > di 0" );
	}
}
