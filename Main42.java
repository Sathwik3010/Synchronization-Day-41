package com.codegnan.multithreading;

import java.util.Scanner;

class Counter1 {
	int count = 10;
	
	public synchronized void decrement() {
		count --;
	}
}

class MyThread1 extends Thread{
	Counter1 counter;
	int n;
	
	public MyThread1(Counter1 counter, int n) {
		super();
		this.counter = counter;
		this.n = n;
	}
	
	public void run() {
		for(int i=0; i<n; i++) {
			counter.decrement();
		}
	}
}


public class Main42 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Counter1 counter = new Counter1();
        
        Thread t1 = new Thread(new MyThread1(counter, n));
        Thread t2 = new Thread(new MyThread1(counter, n));
        
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
        
        System.out.println(counter.count);
		sc.close();
	}

}
