pipeline {
  agent any
  tools {
    maven 'Maven 3.5.2'
    jdk 'JDK 1.8'
  }
  stages {
    stage('Init') {
      steps {
        echo "Testing..."
      }
    }
    stage('Build') {
      steps {
        echo "Building..."
        withMaven(
          maven: 'M3',
          mavenSettingsConfig: 'my-maven-settings',
          mavenLocalRepo: '.repository')
        {
          sh 'mvn clean package'
        }
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
