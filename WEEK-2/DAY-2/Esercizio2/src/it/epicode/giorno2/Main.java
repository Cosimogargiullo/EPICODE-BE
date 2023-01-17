package it.epicode.giorno2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {

//		System.out.println(oList(3));
		ArrayList<Integer> f = oList(9);
		System.out.println(oListInverted(f));
		System.out.println(f);
		bList(f, true);
	}

//	Function accept int and return list of casual int
	public static ArrayList<Integer> oList(int n) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			l.add((int) Math.floor(Math.random() * 101));
		}
		Collections.sort(l);
		return l;
	}

	public static ArrayList<Integer> oListInverted(ArrayList<Integer> arrayList) {
		ArrayList<Integer> o = new ArrayList<Integer>();
		for (int i = 0; i < arrayList.size(); i++) {
			o.add(arrayList.get(i));
		}
		Collections.reverse(arrayList);
		for (int i = 0; i < arrayList.size(); i++) {
			o.add(arrayList.get(i));
		}
		return o;
	}

	public static void bList(ArrayList<Integer> aL, boolean b) {
		try {if (b) {
			for (int i = 0; i <= aL.size(); i += 2) {
				System.out.println("Elementi con indice pari:");
				System.out.println(" - indice: " + i + " valore: " +  aL.get(i));
			}
		} else {
			for (int i = 1; i <= aL.size(); i += 2) {
				System.out.println("Elementi con indice dispari:");
				System.out.println(" - indice: " + i + " valore: " +  aL.get(i));
			}
		}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("L'untimo elemento non e stato stampato poi che non corrispondeva ai criteri di stampa");
		}
	}

}
