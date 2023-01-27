package week2.day4;

@FunctionalInterface
interface StringFunction {
	String generate( String s );
}

@FunctionalInterface
interface MathFunction {
	double operation( double x, double y );
}

public class Main1 {

	public static void main(String[] args) {
		
		// definizione del metodo generate
		StringFunction wrap = (s) -> "***" + s + "***";		
		StringFunction question = s -> s + "?";
		
		System.out.println( wrap.generate("ciao sono una lambda") );
		System.out.println( question.generate("sono una domanda") );
		
		StringFunction invert = s -> {
			char[] chars = s.toCharArray();
			String _s = "";
			for(int i = chars.length - 1; i >= 0; i--) {
				_s += chars[i];
			}
			return _s;
		};
		
		// chiama con question
		printModifiedString("ciao sono una stringa", question);
		// chiama con wrap
		printModifiedString("ciao sono una stringa", wrap);
		// chiama con invert
		printModifiedString("ananas", invert);
		
		
		// definizione del metodo operation
		MathFunction sum = (x, y) -> x + y;
		MathFunction diff = (x, y) -> x - y;
		MathFunction ope = (x, y) -> {
			double z = (x + y) * 10;
			return z;
		};
		
		System.out.println( sum.operation(10, 4) );
		System.out.println( diff.operation(10, 4) );
		System.out.println( ope.operation(10, 4) );
		
	}
	
	// un metodo che accetta una funzione in ingresso definita da noi
	public static void printModifiedString(String s, StringFunction fn) {
		System.out.println( fn.generate(s) );
	}

}
