node {
   def mvnHome
   stage('Preparation') { 
      // Get some code from a GitHub repository
      git 'https://github.com/java2786/jenkins_demo.git'
      mvnHome = tool 'mvn_3'
   }
   stage('Build') {
      // Run the maven build
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean/)
   }
   stage('Compile'){
       bat label: '', script: 'mvn compile'
   }
   stage('test'){
       bat label: '', script: 'mvn test'
   }
}