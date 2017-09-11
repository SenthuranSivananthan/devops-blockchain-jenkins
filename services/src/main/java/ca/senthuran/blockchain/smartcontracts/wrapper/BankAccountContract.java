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
public final class BankAccountContract extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b5b60008054600160a060020a03191633600160a060020a03161790555b5b6101e48061003c6000396000f300606060405263ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416632e1a7d4d811461005e57806370a08231146100885780638da5cb5b146100b9578063b6b55f25146100e8575b600080fd5b341561006957600080fd5b610074600435610112565b604051901515815260200160405180910390f35b341561009357600080fd5b6100a7600160a060020a0360043516610163565b60405190815260200160405180910390f35b34156100c457600080fd5b6100cc610182565b604051600160a060020a03909116815260200160405180910390f35b34156100f357600080fd5b610074600435610191565b604051901515815260200160405180910390f35b600160a060020a03331660009081526001602052604081205482901061015a5750600160a060020a03331660009081526001602081905260409091208054839003905561015e565b5060005b919050565b600160a060020a0381166000908152600160205260409020545b919050565b600054600160a060020a031681565b600160a060020a03331660009081526001602081905260409091208054830190555b9190505600a165627a7a72305820713b83caf200b419b3ca048b53671326a519cf43c26c1df42c8db9e8cc18628b0029";

    private BankAccountContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private BankAccountContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public Future<TransactionReceipt> withdraw(Uint256 amount) {
        Function function = new Function("withdraw", Arrays.<Type>asList(amount), Collections.<TypeReference<?>>emptyList());
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

    public Future<TransactionReceipt> deposit(Uint256 amount) {
        Function function = new Function("deposit", Arrays.<Type>asList(amount), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public static Future<BankAccountContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(BankAccountContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Future<BankAccountContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(BankAccountContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static BankAccountContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BankAccountContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static BankAccountContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BankAccountContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
