pipeline {
    agent { label 'node1' }
    stages {
        stage('git checkout') {
            steps {
                git branch: 'develop', url: 'https://github.com/cloud-blitz/angular-java.git'
                //
            }
        }
        stage('build') {
            steps {
                echo "build"
                //
            }
        }
        stage('test') {
            steps {
                echo "test"
                //
            }
        }    
        stage('deploy') {
            steps {
                echo "deploy"
                //
            }
        }
    }
}
