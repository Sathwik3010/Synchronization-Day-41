package com.codegnan.multithreading;

import java.util.Scanner;

class LimitedCounter{
	private int count = 0;
	private static final int Max = 10;
	
	public synchronized void increment() {
		if(count<Max) {
			count++;
		}
	}
	public int getCount() {
		return count;
	}
}

class MyThread100 extends Thread{
	private LimitedCounter counter;
	private int n;
	public MyThread100(LimitedCounter counter, int n) {
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
public class Main50 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LimitedCounter counter = new LimitedCounter();
		
		Thread t1 = new Thread(new MyThread100(counter, n));
		Thread t2 = new Thread(new MyThread100(counter, n));

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
