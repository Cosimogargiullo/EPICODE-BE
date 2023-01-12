package it.epicode.Giorno3;

public class Main {

	public static void main(String[] args) {
		print(0);
		print(1);
		print(2);
		print(3);
		print(4);
	}

//	STAMPA COMPRESO TRA 0-3
	public static void print(int n) {
		switch (n) {
		case 0:
			System.out.println("zero");
			break;
		case 1:
			System.out.println("uno");
			break;
		case 2:
			System.out.println("due");
			break;
		case 3:
			System.out.println("tre");
			break;
		default:
			System.out.println("ERROR");
		}
	}
}
