package com.codegnan.multithreading;

import java.util.Scanner;

class TurnCounter{
	private int number = 1;
	private int n;
	private boolean turn = true;
	
	public TurnCounter(int n) {
		super();
		this.n = n;
	}
	
	public synchronized void print(boolean myTurn) {
		while(true) {
			while(turn != myTurn && number <= n) {
				try {
					wait();
				} catch(InterruptedException e) {
					
				}
			}
			if(number >n) {
				notify();
				return;
			}
			
			System.out.print(number+" ");
			number++;
			turn = !turn;
			notify();
		}
	}
}

class ThreadOne extends Thread{
    private TurnCounter counter;

	public ThreadOne(TurnCounter counter) {
		super();
		this.counter = counter;
	}

    public void run() {
    	counter.print(true);
    }
}

class ThreadTwo extends Thread{
    private TurnCounter counter;

	public ThreadTwo(TurnCounter counter) {
		super();
		this.counter = counter;
	}

    public void run() {
    	counter.print(false);
    }
}

public class Main52 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TurnCounter counter  = new TurnCounter(n);
        
        Thread t1 = new Thread(new ThreadOne(counter));
        Thread t2 = new Thread(new ThreadTwo(counter));
        
        t1.start();
       
        
        t2.start();

        System.out.println();
		sc.close();
	}

}
