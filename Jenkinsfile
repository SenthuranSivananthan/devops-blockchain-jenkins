pipeline {
  agent any
  stages {
    stage('Launch testrpc') {
      steps {
        sh '''#!/bin/bash

testrpc &
sleep 2s'''
      }
    }
    stage('Test Smart Contracts') {
      steps {
        sh '''#!/bin/bash

cd ethereum

rm truffle.js
mv truffle-jenkins.js truffle.js

truffle test

exit 0'''
      }
    }
    stage('Publish Test Results') {
      steps {
        junit(testResults: 'ethereum/test-results.xml', allowEmptyResults: true)
      }
    }
  }
}