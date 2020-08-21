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
                def customImage = docker.build("jkrajput24/jpop_library_service:v${env.BUILD_ID}")
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
        sh label: '', script: 'docker-compose up -d'
    }

    stage("Email Trigger") {
        emailext body: "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><style>table {margin: 0 auto;width: 90%;font-size: 20px;font-family: sans-serif;border-spacing: 5px;}table tr td:nth-child(odd) {font-weight: bold;}table tr td:nth-child(even) {text-align: right;}th,td {border-bottom: 1px solid #ddd;padding: 10px 15px;}th {background-color: rgb(118, 205, 216);color: white;padding: 10px;}</style></head><body><table><tr><th colspan=\"2\">Project - Library Service Portal | Status Report</th></tr><tr><td>Status</td><td>${currentBuild.currentResult}</td></tr><tr><td>JOB</td><td> ${env.JOB_NAME}</td></tr><tr><td>Date</td><td>${BUILD_TIMESTAMP}</td></tr><tr><td>Duration</td><td>${currentBuild.durationString}</td></tr><tr><td>Cause</td><td>started by admin</td></tr></table></body></html>",
        attachLog: true,
        subject: "JPOP Library Service Portal -Build #${BUILD_NUMBER} - ${currentBuild.currentResult}",                                                           
        mimeType: 'text/html',
        to: 'Jitender_Bhati@epam.com, jkrajput24@gmail.com'
    }    
}