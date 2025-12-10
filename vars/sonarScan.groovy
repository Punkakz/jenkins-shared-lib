// sonarScan(projectKey, organization)
def call(String projectKey, String organization) {
    stage('SonarCloud Analysis') {
        withSonarQubeEnv('SonarCloud') {
            sh """
               mvn -B sonar:sonar \
               -Dsonar.projectKey=${projectKey} \
               -Dsonar.organization=${organization} \
               -Dsonar.host.url=https://sonarcloud.io \
               -Dsonar.login=${SONAR_TOKEN}
            """
        }
    }
}
