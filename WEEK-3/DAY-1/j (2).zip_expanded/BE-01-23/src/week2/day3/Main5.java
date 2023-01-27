package week2.day3;

public class Main5 {

	public static void main(String[] args) {
		
		Counter c1 = new Counter();
		ThreadCounter t1 = new ThreadCounter("thread A", c1);
		ThreadCounter t2 = new ThreadCounter("thread B", c1);
		
		t1.start();
		
		t2.start();

	}

}

class Counter {
	private int count = 1;
	private static int staticCount = 1;
	
	synchronized public void increaseCounter(String tn) {
		for(int i = 1; i <= 10; i++) {
			System.out.println( "count: " + this.count + " thread name: " + tn );
			this.count++;
		}
	}
	
	public void m1() {
		for(int i = 50; i >= 45; i--) {
			System.out.println( "i: " + i + " thread name: " + Thread.currentThread().getName() );
		}
	}
	
	synchronized public static void increaseStaticCounter(String tn) {
		for(int i = 1; i <= 10; i++) {
			System.out.println( "count: " + staticCount + " thread name: " + tn );
			staticCount++;
		}
	}
}

class ThreadCounter extends Thread {
	Counter counter;
	
	ThreadCounter(String tn, Counter counter) {
		this.setName(tn);
		this.counter = counter;
	}
	
	@Override
	public void run() {
		//this.counter.m1();
		//this.counter.increaseCounter( this.getName() );
		Counter.increaseStaticCounter(getName());
	}
}
