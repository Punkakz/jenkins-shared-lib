// dockerBuild(image, tag)
def call(String image, String tag) {
    stage('Docker Build') {
        sh "docker build -t ${image}:${tag} ."
    }
}
