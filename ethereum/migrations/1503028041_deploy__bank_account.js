var BankAccount = artifacts.require("./BankAccount.sol");

module.exports = function(deployer) {
  deployer.deploy(BankAccount);
};