package com.codegnan.multithreading;

import java.util.Scanner;

class NumberPrinters{
	private int number = 1;
	private int n;
	private boolean turn = true;
	
	public NumberPrinters(int n) {
		super();
		this.n = n;
	}
	
	public synchronized void printOdd() {
		while(number <=n) {
			while(!turn) {
				try {
					wait();
				} catch (InterruptedException e) {}
			}
			if(number <=n) {
				System.out.println(number + " ");
				number++;
				turn = false;
				notify();
			}
		}
	}
	
	public synchronized void printEven() {
		while(number <=n) {
			while(turn) {
				try {
					wait();
				} catch (InterruptedException e) {}
			}
			if(number <=n) {
				System.out.println(number + " ");
				number++;
				turn = true;
				notify();
			}
		}
	}
}

class Thread1 extends Thread{
	NumberPrinters printer;

	public Thread1(NumberPrinters printer) {
		super();
		this.printer = printer;
	}
	
	public void run() {
		printer.printOdd();
	}
}

class Thread2 extends Thread {
	NumberPrinters printer;

	public Thread2(NumberPrinters printer) {
		super();
		this.printer = printer;
	}
	
	public void run() {
		printer.printEven();
	}
}
public class Main45 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		NumberPrinters printer = new NumberPrinters(n);
		
		Thread t1 = new Thread(new Thread1(printer));
		Thread t2 = new Thread(new Thread2(printer));

		t1.start();
		t2.start();
		sc.close();
	}

}
