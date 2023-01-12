package it.epicode.Giorno3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		VARIABLES
		String word = null;
		String sString = null;

//		WHILE LOOP
		do {
//			Scanner. Data memorize
			Scanner in = new Scanner(System.in);
			System.out.println("inserisci una parola:");
			word = in.nextLine();
			
//			Splitting the words
			String[] sWord = word.split("");
			
			for (int i = 0; i < sWord.length; i++) {
				if (sString == null) {
					sString = sWord[i];
				} else {
					sString += ", " + sWord[i];
				}
			}

//			Print the SplitTed word
			System.out.println(sString);
		
//			Closing the loop
		} while (!":q".equals(word));
	}
}
