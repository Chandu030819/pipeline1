 //declarative pipeline
  pipeline {
     agent any
     parameters {
       // Define string parameter.
        string (
            name: 'jobName',
            defaultValue: 'buildpipeline',
            description: 'Insert commit id or leave as default to use head'
        )
       string (
            name: 'serverIP',
            defaultValue: '',
            description: 'Insert commit id or leave as default to use head'
        )   
        string (
            name: 'buildNumber',
            defaultValue: '',
            description: 'Insert commit id or leave as default to use head'
        )   
        string (
            name: 'sourceBranch',
            defaultValue: '',
            description: 'Insert commit id or leave as default to use head'
        )   
     }
     stages {
      stage("deploy"){
        steps {
       sh """aws s3 cp s3://devops09art2/${jobName}/${sourceBranch}/${buildNumber}/hello-${buildNumber}.war .
       ls -la
       la-la/tmp/
       scp -oStrictHostKeyChecking=no -i /tmp/chandu09.pem hello-${buildNumber}.war ec2-user@${serverIP}:/var/lib/tomcat/webapps"""     
        }  
      }   
     }

  }