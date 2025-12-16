// Build the Maven project and publish test results
//def call() {
  //  stage('Build & Test') {
    //    sh "mvn -B -DskipTests=false clean package"
 //   }
 //   stage('Publish Tests') {
    //    junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
  //  }
//}

def call() {
    stage('Build & Test') {
        sh "mvn -B clean package"
    }

    stage('Publish Tests') {
        junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
    }

    stage('Deploy') {
        sh '''
        echo "Stopping old Snake app..."
        pkill -f snake || true
        pkill -f java || true

        echo "Starting new Snake app..."
        nohup java -jar target/*.jar > snake.log 2>&1 &
        '''
    }
}
