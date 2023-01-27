package week2.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class Main8 {

	public static void main(String[] args) {
		
		// generazione della sorgente
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, -40, -56, 1));

		// predicato
		Predicate<Integer> posNumber = n -> n > 0; 
		
		// sono tutti numeri positivi?
		boolean allPositive = numbers.stream().allMatch(posNumber);
		System.out.println( allPositive );
		
		// c'è almeno un numero positivo?
		System.out.println(numbers.stream().anyMatch(posNumber));
		// sono tutti numeri non positivi (negativi)?
		System.out.println( numbers.stream().noneMatch(posNumber) );
		
		// old-school
		boolean match = false;
		for(int i = 0; i < numbers.size(); i++) {
			if( numbers.get(i) > 0 ) {
				match = true;
				break;
			}
		}
		System.out.println( match );
		
		int sum = 0;
		for(Integer n : numbers) {
			sum += n;
		}
		System.out.println( "la somma è: " + sum );
		
		System.out.println( "la somma è: "+ numbers.stream().reduce(0, (result, n) -> result + n ) );
		
	}

}
