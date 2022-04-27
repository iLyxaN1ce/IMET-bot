pipeline {
    agent any

    environment {
        TOKEN = credentials('TOKEN')
        MONGO_PWD = credentials('MONGO_PWD')
    }
    
    stages {
        stage('Build') {
            steps {
                sh "make docker-build"
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker-compose down'
                sh 'make docker-compose-up'
            }
        }
    }
}
