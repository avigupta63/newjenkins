pipeline {
    agent { label 'node1' }
    stages {
        stage('git checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Anilbamnote/student-ui-app.git'
                //
            }
        }
        stage('build') {
            steps {
                sh 'mvn clean package'
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
