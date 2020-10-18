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
        myMavenContainer.inside {
            sh 'sudo usermod -a -G docker $USER'
            sh "docker login -u ${params.dockerhub_id} -p ${params.dockerhub_password}"
            sh 'mvn docker:build -DpushImage'
        }
    }
}
