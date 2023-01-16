package it.epicode.giorno2esercizio1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int[] arr = new int[5];
		int n = 1, p;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.floor(Math.random() * 10) + 1);
		}
		System.out.println(Arrays.toString(arr));
		Scanner in = new Scanner(System.in);

		while (!(n == 0)) {
			try {
				System.out.println("Scegli un numero da 1 a 10:");
				n = Integer.parseInt(in.nextLine());
				if (n == 0) {
					System.out.println("Programma terminato con successo!");
					break;
				} else if (n < 0 || n > 10) {
					throw new NumberFormatException();
				}
				System.out.println("Con quale posizione desideri scambiarlo? inserire una posizione 1-5:");
				p = Integer.parseInt(in.nextLine());
				arr[p - 1] = n;
				System.out.println(Arrays.toString(arr));
			} catch (NumberFormatException e) {
				System.out.println("Si prega di inserire solo Numeri da 1 a 10!");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Puoi inserire solo posizioni da 1 a 5");
			}
		}
		in.close();
	}

}
