pipeline {
  agent any
  tools {
    maven 'Maven 3.5.2'
    jdk 'JDK 1.8'
  }
  stages {
    stage('Build') {
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
    stage('Deploy to Dev') {
      steps {
        build job: 'backend-deploy-to-dev'
      }
    }
    stage ('Deploy to Production') {
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
