package it.epicode.giorno2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		int q = 0;
		String p;
		ArrayList<String> d = new ArrayList<String>();

		Scanner in = new Scanner(System.in);
		try {
			System.out.println("Quante Parole vuoi inserire?");
			q = Integer.parseInt(in.nextLine());
			if (q <= 0) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			System.out.println("Si prega di inserire solo valori numerici e positivi!");
		}

		Set<String> s = new HashSet<String>();
		for (int i = 1; i <= q; i++) {
			System.out.println("Inserisci la " + i + " parola:");
			p = in.nextLine();
			if (s.contains(p)) {
				d.add(p);
			} else {
				s.add(p);
			}
		}
		in.close();

//		Duplicates print
		if (d.size() > 0) {
			System.out.println("Le parole duplicate sono " + d.size() + ": " + d);
		} else {
			System.out.println("Non ci sono parole duplicate!");
		}

//		Number of words 
		System.out.println("Hai inserito: " + s.size() + " parole.");

//		Print words' list
		System.out.println("Ecco la lista delle parole inserite:");
		Iterator<String> wIterator = s.iterator();
		while (wIterator.hasNext()) {
			System.out.println(" - " + wIterator.next());
		}
	}
}
