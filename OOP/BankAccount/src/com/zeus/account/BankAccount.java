package com.zeus.account;

import java.util.Random;

public class BankAccount {
	private String name;
	private String accountNumber;
	private Double checkingBalance=0.0;
	private Double savingBalance=0.0;
	public static int numAccounts;
	private static double totalMoney=0.0;
	
	public BankAccount(String name) {
		this.setName(name);
		this.setAccountNumber(newAccountNum());
		numAccounts++;
		
	}
	public BankAccount accountTotal() {
		double amountTotal = this.getCheckingBalance() + this.getSavingBalance();
		System.out.println(this.name+" your total amount is "+ amountTotal);
		return this;	
	}
	public BankAccount chekingDeposit(double money) {
		setTotalMoney(getTotalMoney() + money);
		double amount = this.getCheckingBalance();
		double newAmount = amount += money;
		this.setCheckingBalance(newAmount);
		return this;
		
	}
	public BankAccount savingDeposit(double money) {
		setTotalMoney(getTotalMoney() + money);
		double amount = this.getSavingBalance();
		double newAmount = amount += money;
		this.setSavingBalance(newAmount);
		return this;
		
	}
	public BankAccount savingWithdraw(double money) {
		double amount = this.getSavingBalance();
		if(money<=amount) {
			setTotalMoney(getTotalMoney() - money);
			double newAmount = amount -= money;
			this.setSavingBalance(newAmount);
			return this;
		}else {
			System.out.println("Sorry you can't Withdraw that much money, you only have: $"+amount+" On your account");
			return this;
		}
		
	}
	public BankAccount chekingWithdraw(double money) {
		double amount = this.getCheckingBalance();
		if(money<=amount) {
			setTotalMoney(getTotalMoney() - money);
			double newAmount = amount -= money;
			this.setCheckingBalance(newAmount);
			return this;
		}else {
			System.out.println("Sorry you can't Withdraw that much money, you only have: $"+amount+" On your account");
			return this;
		}
		
	}
	
	private String newAccountNum() {
		String number = "";
		for(int i =1;i<=5;i++) {
			Random r = new Random();
			int Low = 10;
			int High = 100;
			int Result = r.nextInt(High-Low) + Low;
			number += ""+Result;	
		}
		setAccountNumber(number);
		return number;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(Double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public Double getSavingBalance() {
		return savingBalance;
	}

	public void setSavingBalance(Double savingBalance) {
		this.savingBalance = savingBalance;
	}
	public static double getTotalMoney() {
		return totalMoney;
	}
	public static void setTotalMoney(double totalMoney) {
		BankAccount.totalMoney = totalMoney;
	}
	
	
	
	

}
