pipeline {
  agent any
  stages {
    stage('Clone') {
      steps {
        sh 'git pull . master'
      }
    }
    stage('Unit test') {
      steps {
        sh 'mvn surefire-report:report'
      }
    }
    stage('Integration Test') {
      steps {
        sh 'mvn verify -P IT-test'
      }
    }
    stage('SonarCube') {
      steps {
        withSonarQubeEnv('SonarQubeServer') {
          sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
        }

      }
    }
    stage('Sonar response') {
      steps {
        waitForQualityGate true
      }
    }
    stage('Build') {
      steps {
        archiveArtifacts(artifacts: 'target/*.war', fingerprint: true)
        sh 'cp target/*.war /var/jenkins_home/app/inventarioLibreria.war'
      }
    }
  }
}