// deployService(serverIp, remotePath)
def call(String serverIp, String remotePath = '/home/ubuntu/deploy/snake-game') {
    stage('Deploy to EC2') {
        // Assumes Jenkins has SSH access to ubuntu@serverIp (key in credentials or agent ssh key)
        sh """
          scp -o StrictHostKeyChecking=no deploy/docker-compose.yml ubuntu@${serverIp}:${remotePath}/docker-compose.yml
          ssh -o StrictHostKeyChecking=no ubuntu@${serverIp} '
             cd ${remotePath} &&
             docker compose pull &&
             docker compose up -d --remove-orphans
          '
        """
    }
}
