pipeline {
    agent any 
        stages{
            stage("clone"){
                steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'git-auth', url: 'https://github.com/Chandu030819/pvtrepo03.git']]])
                sh "ls -lart ./*"    
                println "hera download"
                }
            }

            stage("build"){
                steps{
                    println "here build"
                    sh "mvn clean package"
                }
            }
            stage("upload"){
                steps{
                    println "upload artifacts"
                    sh "aws s3 cp target/hello-*.war s3://devops09art2"
                }
            }
            stage("deploy"){
                steps{
                    println "deploy code"
                }
            }
        }
    
}
