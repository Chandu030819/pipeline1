 pipeline {
   agent any
   stages {
    stage("hello world"){
      steps {
      println "welcome jenkins world"

      }  
    } 
      stage("build"){
       steps {
      sh """mvn clean package
            whoami
            pwd
            ls -l """     
       }   
      }
       stage("upload"){
         steps {
         println "i upload artifacts" 
          sh "aws s3 cp target/hello-*.war s3://devops09art2"

         }  
       }  
       stage("deploy"){
          steps {
          println "i deploy code"

          } 
       }
   }  
 }