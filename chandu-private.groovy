pipeline {
    agent any 
        stages{
            stage("clone"){
                steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'git-auth', url: 'https://github.com/Chandu030819/pipeline1.git']]])
                sh "ls -lart ./*"    
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
