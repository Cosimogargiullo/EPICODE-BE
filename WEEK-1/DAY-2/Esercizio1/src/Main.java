
public class Main {

	public static void main(String[] args) {
		Rettangolo r1 = new Rettangolo(10,5);
		Rettangolo r2 = new Rettangolo(15,20);
		
		System.out.println(r1.area());
		System.out.println(r1.perimeter());
		System.out.println(r1.printR());
		System.out.println(Rettangolo.print2R(r1, r2));
	}

}
