properties([[$class: 'JiraProjectProperty'], parameters([ string(defaultValue: 'anypoint-username', description: '', name: 'USERNAME', trim: false), string(defaultValue: 'anypoint-password', description: '', name: 'PASSWORD', trim: false),string(defaultValue: 'DEV', description: '', name: 'ENV_VALUE', trim: false), string(defaultValue: 'D430', description: '', name: 'SERVER_NAME', trim: false)])])


pipeline {
  agent any
 
  stages {
    
    stage('Deploy Application') { 
	
	
	    
      steps {
	     
	      echo  "ENV_VALUE is ${ENV_VALUE}"
	      echo  "SERVER_NAME is ${SERVER_NAME}"
	      
        
		sh "/opt/jenkins/maven/apache-maven-3.5.0/bin/mvn clean deploy -DmuleDeploy -Dusername=${USERNAME} -Dpassword=${PASSWORD} -Denvironment=${ENV_VALUE} -Dtarget=${SERVER_NAME} -DtargetType=server -DskipMunitTests" 
		

 echo 'Deploying to ARM '
        
      }
    }
 
 
  }
}

