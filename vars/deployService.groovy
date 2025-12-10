def call(String deployPath) {

    stage("Deploy Application") {
        sh """
            echo "Deploying locally on the same EC2..."

            cd ${deployPath}

            docker compose down || true
            docker compose pull
            docker compose up -d --remove-orphans
        """
    }
}
