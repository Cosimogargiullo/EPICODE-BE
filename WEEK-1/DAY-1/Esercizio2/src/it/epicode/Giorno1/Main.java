package it.epicode.Giorno1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

//		Scanner Creation
		Scanner i = new Scanner(System.in);
		
//		First String
		System.out.println("Type your name:");
		String n = i.nextLine();
		
//		Second String
		System.out.println("Type your surname:");
		String s = i.nextLine();
		
//		Third String
		System.out.println("Type your favourite hobby:");
		String h = i.nextLine();
		
//		1 Print
		System.out.println("Hi, I am " + n + " " + s + ", and I love " + h + ".");
		i.close();
		
//		2 Print
		System.out.println("Hi, I love " + h + ", my name is " + s + " " + n + ".");
		i.close();
	}

}
