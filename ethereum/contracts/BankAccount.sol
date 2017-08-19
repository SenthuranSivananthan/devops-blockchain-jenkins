pragma solidity ^0.4.4;

contract BankAccount {
    // The Bank
    address public owner;

    // Balances for each account
    mapping(address => uint256) balances;

    // Contructor - called when the contract is added the chain
    function BankAccount() public {
        owner = msg.sender;
    }

    function deposit(uint256 amount) returns (bool success) {
        balances[msg.sender] += amount;
        return true;
    }

    function withdraw(uint256 amount) returns (bool success) {
        if (balances[msg.sender] - amount > 0) {
            balances[msg.sender] -= amount;
            return true;
        }

        return false;
    }

    function balanceOf(address accountHolder) constant returns (uint256 balance) {
        return balances[accountHolder];
    }
}
