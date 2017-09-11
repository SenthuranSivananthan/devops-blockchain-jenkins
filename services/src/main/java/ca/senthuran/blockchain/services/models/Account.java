package ca.senthuran.blockchain.services.models;

public class Account {
	private String address;
	private String name;
	private double balance;

	public Account(String address, String name, double balance)
	{
		this.address = address;
		this.name = name;
		this.balance = balance;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
