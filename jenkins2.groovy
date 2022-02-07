pipeline {
    agent any
    stages {
         
      stage("build"){
          steps {
           println "i wil run this command"
           println "mvn package"

          }
      }   
    }         stage("deploy){
                steps {
                 println "i deploy code"

                 

                }


    }
}