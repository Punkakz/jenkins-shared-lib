// dockerPush(image, tag, credId)
def call(String image, String tag, String credId) {
    stage('Docker Push') {
        docker.withRegistry('https://registry.hub.docker.com', credId) {
            sh """
               docker push ${image}:${tag}
               docker tag ${image}:${tag} ${image}:latest
               docker push ${image}:latest
            """
        }
    }
}
