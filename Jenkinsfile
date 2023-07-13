pipeline {
    agent any

    tools {
        nodejs 'node.20'
    }

    stages {
        stage('build') {
            steps {
                sh '''
                npm install
                '''
            }
        }
        
        stage("build image") {
            steps {
                script {
                    echo 'building the docker image...'
                    withCredentials ([usernamePassword(credentialsId:'6ec9d130-1d94-42af-9cf5-26ab651d58da', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh ''' 
                        docker build . -t kryssperer/sample-nodeapp:1.0
                        echo $PASS | docker login -u $USER --password-stdin
                        docker push kryssperer/sample-nodeapp:1.0
                        '''
                    }
                }
            }
        }
    }
}
