// notify(status, message)
def call(String status, String message) {
    stage('Notify') {
        // Assumes Jenkins Email Extension or mail configured
        emailext(
            subject: "CI/CD: ${status} - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
            body: message,
            to: "your-email@example.com"
        )
    }
}
