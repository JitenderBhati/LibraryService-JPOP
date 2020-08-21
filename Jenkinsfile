node {
    def githubUrl = "https://github.com/JitenderBhati/LibraryService-JPOP.git"

    stage("clean workplace") {
        cleanWs()
    }

    stage("Code Checkout") {
        checkout([$class: 'GitSCM', 
                    branches: [[name: '*/master']], 
                    doGenerateSubmoduleConfigurations: false, 
                    extensions: [], 
                    submoduleCfg: [], 
                    userRemoteConfigs: [[url: 'https://github.com/JitenderBhati/LibraryService-JPOP.git']]
                    ])
    }

    parallel config-server: {
        dir('/config-server') {
            stage("Compile") {
                sh label: '', script: 'mvn clean'
            }

            stage("Test") {
                sh label: '', script: 'mvn test'
            }

            stage('Build Artifact Stage') {
                sh label: '', script: 'mvn install -DskipTests'
            }
        }
        
    }, eureka-server: {
         dir('/eurekaserver') {
            stage("Compile") {
                sh label: '', script: 'mvn clean'
            }

            stage("Test") {
                sh label: '', script: 'mvn test'
            }

            stage('Build Artifact Stage') {
                sh label: '', script: 'mvn install -DskipTests'
            }
        }
    },
    failFast: true
}