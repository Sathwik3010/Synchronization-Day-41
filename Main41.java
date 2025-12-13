package com.codegnan.multithreading;

import java.util.Scanner;

class Counter{
	private  int count = 0;
	
	public synchronized void increment() {
		count++;
	}
	
	public int getCount() {
		return count;
	}
}

class MyThreads extends Thread{
	private Counter counter;
	private int n;
	
	public MyThreads(Counter counter, int n) {
		super();
		this.counter = counter;
		this.n = n;
	}
	
	public void run() {
		for(int i=0; i<n; i++) {
			counter.increment();
		}
	}
}
public class Main41 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Counter counter = new Counter();
		
		Thread t1 = new Thread(new MyThreads(counter, n));
		Thread t2 = new Thread(new MyThreads(counter, n));

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
		
		System.out.println(counter.getCount());
		sc.close();
	}

}
