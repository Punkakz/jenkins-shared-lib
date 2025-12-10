def call(String serverIp, String remotePath) {

    sh """
        echo 'Deploying to EC2: ${serverIp}'

        # Copy docker-compose file
        scp -o StrictHostKeyChecking=no deploy/docker-compose.yml ubuntu@${serverIp}:${remotePath}/docker-compose.yml

        # Run Docker Compose on EC2
        ssh -o StrictHostKeyChecking=no ubuntu@${serverIp} "
            cd ${remotePath}
            docker compose pull
            docker compose up -d --remove-orphans
        "
    """
}
