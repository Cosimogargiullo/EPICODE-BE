package week2.day2;

import java.util.HashSet;
import java.util.Iterator;

public class UseSet {

	public static void main(String[] args) {
		
		HashSet<Character> chars = new HashSet<>();
		chars.add('a');
		chars.add('b');
		chars.add('c');
		chars.add('d');
		chars.add('c');
		
		System.out.println( chars );
		System.out.println( chars.contains('x') );
		
		Box b1 = new Box(30, 30);
		HashSet<Box> boxes = new HashSet<>();
		boxes.add( new Box(10, 20) );
		boxes.add( new Box(20, 20) );
		boxes.add( new Box(10, 20) );
		boxes.add(b1);
		
		System.out.println( boxes.contains(b1) );
		System.out.println( "boxes: " + boxes.contains( new Box(20, 20) ) );
		
		HashSet<Integer> numbers = new HashSet<>();
		numbers.add(10);
		numbers.add(20);
		System.out.println( numbers.contains( new Integer(10) ) );
		
		// iteratore su Set di valori
		Iterator<Integer> i = numbers.iterator();
		while( i.hasNext() ) {
			System.out.println( "prossimo valore: " + i.next() );
		}
		
		Box b2 = new Box(20, 20);
		Box b3 = new Box(20, 20);
		System.out.println( b2.equals(b3) );
		
		// for sui valori
		for(Integer number : numbers) {
			System.out.println( number );
		}
	}

}
