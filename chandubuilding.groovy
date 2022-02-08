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
         }  
       }  
       stage("deploy"){
          steps {
          println "i deploy code"

          } 
       }
   }  
 }