#!/usr/bin/env groovy
def call(String, component_name){
    pipeline{
        agent any
        options{
            timestamps()
        }
        environment {
            COMPONENT_NAME="${component_name}"
        }

        stages {
            stage('Cleanup Workspace') {
                steps {
                    cleanWs()
                    checkout scm
                }
            }

            stage('Run linters') {
                steps {
                    script{
                        linters "${COMPONENT_NAME}"
                    }
                }

            stage('Cleanup Workspace') {
                steps {
                    unit_testing "${COMPONENT_NAME}"
                }
            }
        }
    }

}
