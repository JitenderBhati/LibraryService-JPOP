node {
    def githubUrl = "https://github.com/JitenderBhati/LibraryService-JPOP.git"
    env.JAVA_HOME="${tool 'JDK9'}"
    
    env.PATH="${env.JAVA_HOME}/bin:${env.PATH}"
    
    sh 'java -version'

    stage("Docker Compose Down") {
        sh label: '', script: 'docker-compose down'
    }

    stage("Clean Workspace") {
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

    stage("Build Microservices") {
    parallel configServer: {
        dir('config-server') {
            sh "pwd"
            stage("Compile") {
                sh label: '', script: 'mvn clean'
            }

            stage("Test") {
                sh label: '', script: 'mvn test'
            }

            stage('Build Artifact Stage') {
                sh label: '', script: 'mvn install -DskipTests'
            }

            stage("Copy Artiface to Deployment Location") {
                //sh 'cp -r target/* docker'
            }

            stage('build and push docker image') {
                docker.withRegistry('https://index.docker.io/v1/', '962701ce-6f98-4d63-a5ec-153d48b07431') {
                def customImage = docker.build("jkrajput24/jpop_config_server:v-${env.BUILD_ID}")
                /* Push the container to the custom Registry */
                customImage.push()
                }
            }
        }        
    }, eurekaServer: {
         dir('eurekaserver') {
             sh "pwd"
            stage("Compile") {
                sh label: '', script: 'mvn clean'
            }

            stage("Test") {
                sh label: '', script: 'mvn test'
            }

            stage('Build Artifact Stage') {
                sh label: '', script: 'mvn install -DskipTests'
            }

            stage('build and push docker image') {
                docker.withRegistry('https://index.docker.io/v1/', '962701ce-6f98-4d63-a5ec-153d48b07431') {
                def customImage = docker.build("jkrajput24/jpop_eureka_server:v-${env.BUILD_ID}")
                /* Push the container to the custom Registry */
                customImage.push()
                }
            }
        }
    }, authServer: {
         dir('authserver') {
            sh "pwd"
            stage("Compile") {
                sh label: '', script: 'mvn clean'
            }

            stage("Test") {
                sh label: '', script: 'mvn test'
            }

            stage('Build Artifact Stage') {
                sh label: '', script: 'mvn install -DskipTests'
            }

            stage('build and push docker image') {
                docker.withRegistry('https://index.docker.io/v1/', '962701ce-6f98-4d63-a5ec-153d48b07431') {
                def customImage = docker.build("jkrajput24/jpop_auth_server:v-${env.BUILD_ID}")
                /* Push the container to the custom Registry */
                customImage.push()
                }
            }
        }
    }, apiGateway: {
         dir('apigateway') {
            sh "pwd"
            stage("Compile") {
                sh label: '', script: 'mvn clean'
            }

            stage("Test") {
                sh label: '', script: 'mvn test'
            }

            stage('Build Artifact Stage') {
                sh label: '', script: 'mvn install -DskipTests'
            }

            stage('build and push docker image') {
                docker.withRegistry('https://index.docker.io/v1/', '962701ce-6f98-4d63-a5ec-153d48b07431') {
                def customImage = docker.build("jkrajput24/jpop_api_gateway:v-${env.BUILD_ID}")
                /* Push the container to the custom Registry */
                customImage.push()
                }
            }
        }
    }, bookService: {
         dir('Book Service') {
            sh "pwd"
            stage("Compile") {
                sh label: '', script: 'mvn clean'
            }

            stage("Test") {
                sh label: '', script: 'mvn test'
            }

            stage('Build Artifact Stage') {
                sh label: '', script: 'mvn install -DskipTests'
            }

            stage('build and push docker image') {
                docker.withRegistry('https://index.docker.io/v1/', '962701ce-6f98-4d63-a5ec-153d48b07431') {
                def customImage = docker.build("jkrajput24/jpop_book_service:v-${env.BUILD_ID}")
                /* Push the container to the custom Registry */
                customImage.push()
                }
            }
        }
    }, libraryService: {
         dir('library-service') {
            sh "pwd"
            stage("Compile") {
                sh label: '', script: 'mvn clean'
            }

            stage("Test") {
                sh label: '', script: 'mvn test'
            }

            stage('Build Artifact Stage') {
                sh label: '', script: 'mvn install -DskipTests'
            }

            stage('build and push docker image') {
                docker.withRegistry('https://index.docker.io/v1/', '962701ce-6f98-4d63-a5ec-153d48b07431') {
                def customImage = docker.build("jkrajput24/jpop_library_service:v-${env.BUILD_ID}")
                /* Push the container to the custom Registry */
                customImage.push()
                }
            }
        }
    }, userService: {
         dir('user_service') {
            sh "pwd"
            stage("Compile") {
                sh label: '', script: 'mvn compile'
            }

            stage("Test") {
                sh label: '', script: 'mvn test'
            }

            stage('Build Artifact Stage') {
                sh label: '', script: 'mvn install -DskipTests'
            }

            stage('build and push docker image') {
                docker.withRegistry('https://index.docker.io/v1/', '962701ce-6f98-4d63-a5ec-153d48b07431') {
                def customImage = docker.build("jkrajput24/jpop_user_service:v-${env.BUILD_ID}")
                /* Push the container to the custom Registry */
                customImage.push()
                }
            }
        }
    },
    failFast: true
    }

    stage("Docker Compose Up") {
        sh label: '', script: 'docker-compose up --build'
    }

    stage("Email Trigger") {
        emailext body: 'Hello Jenkins', 
        recipientProviders: [developers()], 
        subject: 'Testing Jenkins', 
        to: 'Jitender_Bhati@epam.com, jkrajput24@gmail.com'
    }    
}