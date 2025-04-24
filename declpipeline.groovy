pipeline {
    agent  { label 'node1'}
    stages {
        stage('git checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Anilbamnote/student-ui-app.git'
                //
            }
        }
        stage('build') {
            steps {
                sh '/opt/maven/bin/mvn clean package'
                //
            }
        }
        stage('test') {
            steps {
            withSonarQubeEnv(installationName: 'sonar', credentialsId: 'sonar-cred') {
            sh '/opt/maven/bin/mvn sonar:sonar'
            }
            }
        }
        stage('quality gate') {
            steps {
                timeout(10) {
                
            }
              waitForQualityGate true
                
                
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
