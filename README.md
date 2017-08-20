# DevOps for Blockchain using Jenkins

This project is inspired by the work of [Redback and Microsoft teams for developing the process for DevOps using VSTS](https://microsoft.github.io/techcasestudies/redback-devops.html).

I've chosen to develop a similar DevOps process using Jenkins, Truffle and TestRPC so that we can give choices for our customers.

The project contains the components needed to build the build and test pipeline.

## Building Jenkins Server

The current version is based on a single instance of Jenkins running on Ubuntu 17.04.  The scripts can be adapted for other Linux distributions as needed.

The script to automate the deployment is located in the [jenkins folder](jenkins/master-install.sh).  Jenkins installation is split into 2 routines.  First, install the dev tools needed to compile and deploy Java and Node applications such as JDK, Node, npm, Git and Jenkins itself.

Followed by tools needed for running Ethereum locally on the Jenkins server.  Here, we'll be using [Truffle Framework](http://truffleframework.com/) for writing contracts, integration tests and running tests.  [testrpc](https://github.com/ethereumjs/testrpc) will provide an in-memory blockchain environment that's fast and predictable.

I've chosen to write the tests in [Mocha](https://mochajs.org/) as it's a versatile framework that can be used not just for Smart Contracts, but for integration testing across the entire application stack allowing the developers to learn less and do more.  The results are written into XML using the Mocha JUnit Reporter.  The XML results can then be pulled into Jenkins as part of the build report.

### Install Dev Tools

```bash
apt-get install -y default-jdk
apt-get install -y git

wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo apt-key add -
echo deb http://pkg.jenkins.io/debian-stable binary/ | sudo tee /etc/apt/sources.list.d/jenkins.list
apt-get update
apt-get install -y jenkins

apt-get install -y python-software-properties
curl -sL https://deb.nodesource.com/setup_7.x | sudo -E bash -

apt-get install -y nodejs
apt-get install -y npm
```

### Install Ethereum Tools

```bash
npm install -g ethereumjs-testrpc
npm install -g solc
npm install -g truffle
npm install -g mocha
npm install -g mocha-junit-reporter
```

## Using Truffle Framework

An example Smart Contract and it's corresponding integration tests are located in the (ethereum folder)[ethereum].

### To initialize a new project

```bash

cd <project directory>
truffle init

```

You should now have a few directories & files:

* contracts/ - stores all Smart Contracts
* tests/ - stores all test cases
* truffle.js - truffle configuration file

The Smart Contracts are written in (Solidity)[http://solidity.readthedocs.io/en/develop/introduction-to-smart-contracts.html] and will store the files with *.sol* extension.  There are example test cases written in Solidity (*.sol* extension) and Mocha (*.js* extension).  The choice of the language is up to you.

### Executing Integration Tests

You can run the integration tests against your own new project or the example Smart Contract(s) located in this project.

```bash

cd <project directory>

# Start testrpc in the background and save the pid.  You can set this up on another terminal as well.
testrpc &
echo $! >> testrpc.pid

# Run the tests
truffle test

# Stop testrpc
kill -9 `cat testrpc.pid`

```

### Exporting Integration Test Results

You can export the integration tests into multiple formats.  For our scenario, I'm using JUnit Reporter so that it can be read by Jenkins.  The configuration is located in *truffle-jenkins.js*.  To use this version, rename truffle-jenkins.js to *truffle.js*.


More to come ...
