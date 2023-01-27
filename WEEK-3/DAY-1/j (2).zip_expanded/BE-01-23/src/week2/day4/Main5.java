package week2.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main5 {

	public static void main(String[] args) {
		
		ArrayList<String> words = new ArrayList<>(Arrays.asList("primo", "secondo", "terzo"));
		//words.forEach(s -> System.out.println(s));
		words.forEach( System.out::println );
		
		HashMap<String, String> map = new HashMap<>() {{
			put("firstname", "mario");
			put("lastname", "rossi");
		}};
		
		map.forEach((k, v) -> {
			System.out.println( "k: " + k + " v: " + v );
		});
		
		map.replaceAll((k, v) -> "***" + v + "***" );
		System.out.println( map );
		
		words.removeIf( word -> word.charAt(0) == 's' );
		System.out.println( words );

	}

}
