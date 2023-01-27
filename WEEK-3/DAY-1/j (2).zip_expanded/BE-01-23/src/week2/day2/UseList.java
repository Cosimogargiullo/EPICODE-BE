package week2.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UseList {

	public static void main(String[] args) {

		List<Integer> l1 = new ArrayList<>();
		// inserimento
		l1.add( 10 );
		l1.add( 20 );
		l1.add(1, 100);
		
		// recupero
		System.out.println( l1.get(0) );
		
		// iterazione
		for(int val : l1) {
			System.out.println( val );
		}
		
		for(int i = 0; i < l1.size(); i++) {
			System.out.println( l1.get(i) );
		}
		
		// cancellazione
		l1.remove(0);
		
		// modifica
		l1.set(0, 500);
		
		System.out.println( l1 );

		int[] numbers = {1,2,3};
		System.out.println( java.util.Arrays.toString(numbers) );
		
		Box b = new Box() {
			@Override
			public void hello() {
				System.out.println("ciao sono una Box modificata inline");
			}
		};
		b.x = 10;
		b.y = 20;
		b.hello();
		System.out.println(b);
		
		System.out.println("---------------------");
		
		List<String> words = new ArrayList<>() {
			{
				add("first");
				add("second");
				add("third");
			}
		};
		
		System.out.println( words );
		words.remove("second");
		System.out.println( words );
		
		List<String> words1 = new ArrayList<>( Arrays.asList("first", "second", "third") );
		words1.add(0, "zero");
		System.out.println( words1 );
		
		List<ArrayList<String>> words2 = new ArrayList<>();
		words2.add( new ArrayList<>(Arrays.asList("red", "blue", "green")) );
		words2.add( new ArrayList<>(Arrays.asList("white", "gray", "black")) );
		
		for(int i = 0; i < words2.size(); i++) {
			System.out.println( "Riga " + (i+1) );
			
			for(int j = 0; j < words2.get(i).size(); j++) {
				if(i == 1 && j == 1) {
					words2.get(i).set(j, "rainbow");
				}
				System.out.print( words2.get(i).get(j) + " " );
			}
			
			System.out.println();
		}
		
		ArrayList<Integer> numbers2 = new ArrayList<>() {{
			add(1); add(2); add(3); add(4);
		}};
		
		// 1 3 4 vs 2 3 4
		// remove(int)
		// remove(<E>)
		numbers2.remove( new Integer(1) );			// remove(index) remove(0) remove(element) remove(1)
		System.out.println( numbers2 );
		
		String s1 = "ciao";		// String.valueOf()
		String s2 = "ciao";					// prende la locazione di memoria esistente
		String s3 = new String("ciao");		// genera una nuova locazione di memoria 
		
		System.out.println( s1 == s2 );
		System.out.println( s2 == s3 );
		
		// ------------------------------------
		System.out.println("-------------------");
		
		Integer i1 = 10;		// Integer i1 = Integer.valueOf(10)
		Integer i2 = 10;
		Integer i3 = Integer.valueOf(126);
		Integer i4 = Integer.valueOf(126);
		Integer i5 = new Integer(100);
		Integer i6 = new Integer(100);
		
		// Byte, Short, Long, Float, Double, Boolean, Character
		
		System.out.println( i1 == i2 );
		System.out.println( i3 == i4 );
		System.out.println( i5 == i6 );
		System.out.println( i1 == i5 );
		
		
		ArrayList<Character> chars = new ArrayList<>() {{
			add('c');
			add('i');
			add('a');
			add('o');
		}};
		
		System.out.println( chars.contains('i') );		// equals
	}

}


class Box {
	int x,y;
	
	public Box() {}
	public Box(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void hello() {
		System.out.println("ciao sono una Box");
	}
	
	public String toString() {
		return "sono una box con valore x,y :" + this.x + " " + this.y;
	}
	
	@Override
	public boolean equals(Object box) {
		Box b = (Box)box;
		return this.x == b.x && this.y == b.y;
	}
}