package week2.day4;

import java.util.function.Function;

public class Main3 {

	public static void main(String[] args) {
		
		Function<String, Integer> doublyLength = s -> s.length() * 2;
		Function<Integer, Integer> doublyTen = n -> n * 10;
		
		String s = "ananas";
		System.out.println( "la lunghezza doppia di " + s + " è: " + doublyLength.apply(s) );
		// concatenazione di due chiamate di funzione dove il risultato della prima viene passato
		// in ingresso alla seconda
		System.out.println( doublyLength.andThen(doublyTen).apply(s) );
		
		applyFunctions(
			10,
			n -> n * 10,
			n -> n * 2
		);
		
		applyFunctions(
			4,
			n -> n / 2,
			n -> {
				int z = n * 2, k = n * 3;
				z += k;
				return z;
			}
		);
		
	}
	
	public static void applyFunctions(int n, Function<Integer, Integer> fn1, Function<Integer, Integer> fn2) {
		System.out.println( fn1.andThen(fn2).apply(n) );
	}

}
