pipeline {
  agent any

  tools {
    maven 'Maven 3.5.2'
    jdk 'JDK 1.8'
  }

  triggers {
    pollSCM('* * * * *')
  }

  stages {
    stage('Build') {
      parallel {
        stage('Package') {
          steps {
            echo "Building..."
            sh 'mvn clean package'
          }
          post {
            success {
              echo "Now archiving..."
              archiveArtifacts artifacts: '**/target/*.war'
            }
          }
        }
        stage('Static Analysis') {
          steps {
            build job: 'backend-code-analysis'
          }
        }
      }
    }

    stage('Deploy to Dev') {
      steps {
        build job: 'backend-deploy-to-dev'
      }
    }

    stage ('Deploy to Pro') {
      steps{
        timeout(time:10, unit:'MINUTES') {
          input message:'Approve PRODUCTION Deployment?'
        }
        build job: 'backend-deploy-to-pro'
      }
      post {
        success {
          echo 'Code deployed to Production.'
        }
        failure {
          echo ' Deployment failed.'
        }
      }
    }
  }
}
