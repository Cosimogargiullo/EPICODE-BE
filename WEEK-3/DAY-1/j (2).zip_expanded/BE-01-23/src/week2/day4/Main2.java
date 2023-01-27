package week2.day4;

import java.util.function.Predicate;

public class Main2 {

	public static void main(String[] args) {
		
		Predicate<Integer> moreThanTen = n -> n > 10;
		System.out.println( moreThanTen.test(20) );
		System.out.println( moreThanTen.test(-20) );
		
		Predicate<String> startsWithA = s -> s.charAt(0) == 'a' || s.charAt(0) == 'A';
		System.out.println( startsWithA.test("ciao") );
		System.out.println( startsWithA.test("ananas") );
		
		test( startsWithA, "Albero" );
		
		Predicate<Integer> lessThan100 = n -> n < 100;
		
		System.out.println( moreThanTen.or(lessThan100).test(150) );
		
	}
	
	public static void test(Predicate<String> p, String s) {
		System.out.println( "il risultato è: " + p.test(s) );
	}

}
