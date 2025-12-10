# Jenkins Shared Library

This repository contains reusable pipeline steps (vars/*) for CI/CD.

Usage:
- Configure this repo as a Global Pipeline Library in Jenkins (name: jenkins-shared-lib)
- In Jenkinsfile: @Library('jenkins-shared-lib') _
- Then call functions like: buildApp(), sonarScan('proj', 'org'), dockerBuild(image, tag), etc.
