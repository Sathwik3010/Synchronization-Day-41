package com.codegnan.multithreading;

public class BankAccount {
	private double balance;
	
	public BankAccount(double balance) {
		this.balance = balance;
		}
	
	public synchronized void withdraw(String user, double amount) {
		System.out.println(user+" trying to withdraw Amount "+amount);
		
		if(balance >= amount) {
			System.out.println(user+" is Processing the withdrawl");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			balance -=amount;
			System.out.println(user+" completed withdrawl. Remaining Balance "+balance);
		} else {
			System.out.println(user+" insufficient funds! available balance is " + balance);
		}
		System.out.println("--------------------------------");
	}
}
