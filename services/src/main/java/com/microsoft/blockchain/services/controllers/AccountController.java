package com.microsoft.blockchain.services.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microsoft.blockchain.services.models.Account;
import com.microsoft.blockchain.services.models.FundTransferStatus;

/**
 * Account controller that will provide account details for customers.
 *
 */
@RestController
@RequestMapping("/api")
public class AccountController {
	@RequestMapping("/account")
	public Account getAccount(@RequestParam("id") String address) {
		return new Account(address, "Senthuran", 1000);
	}
	
	@RequestMapping(method = RequestMethod.POST, path="/account/{sourceAddress}/transfer/{destinationAddress}/{amount}")
	public FundTransferStatus transferFunds(@PathVariable("sourceAddress") String sourceAddress, @PathVariable("destinationAddress") String destinationAddress, @PathVariable("amount") double amount)
	{
		return new FundTransferStatus(sourceAddress, destinationAddress, amount, true);
	}
}
