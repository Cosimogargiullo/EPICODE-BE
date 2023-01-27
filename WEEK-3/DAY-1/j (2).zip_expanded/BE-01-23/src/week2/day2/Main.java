package week2.day2;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		int x = 10;

	}
	
	@Deprecated
	public static void m1() {
		System.out.println("m1");
	}
	
	public static void m2() {
		m1();
	}

}
