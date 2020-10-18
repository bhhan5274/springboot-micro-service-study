node {
    def mvnHome

    stage('Preparation') {
        mvnHome = tool 'M3'
    }
    stage('Checkout') {
        checkout scm
    }
    stage('test and package'){
        sh "'${mvnHome}/bin/mvn' clean package"
    }    
    stage('docker build and push'){
        sh "'${mvnHome}/bin/mvn' clean"
    }
}
