package it.epicode.Giorno1;

public class Main {

	public static void main(String[] args) {

		String[] a = new String[5];
		a[0] = "primo";
		a[1] = "secondo";
		a[2] = "terzo";
		a[3] = "quarto";
		a[4] = "quinto";

		// Print
		System.out.println(mul(10, 5));
		System.out.println(concat("Cosimo", 21));
		System.out.println(putIn(a, "sesto"));
	}
	// METHODs
	// Multiply method

	static int mul(int a, int b) {
		return a * b;
	}

	// Concatenate method
	static String concat(String a, int b) {
		return a + " is " + b + " years old";
	}

	// PutinArray method
	static String putIn(String[] a, String b) {
		String[] c = new String[6];
		c[0] = a[0];
		c[1] = a[1];
		c[2] = b;
		c[3] = a[2];
		c[4] = a[3];
		c[5] = a[4];
		return java.util.Arrays.toString(c);
	}

}
