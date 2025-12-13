package com.codegnan.multithreading;

import java.util.Scanner;

class TicketCounter11{
	private int ticket = 1;
	private int limit;
	
	public TicketCounter11(int limit) {
		super();
		this.limit = limit;
	}
	
	public synchronized void issueTicket() {
		if(ticket<=limit) {
			System.out.print("Ticket "+ticket+" ");
			if(ticket<limit)
				System.out.print(" ");
			ticket++;
		}
	}
}

class MyThread3 extends Thread{
	private TicketCounter11 counter;
	private int n;
	
	public MyThread3(TicketCounter11 counter, int n) {
		super();
		this.counter = counter;
		this.n = n;
	}
	
	public void run() {
		for(int i=0; i<n; i++) {
			counter.issueTicket();
		}
	}
}
public class Main44 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		TicketCounter11 counter = new TicketCounter11(n);
		
		Thread t1 = new Thread(new MyThread3(counter, n));
		Thread t2 = new Thread(new MyThread3(counter, n));

		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t2.start();
		
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}

}
