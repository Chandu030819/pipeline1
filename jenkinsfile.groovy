pipeline {
  
     agent any

     stages {

         stage("build") {
           steps {
            println "i will run this"

            stage("deploy") {
                steps {
                  println "i deploy code"  
                }
            }   
           }

         }
     }
}