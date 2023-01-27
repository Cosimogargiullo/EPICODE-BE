package week2.day2;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

public class UseQueue2 {

	public static void main(String[] args) {
		
		Queue<String> q = new PriorityQueue<>(new MyPriorityComparator());
		
		q.add("mela");
		q.add("banana");
		q.add("ananas 2");
		q.add("pera kaiser");
		q.add("a");
		
		while( q.size() > 0 ) {
			System.out.println( q.poll() );
		}

	}

}

class MyPriorityComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if( o1.length() < o2.length() ) {
			return -1;
		}
		else if( o1.length() > o2.length() ) {
			return 1;
		}
		
		return 0;
		
	}
	
}