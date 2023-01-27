package week2.day2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class UseList2 {

	public static void main(String[] args) {
		
		 LinkedList<String> list=new LinkedList<String>();

	     //Adding elements to the Linked list
	     list.add("red");
	     list.add("blue");
	     list.add("green");

	     //Adding an element to the first position
	     list.addFirst("white");

	     //Adding an element to the last position
	     list.addLast("black");

	     //Adding an element to the 3rd position
	     list.add(2, "gray");
	     
	     list.addFirst("rainbow");
	     list.push("fucsia");
	     
	     System.out.println( list );
	     
	     for(int i = 0; i < list.size(); i++) {
	    	 System.out.println( list.get(i) );
	     }

	}
	
	public static void m1(Deque l) {
		
	}

}
