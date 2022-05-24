node{
  stage('SCM Checkout'){
    git "https://github.com/lokeshprathapaneni/NPCLStudentsAssessments.git"
  }
  stage('Compile-Package'){
    sh 'mvn package'
  }
  
}
