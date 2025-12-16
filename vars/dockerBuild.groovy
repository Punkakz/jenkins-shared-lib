//def call(String image, String tag) {
  //  sh "docker build -t ${image}:${tag} ."
//}

def call(String image, String tag) {
    sh """
        docker build -t ${image}:${tag} .
        docker tag ${image}:${tag} ${image}:latest
    """
}

