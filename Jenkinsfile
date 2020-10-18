node {
    def myMavenContainer = docker.image('bhhan87/maven:jdk8-alpine')
    myMavenContainer.pull()
    stage('prepare'){
        checkout scm
    }

    stage('test and package'){
        myMavenContainer.inside("-v ${env.HOME}/.m2:/.m2"){
            sh 'mvn clean package'
        }
    }
}
