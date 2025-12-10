def call(String image) {

    echo "Running Trivy scan on image: ${image}"

    sh """
        trivy image ${image} \
            --severity HIGH,CRITICAL \
            --exit-code 1 \
            --no-progress
    """
}
