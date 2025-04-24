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
        stage('artifact') {
            steps {
                sh 'aws s3 cp target/studentapp.war s3://mywasbuket321'
                
            }
        }    
       //stage('deploy') {
          //  steps {
              //  deploy adapters: [tomcat9(credentialsId: 'tomcat', path: '', url: 'http://47.128.249.207:8080/')], contextPath: '/', war: '**/*.war'
                //
            }
        }

