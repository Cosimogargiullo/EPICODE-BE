package it.epicode.week2Day3;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		MyThread t1 = new MyThread("*");
		MyThread t2 = new MyThread("#");

		t1.start();
		t1.join();
		t2.start();
	}

}

class MyThread extends Thread {
	private String symb;

	public MyThread(String symb) {
		this.symb = symb;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this.getName() + " " + this.symb);
		}
	}
}
