package it.epicode.giorno2esercizio2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int km, l;

		Scanner in = new Scanner(System.in);
		try {
			System.out.println("Quanti km sono stati percorsi?");
			km = Integer.parseInt(in.nextLine());
			if (km <= 0) {
				throw new NumberFormatException();
			}
			System.out.println("Quanti litri di carburante sono stati consumati?");
			l = Integer.parseInt(in.nextLine());
			if (l == 0) {
				throw new Errori();
			}
			System.out.println(km / l);
		} catch (NumberFormatException e) {
			System.out.println("Si prega di inserire solo valori Numerici > di 0");
		} catch (Errori e) {
		}
		in.close();

	}

}
