pipeline {
    agent any 
        stages{
            stage("clone"){
                steps{
                println "hera download"
                }
            }

            stage("build"){
                steps{
                    println "here build"
                }
            }
            stage("upload"){
                steps{
                    println "upload artifacts"
                }
            }
            stage("deploy"){
                steps{
                    println "deploy code"
                }
            }
        }
    
}
