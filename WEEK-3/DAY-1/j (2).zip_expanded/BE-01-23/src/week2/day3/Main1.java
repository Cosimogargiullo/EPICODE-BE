package week2.day3;

public class Main1 {

	public static void main(String[] args) {
		
		C1 c1 = new C1();
		C1 c2 = new C1();
		
		c1.start();
		c2.start();

	}

}

class C1 {
	
	private void run() {
		for(int i = 1; i <= 50; i++) {
			System.out.println( i );
		}
	}
	
	public void start() {
		this.run();
	}
	
}