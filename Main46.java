package com.codegnan.multithreading;

import java.util.Scanner;

class SharedString{
	StringBuilder sb = new StringBuilder();
	
	public synchronized void appendChar(char ch) {
		sb.append(ch);
	}
}

class MyThread20 extends Thread{
	
	private SharedString shared;
	private int n;
	private char ch;
	
	
	public MyThread20(SharedString shared, int n, char ch) {
		super();
		this.shared = shared;
		this.n = n;
		this.ch = ch;
	}


	public void run() {
		for(int i=0; i<n; i++) {
			shared.appendChar(ch);
		}
	}
}

public class Main46 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char ch = sc.next().charAt(0);
		
		SharedString shared = new SharedString();
		
		Thread t1 = new Thread(new MyThread20(shared,n, ch));
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(shared.sb.toString());
		sc.close();
	}

}
