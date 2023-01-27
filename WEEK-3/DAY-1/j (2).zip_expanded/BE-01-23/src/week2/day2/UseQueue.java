package week2.day2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UseQueue {

	public static void main(String[] args) {
		
		Queue<String> q = new LinkedList<>();
		// POSTA
		q.add( "red" );
		q.add( "blue" );
		q.add( "green" );
		q.add( "white" );
		q.add( "gray" );
		
		System.out.println( q );
		
		System.out.println( q.peek() );
		//System.out.println( q.poll() );
		System.out.println( q );
		
		// POSTA SERVICE
		int s = q.size();
		for(int i = 0; i < s; i++) {
			System.out.println( q.poll() + " ha finito!" );
		}
		
		System.out.println( "la coda è: " + q );
		
		List<String> q2 = new LinkedList<>();
		Deque<String> q3 = new LinkedList<>();
		q3.add( "first" );
		q3.add( "second" );
		q3.add( "third" );
		
	}

}
