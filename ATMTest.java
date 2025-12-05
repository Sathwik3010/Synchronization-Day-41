package com.codegnan.multithreading;

public class ATMTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount account = new BankAccount(12000);
		UserA a = new UserA(account);
		UserB b = new UserB(account);
		UserC c = new UserC(account);
		
		Thread t1 = new Thread(a, "User A");
		Thread t2 = new Thread(b, "User B");
		Thread t3 = new Thread(c, "User C");

		t1.start();
		t2.start();
		t3.start();
	}

}
