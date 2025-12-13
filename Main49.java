package com.codegnan.multithreading;

import java.util.Scanner;

class NumberPrintersss{
	StringBuilder result = new StringBuilder();
	private int n;
	public NumberPrintersss(int n) {
		super();
		this.n = n;
	}
	
	public synchronized void printOdd() {
		for(int i=1; i<=n; i+=2) {
			result.append(i).append(" ");
		}
	}
	
	public synchronized void printEven() {
		for(int i=2; i<=n; i+=2) {
			result.append(i).append(" ");
		}
	}
	public String getResult() {
		return result.toString().trim();
		
	}
}

class OddThread extends Thread{
	private NumberPrintersss printer;

	public OddThread(NumberPrintersss printer) {
		super();
		this.printer = printer;
	}
	
	public void run() {
		printer.printOdd();
	}
}

class EvenThread extends Thread{
	private NumberPrintersss printer;

	public EvenThread(NumberPrintersss printer) {
		super();
		this.printer = printer;
	}
	
	public void run() {
		printer.printEven();
	}
}
public class Main49 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		
		NumberPrintersss printer = new NumberPrintersss(n);
		
		Thread t1 = new Thread(new OddThread(printer));
		Thread t2 = new Thread(new EvenThread(printer));

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
		
		System.out.println(printer.getResult());
		sc.close();
	}

}
