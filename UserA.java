package com.codegnan.multithreading;

public class UserA implements Runnable{

	BankAccount account;
	
	public UserA(BankAccount account) {
		super();
		this.account = account;
	}

	@Override
	public void run() {
		account.withdraw(Thread.currentThread().getName(), 7000);
	}

}
