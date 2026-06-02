pipeline {
    agent any

    stages {

        stage('Clone') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/MohamedAngar/studentManager.git'
            }
        }

        stage('Clean') {
            steps {
                sh 'mvn clean'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar'
            }
        }
    }

    post {

        success {
            mail to: 'medangar2015@gmail.com',
                 subject: "SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: """
The build completed successfully.

Job: ${env.JOB_NAME}
Build Number: ${env.BUILD_NUMBER}

Check Jenkins for details.
"""
        }

        failure {
            mail to: 'medangar2015@gmail.com',
                 subject: "FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: """
The build failed.

Job: ${env.JOB_NAME}
Build Number: ${env.BUILD_NUMBER}

Please check the Jenkins console output.
"""
        }
    }
}