#!/usr/bin/env groovy
def gv

pipeline {
    agent any

    tools {
        nodejs 'nodejs.20'
    }

    stages {

        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }

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
                    gv.buildImage (nodesampleapp, 2)
                }
            }
        }
    }
}
