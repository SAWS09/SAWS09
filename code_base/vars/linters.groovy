#!/usr/bin/env groovy

def call(String COMPONENT_NAME){

    script {
        sh (script: 'pre-commit install')
        sh (script: 'pre-commit run --all-files')
    }

}
