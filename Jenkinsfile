node {
    def mvnHome

    stage('Preparation') {
        mvnHome = tool 'M3'
    }
    stage('Checkout') {
        checkout scm
    }
    stage('test and package'){
        sh 'mvn clean package'
    }    
    stage('docker build and push'){
        sh 'mvn clean'
    }
}
