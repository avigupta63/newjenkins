pipeline {
    agent {label 'node1'}
    stages {
        stage('Pull') {
            steps {
                git branch: 'main', url: 'https://github.com/avigupta63/Devops.git'
            }
        }
        stage('Test') {
            steps {
                sh ''' cd terraform/eks
                    terraform init
                    terraform plan'''
            }
        }
        stage('Deploy') {
            steps {
                sh ''' cd terraform/eks
                     terraform init
                    terraform apply --auto-approve'''
            }
        }
    }
}