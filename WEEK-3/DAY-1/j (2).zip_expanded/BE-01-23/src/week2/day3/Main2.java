package week2.day3;

public class Main2 {

	public static void main(String[] args) {
		
		C2 c1 = new C2("mela", "Thread-NewYork");
		C2 c2 = new C2("ananas", "Thread-LasVegas");
		
		c1.start();
		c2.start();
		
		System.out.println( "Nome main thread: " + Thread.currentThread().getName() );

	}

}

class C2 extends Thread {
	
	private String str;
	private String threadName;
	
	public C2(String str, String threadName) {
		this.str = str;
		this.threadName = threadName;
		this.setName(threadName);
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 100; i++) {
			System.out.println( "str: " + str + " i: " + i );
			System.out.println( "Nome thread: " + Thread.currentThread().getName() );
		}
	}
	
}