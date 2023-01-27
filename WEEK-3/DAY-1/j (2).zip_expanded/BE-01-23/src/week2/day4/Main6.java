package week2.day4;

public class Main6 {

	public static void main(String[] args) {
		
		Hello h1 = new Hello("luigi");
		h1.hello();
		
		Hello h2 = new Hello("luigi") {
			@Override
			public void hello() {
				System.out.println( "Non ti saluto! " + getS() );
			}
		};
		
		h2.hello();
		
		Hello[] hellos = { h1, h2, new Hello("mario") {
			public void hello() { System.out.println("ciao!"); };
		} };
		
		for(int i = 0; i < hellos.length; i++) {
			hellos[i].hello();
		}

	}

}

class Hello {
	private String s;
	public Hello(String s) {
		this.s = s;
	}
	
	public void hello() {
		System.out.println( "Hello " + s );
	}
	
	public String getS() {
		return this.s;
	}
	
	@Override
	public String toString() {
		return "...";
	}
}
