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


More to come ...
