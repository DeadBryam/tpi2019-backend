node{
stage("Clone :v"){
    git "https://github.com/DeadBryam/TPI2k19.git"
}
stage("Unit test"){
    sh "mvn surefire-report:report"
}
stage("Sonarquibo"){
    withSonarQubeEnv('SonarQubeServer') {
      sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
    }
}
}