node{
  stage('SCM Checkout'){
    git "https://github.com/lokeshprathapaneni/NPCLStudentsAssessments"
  }
  stage('Compile-Package'){
    sh 'mvn package'
  }
  
}
