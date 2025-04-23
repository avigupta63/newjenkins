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
                sh 'opt/maven/bin/mvn sonar:sonar -Dsonar.projectKey=studentapp -Dsonar.host.url=http://54.151.132.53:9000 -Dsonar.login=8c1e2f756c0df03d5d06af5776e175a38b7d07d1'
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
