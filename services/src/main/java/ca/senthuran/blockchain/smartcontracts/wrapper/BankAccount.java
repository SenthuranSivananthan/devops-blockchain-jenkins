package ca.senthuran.blockchain.smartcontracts.wrapper;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Future;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>, or {@link org.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version 2.3.1.
 */
public final class BankAccount extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b5b60008054600160a060020a03191633600160a060020a03161790555b5b6101fe8061003c6000396000f300606060405263ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166347e7ef24811461005e57806370a08231146100945780638da5cb5b146100c5578063f3fef3a3146100f4575b600080fd5b341561006957600080fd5b610080600160a060020a036004351660243561012a565b604051901515815260200160405180910390f35b341561009f57600080fd5b6100b3600160a060020a0360043516610152565b60405190815260200160405180910390f35b34156100d057600080fd5b6100d8610171565b604051600160a060020a03909116815260200160405180910390f35b34156100ff57600080fd5b610080600160a060020a0360043516602435610180565b604051901515815260200160405180910390f35b600160a060020a03821660009081526001602081905260409091208054830190555b92915050565b600160a060020a0381166000908152600160205260409020545b919050565b600054600160a060020a031681565b600160a060020a0382166000908152600160205260408120548290106101c85750600160a060020a03821660009081526001602081905260409091208054839003905561014c565b5060005b929150505600a165627a7a7230582059063fa5dd3cd52ddbb1977e6181cbe1ed6c224f13f6709a6ec8727fbdbfcf460029";

    private BankAccount(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private BankAccount(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public Future<TransactionReceipt> deposit(Address accountHolder, Uint256 amount) {
        Function function = new Function("deposit", Arrays.<Type>asList(accountHolder, amount), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Uint256> balanceOf(Address accountHolder) {
        Function function = new Function("balanceOf", 
                Arrays.<Type>asList(accountHolder), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Address> owner() {
        Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> withdraw(Address accountHolder, Uint256 amount) {
        Function function = new Function("withdraw", Arrays.<Type>asList(accountHolder, amount), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public static Future<BankAccount> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(BankAccount.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Future<BankAccount> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(BankAccount.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static BankAccount load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BankAccount(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static BankAccount load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BankAccount(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
