// trivyScan(image)
def call(String image) {
    stage('Trivy Scan') {
        sh """
           set -o pipefail
           trivy image --severity CRITICAL,HIGH ${image} || true
        """
    }
}
