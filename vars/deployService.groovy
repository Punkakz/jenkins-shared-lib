def call(String serverIp, String deployPath) {
    sshagent(credentials: ['ec2-ssh']) {
        sh """
            ssh -o StrictHostKeyChecking=no ubuntu@${serverIp} \
            "cd ${deployPath} && docker compose pull && docker compose up -d"
        """
    }
}
