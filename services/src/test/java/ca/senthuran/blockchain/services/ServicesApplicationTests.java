package ca.senthuran.blockchain.services;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.Contract;

import ca.senthuran.blockchain.smartcontracts.wrapper.BankAccount;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServicesApplicationTests {
	static final BigInteger GAS_PRICE = Contract.GAS_PRICE;
	static final BigInteger GAS_LIMIT = Contract.GAS_LIMIT;

	private Web3j web3j = null;
	private ClientTransactionManager txManager = null;

	private BankAccount bankAccountContract = null;

	private String mainAccountAddress = null;

	@Before
	public void before() throws IOException, InterruptedException, ExecutionException {
		web3j = Web3j.build(new HttpService());

		EthAccounts accounts = web3j.ethAccounts().send();
		Assert.assertNotEquals(0, accounts.getAccounts().size());

		// use the first account as the main account for the tests
		mainAccountAddress = accounts.getAccounts().get(0);

		// deploy the contract
		txManager = new ClientTransactionManager(web3j, mainAccountAddress);
		bankAccountContract = BankAccount.deploy(web3j, txManager, GAS_PRICE, GAS_LIMIT, BigInteger.valueOf(0))
				.get();
	}

	@Test
	public void testAccountDeposit() throws Exception {
		bankAccountContract.deposit(new Address(mainAccountAddress), new Uint256(100));
		Assert.assertEquals(100,
				bankAccountContract.balanceOf(new Address(mainAccountAddress)).get().getValue().intValue());
	}
}
