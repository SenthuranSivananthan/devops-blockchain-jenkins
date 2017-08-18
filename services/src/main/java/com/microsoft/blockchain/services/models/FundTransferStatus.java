package com.microsoft.blockchain.services.models;

public class FundTransferStatus {
	private String sourceAddress;
	private String destinationAddress;
	private double amount;
	private boolean transferSuccessful;

	public FundTransferStatus(String sourceAddress, String destinationAddress, double amount,
			boolean transferSuccessful) {
		super();
		this.sourceAddress = sourceAddress;
		this.destinationAddress = destinationAddress;
		this.amount = amount;
		this.transferSuccessful = transferSuccessful;
	}

	public String getSourceAddress() {
		return sourceAddress;
	}

	public void setSourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isTransferSuccessful() {
		return transferSuccessful;
	}

	public void setTransferSuccessful(boolean transferSuccessful) {
		this.transferSuccessful = transferSuccessful;
	}
}
