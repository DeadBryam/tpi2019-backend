node{
stage("Clone"){
    git "https://github.com/DeadBryam/TPI2k19.git"
}
stage("Unit test"){
    sh "mvn surefire-report:report"
}
stage("Sonarquiub"){
    withSonarQubeEnv('SonarQubeServer') {
      sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
    }
}
stage("Sonarquib rispons"){
    def qg = waitForQualityGate()
    if (qg.status != 'OK') {
        error "El pipe fue abortado por un error de SonarQUbe ${qg.status}"
    }
}
}