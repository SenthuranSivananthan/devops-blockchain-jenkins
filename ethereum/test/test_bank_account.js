var BankAccount = artifacts.require("../contracts/BankAccount");

contract('BankAccount', function(accounts) {
  it("Validate account deposit", function() {
    var bank;
    var amount = 100;
    var account = accounts[0];

    return BankAccount.deployed().then(function(instance) {
      bank = instance;
      bank.deposit(amount, {from: account});
    }).then(function() {
      return bank.balanceOf.call(account);
    }).then(function(balance) {
      assert.equal(balance.valueOf(), amount, "Expecting " + amount + " as the balance for account.");      
    });

    done();
  });

  it("Validate account can't withdraw more than balance", function() {
    var bank;
    var account = accounts[0];
    var depositAmount = 50;
    var withdrawalAmount  = 100;

    return BankAccount.deployed().then(function(instance) {
      bank = instance;
      bank.deposit(depositAmount, {from: account});
    }).then(function() {
      return bank.withdraw(withdrawalAmount, {from: account});
    }).then(function(){
      return bank.balanceOf.call(account);
    }).then(function(balance) {
      assert.equal(balance.valueOf(), depositAmount, "Expecting " + depositAmount + " in the account.");
    });

    done();
  });
});