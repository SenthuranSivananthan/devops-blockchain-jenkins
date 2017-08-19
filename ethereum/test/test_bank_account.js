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
      console.log(account);
      console.log(balance.valueOf());

      assert.equal(balance.valueOf(), amount, "Expecting " + amount + " as the balance for account.");      
    });

    done();
  });
});