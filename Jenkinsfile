pipeline {
  agent any
  stages {
    stage('Launch testrpc') {
      steps {
        parallel(
          "Launch testrpc": {
            sh '''#!/bin/bash

testrpc &

sleep 2s'''
            
          },
          "Test Smart Contracts": {
            sh '''cd ethereum

rm truffle.js
mv truffle-jenkins.js truffle.js

truffle test
'''
            
          },
          "Publish Test Results": {
            junit 'ethereum/test-results.xml'
            
          }
        )
      }
    }
  }
}