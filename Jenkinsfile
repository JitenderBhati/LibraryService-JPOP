node {
    def githubUrl = "https://github.com/JitenderBhati/LibraryService-JPOP.git"
    env.JAVA_HOME="${tool 'JDK9'}"
    
    env.PATH="${env.JAVA_HOME}/bin:${env.PATH}"
    
    sh 'java -version'

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

    parallel configServer: {
        sh label: '', script: 'cd config-server'
            stage("Compile") {
                sh label: '', script: 'mvn clean'
            }

            stage("Test") {
                sh label: '', script: 'mvn test'
            }

            stage('Build Artifact Stage') {
                sh label: '', script: 'mvn install -DskipTests'
            }
        
    }, eurekaServer: {
        sh label: '', script: 'cd eurekaserver'
            stage("Compile") {
                sh label: '', script: 'mvn clean'
            }

            stage("Test") {
                sh label: '', script: 'mvn test'
            }

            stage('Build Artifact Stage') {
                sh label: '', script: 'mvn install -DskipTests'
            }
    },
    failFast: true
}