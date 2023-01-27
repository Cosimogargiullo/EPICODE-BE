package week2.day3;

public class Main3 {

	public static void main(String[] args) {
		
		Dog d1 = new Dog("d1");
		Dog d2 = new Dog("d2");
		
		Thread t1 = new Thread( d1, "thread d1" );
		Thread t2 = new Thread( d2, "thread d2" );
		Thread t3 = new Thread( new Dog("d3"), "thread d3" );
		
		t1.start();
		t2.start();
		t3.start();

	}

}

interface Jumpable {
	// ...
}

abstract class Mammal {
	// ...
}

abstract class Animal extends Mammal {
	// ...
}

class Dog extends Animal implements Runnable, Jumpable {
	
	private String str;
	
	public Dog(String str) {
		this.str = str;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 100; i++) {
			System.out.println( "str: " + str + " i: " + i );
			System.out.println( "Nome thread: " + Thread.currentThread().getName() );
		}
	}
	
}
