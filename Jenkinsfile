pipeline {
  agent any
  tools {
    maven 'Maven 3.5.2'
    jdk 'JDK 1.8'
  }
  stages {
    stage ('Initialize') {
      steps {
        sh '''
          echo "PATH = ${PATH}"
          echo "M2_HOME = ${M2_HOME}"
        '''
      }
    }
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
    stage('Deploy') {
      steps {
        echo "Code deployed."
      }
    }
  }
}
