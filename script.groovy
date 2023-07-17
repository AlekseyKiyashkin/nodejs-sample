def buildImage(imagename, imageversion) {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: '6ec9d130-1d94-42af-9cf5-26ab651d58da', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            sh """
                docker build ./frontend -t kryssperer/$imagename:$imageversion
                echo $PASS | docker login -u $USER --password-stdin
                docker push kryssperer/imagename:$imageversion
            """
    }
} 
