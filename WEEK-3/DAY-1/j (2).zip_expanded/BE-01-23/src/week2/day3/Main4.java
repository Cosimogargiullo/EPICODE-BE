package week2.day3;

public class Main4 {

	public static void main(String[] args) {
		
		/*
		for(int i = 1; i <= 10; i++) {
			System.out.println( i );
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}
		*/
		
		C3 t1 = new C3("ananas");
		C3 t2 = new C3("mandarino");
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			
		}
		
		t2.start();

	}

}

class C3 extends Thread {
	
	private String word;
	
	public C3(String word) {
		this.word = word;
	}
	
	@Override
	public void run() {
		char[] wordCharacters = this.word.toCharArray();
		for(int i = 0; i < wordCharacters.length; i++) {
			System.out.print( wordCharacters[i] );
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
		}
		System.out.println();
		
	}
	
}