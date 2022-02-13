pipeline {
    agent any 
    parameters {
        
        // Define string parameter.
        string (
            name: 'codebranch',
            defaultValue: '*/dev',
            description: 'Insert commit id or leave as default to use head'
        )
       
    }
    
             stages{
            stage("clone"){
                steps{
                checkout([$class: 'GitSCM', branches: [[name: "${codebranch}"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'git-auth', url: 'https://github.com/Chandu030819/pvtrepo03.git']]])
                sh """ls -lart ./*
                   echo ${env. JOB-NAME}
                   echo ${codebranch}
                   echo ${build-number} """  
                
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
                    sh "aws s3 cp target/hello-*.war s3://devops09art2/${env. JOB-NAME}/${codebranch}/${build-number}/"
                }
            }
            stage("deploy"){
                steps{
                    println "deploy code"
                }
            }
        }
    
}















       