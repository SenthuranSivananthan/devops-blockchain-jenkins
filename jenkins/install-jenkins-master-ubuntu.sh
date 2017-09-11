#!/bin/bash

update_system()
{
    apt-get update
}

install_dev_tools()
{
    apt-get install -y openjdk-8-jdk-headless
    apt-get install -y git
    
    wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo apt-key add -
    echo deb http://pkg.jenkins.io/debian-stable binary/ | sudo tee /etc/apt/sources.list.d/jenkins.list
    apt-get update
    apt-get install -y jenkins

    apt-get install -y python-software-properties
    curl -sL https://deb.nodesource.com/setup_7.x | sudo -E bash -

    apt-get install -y nodejs
    apt-get install -y npm
}

install_ethereum_tools()
{
    npm install -g ethereumjs-testrpc
    npm install -g solc
    npm install -g truffle
    npm install -g mocha
    npm install -g mocha-junit-reporter

    mkdir -p /opt/ethereum/web3j
    wget https://github.com/web3j/web3j/releases/download/v2.3.1/web3j-2.3.1.tar -O /tmp/web3j.tar
    tar -xf /tmp/web3j.tar --directory /opt/ethereum/web3j --strip-components=1
}

echo "Installing Tooling ..."
update_system
install_dev_tools
install_ethereum_tools
echo "Installation Complete."

echo "Starting Jenkins"
systemctl start jenkins