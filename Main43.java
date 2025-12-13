package com.codegnan.multithreading;

import java.util.Scanner;

class Sum{
	int total=0;
	
	public synchronized void add(int value) {
		total += value;
	}
}

class MyThread2 extends Thread{
	private Sum sum;
	private int n;
	
	public MyThread2(Sum sum, int n) {
		super();
		this.sum = sum;
		this.n = n;
	}
	
	public void run() {
		for(int i=0; i<=n; i++) {
			sum.add(i);
		}
	}
}
public class Main43 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Sum sum = new Sum();
		
		Thread t1 = new Thread(new MyThread2(sum, n));
		Thread t2 = new Thread(new MyThread2(sum, n));

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
		
		System.out.println(sum.total);
		sc.close();
	}

}
