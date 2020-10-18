node {
    def myMavenContainer = docker.image('bhhan87/maven:jdk8-alpine')
    myMavenContainer.pull()
    stage('prepare'){
        checkout scm
    }

    stage('test and package'){
        myMavenContainer.inside {
            sh 'mvn clean package'
        }
    }
    
    stage('docker build and push'){
        sh 'mvn clean'
    }
}
