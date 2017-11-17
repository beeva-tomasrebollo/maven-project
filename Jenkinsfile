pipeline {
  agent any
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
          archiveArtifacts artifacts: '**/*.war'
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
