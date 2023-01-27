package week2.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main7 {

	public static void main(String[] args) {
		
		// da collection
		System.out.println("--------------------");
		System.out.println("da collection");
		System.out.println("--------------------");
		// sorgente
		ArrayList<String> students = new ArrayList<>() {{
			add("mario");
			add("luigi");
			add("yoshi");
			add("peach");
			add("lorenzo");
		}};
		
		// realizzazione stream
		Stream<String> studentsStream = 
				students.stream().filter(
					(student) -> student.charAt(0) == 'l'
				);
		
		// iterazione
		studentsStream.forEach(student -> {
			System.out.println( "Student: " + student );
		});
		
		
		// da array nativo
		System.out.println("--------------------");
		System.out.println("da array nativo");
		System.out.println("--------------------");
		Student[] students2 = {
			new Student("mario", 7),
			new Student("luigi", 9),
			new Student("toad", 3),
			new Student("peach", 8),
			new Student("yoshi", 4)
		};
		
		Stream<Student> studentsPassed = 
				Arrays.stream(students2);
		
		Predicate<Student> ps1 = student -> student.getAvg() >= 6.0;
		studentsPassed
			.filter( ps1 )
			.forEach( System.out::println );
		
		
		// generate
		System.out.println("--------------------");
		System.out.println("generate");
		System.out.println("--------------------");
		Stream.generate( () -> "elemento" )
			.limit(10)
			.forEach( el -> System.out.println(el) );
		
		// builder
		System.out.println("--------------------");
		System.out.println("builder");
		System.out.println("--------------------");
		Stream<String> stringStream = Stream.<String>builder()
				.add("primo elemento")
				.add("secondo elemento")
				.add("terzo elemento")
				.build();
		
		stringStream.forEach( el -> System.out.println(el) );
		
		// iterate
		System.out.println("--------------------");
		System.out.println("iterate");
		System.out.println("--------------------");
		Stream.iterate(1, n -> n + 1)
			.limit(10)
			.filter(n -> n % 2 != 0)
			.forEach( System.out::println );
		
		
		// mapping
		System.out.println("--------------------");
		System.out.println("mapping");
		System.out.println("--------------------");
		ArrayList<Student> studentList = new ArrayList<>() {{
			add( new Student("lino", 8) );
			add( new Student("pino", 9) );
			add( new Student("gino", 5) );
			add( new Student("mino", 4) );
		}};
		Stream<Student> studentsStream2 = 
				studentList.stream()
				.map( student -> {
					student.setName("valore");
					return student;
				});
		
		studentsStream2.forEach( System.out::println );
		
		// mapping
		System.out.println("--------------------");
		System.out.println("mapping");
		System.out.println("--------------------");
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(100, 200, 300, 400));
		Stream<Integer> numbersStream =	numbers.stream()
				.map( n -> n + 14 );
		
		numbersStream.forEach(n -> System.out.println( "il numero modificato è: " + n ));
			
		
		
	}

}

class Student {
	private String name;
	private double avg;
	
	public Student(String n, double a) {
		this.name = n;
		this.avg = a;
	}
	
	public double getAvg() {
		return this.avg;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	@Override
	public String toString() {
		return "Ciao mi chiamo " + this.name + " e ho la media del " + this.avg;
	}
}
