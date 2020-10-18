node {
    def mvnHome

    stage('Preparation') {
        mvnHome = tool 'M3'
    }
    stage('Checkout') {
        checkout scm
    }
    
    try{
        stage('test and package'){
            sh "'${mvnHome}/bin/mvn' clean package"
        }    
        stage('docker build and push'){
            sh "docker login -u ${params.dockerhub_id} -p ${params.dockerhub_password}"
            sh "'${mvnHome}/bin/mvn' docker:build -DpushImage"
        }
        stage('send success email'){
            currentBuild.result = "SUCCESS";    
        }
    }catch(e){
        currentBuild.result = "FAILURE";  
    }finally{
        def subject = "${env.JOB_NAME} - Build #${env.BUILD_NUMBER} ${currentBuild.result}"
        def content = '${JELLY_SCRIPT,template="html"}'
          
        emailext(body: content, mimeType: 'text/html',
             replyTo: '$DEFAULT_REPLYTO', subject: subject,
                   to: "${params.notification_email}", attachLog: true )        
    }
}
