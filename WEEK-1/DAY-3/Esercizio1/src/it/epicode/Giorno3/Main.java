package it.epicode.Giorno3;

public class Main {

	public static void main(String[] args) {
		System.out.println(stringaPariDispari("ciao"));
		System.out.println( annoBisestile(1900));
	}

//	PARI O DISPARI
	public static boolean stringaPariDispari(String s) {
		if (s.length() % 2 == 0) {
			return true;
		}
		return false;
	}

//	ANNO BISESTILE
	public static boolean annoBisestile(int y) {
		if ((y % 400 == 0) || (y % 4 == 0 && y % 100 != 0)) {
			return true;
		}
		return false;
	}

}
