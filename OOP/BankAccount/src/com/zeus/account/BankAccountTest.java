package com.zeus.account;

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount user1 = new BankAccount("Bob");
		BankAccount user2 = new BankAccount("Alex");
		user1.getAccountNumber();
		user1.getCheckingBalance();
		user1.chekingDeposit(234.23);
		user1.savingDeposit(9894834.32);
		user1.savingWithdraw(94834.32);
		user2.chekingDeposit(342.53);
		user2.chekingWithdraw(4232.53);
		user1.accountTotal();
		user2.accountTotal();

		
		System.out.println(user1.getAccountNumber());
		System.out.println(user1.getName());
		System.out.println(BankAccount.numAccounts);
		System.out.println(BankAccount.getTotalMoney());
		System.out.println(user1.getCheckingBalance());
		System.out.println(user1.getSavingBalance());
		

	}

}
