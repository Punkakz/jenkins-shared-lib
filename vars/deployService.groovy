def call(String deployPath) {

    stage("Deploy Application") {

        sh """
            echo "🚀 Deploying locally on Jenkins/EC2..."

            cd ${deployPath}

            # Stop old containers (if running)
            docker compose down || true

            # Pull latest image from Docker Hub
            docker compose pull

            # Start updated containers
            docker compose up -d --remove-orphans

            echo "✅ Deployment finished successfully!"
        """
    }
}
