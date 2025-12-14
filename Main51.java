package com.codegnan.multithreading;

import java.util.Scanner;

class SharedTotal {
	int total =0;
	
	public synchronized void add(int value) {
		total+=value;
	}
}

class AddThread extends Thread{
	private SharedTotal shared;
	private int n;
	private int value;
	public AddThread(SharedTotal shared, int n, int value) {
		super();
		this.shared = shared;
		this.n = n;
		this.value = value;
	}
	
	public void run() {
		for(int i=0;i<n; i++) {
			shared.add(value);
		}
	}
}
public class Main51 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int value = sc.nextInt();
		
		SharedTotal shared = new SharedTotal();
		
		Thread t1 = new Thread(new AddThread(shared, n, value));
		Thread t2 = new Thread(new AddThread(shared, n, value));

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
		
		System.out.println(shared.total);
		sc.close();
	}

}
