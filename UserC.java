package com.codegnan.multithreading;

public class UserC implements Runnable{
	BankAccount account;
	
	public UserC(BankAccount account) {
		super();
		this.account = account;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		account.withdraw(Thread.currentThread().getName(), 7000);
	}

}
