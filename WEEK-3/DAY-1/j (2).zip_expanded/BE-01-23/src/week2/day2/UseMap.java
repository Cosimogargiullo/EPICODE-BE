package week2.day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UseMap {

	public static void main(String[] args) {
		
		HashMap<String, String> person1 = new HashMap<>();
		person1.put("firstname", "Mario");
		person1.put("lastname", "Rossi");
		person1.put("age", "150");
		
		person1.replace("lastname", "Verdi");
		System.out.println( person1.get("lastname") );
		
		// 1 iteratore su Map.Entry (record chiave-valore)
		Set records = person1.entrySet();
		Iterator i1 = records.iterator(); 
		while( i1.hasNext() ) {
			Map.Entry record = (Map.Entry)i1.next();
			System.out.println( "chiave: " + record.getKey()  + " valore: " + record.getValue() );
		}
		
		System.out.println( person1.keySet() );
		
		// 2 iteratore su Set di chiavi
		Iterator<String> i2 = person1.keySet().iterator();
		while( i2.hasNext() ) {
			String key = i2.next();
			System.out.println( "prossimo valore: " + key + " valore: " + person1.get(key) );
		}
		
		// 3 for su Set di chiavi
		for( String key : person1.keySet() ) {
			System.out.println( key + " " + person1.get(key) );
		}
		
		Student s = new Student();
		s.rates = new ArrayList<>() {{
			add( new HashMap<>() {{ 
				put( "matematica", "10" );
				put( "storia", "8" );
			}} );
			
			add( new HashMap<>() {{ 
				put( "italiano", "10" );
				put( "inglese", "8" );
			}} );
		}};
		
		for(int i = 0; i < s.rates.size(); i++) {
			HashMap<String, String> rate = s.rates.get(i);
			for( String key : rate.keySet() ) {
				System.out.println( "materia: " + key + " voto: " + rate.get(key) );
			}
		}
		
	}

}

class Student {
	
	ArrayList<HashMap<String, String>> rates = new ArrayList<>();
	
}
