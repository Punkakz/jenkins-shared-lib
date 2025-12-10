// Build the Maven project and publish test results
def call() {
    stage('Build & Test') {
        sh "mvn -B -DskipTests=false clean package"
    }
    stage('Publish Tests') {
        junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
    }
}
