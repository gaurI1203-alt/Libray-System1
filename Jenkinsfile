pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Build') {
            steps {
                dir('Libray-System1') {
                    bat 'mvn clean compile'
                }
            }
        }

        stage('Test') {
            steps {
                dir('Libray-System1') {
                    bat 'mvn test'
                }
            }
        }

        stage('Package') {
            steps {
                dir('Libray-System1') {
                    bat 'mvn package'
                }
            }
        }
    }
}