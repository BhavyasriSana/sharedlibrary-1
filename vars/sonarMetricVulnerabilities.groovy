def call(){
withCredentials([usernamePassword(credentialsId: 'sonar_cred', passwordVariable: 'password', usernameVariable: 'username')]){
  sh "curl -u ${username}:${password} -X GET 'http://ec2-3-133-107-212.us-east-2.compute.amazonaws.com:9000/api/measures/component?component=BMIBeta&metricKeys=vulnerabilities'"
  echo 'vulnerabilities displayed'
  sh "curl -u ${username}:${password} -X GET 'http://ec2-3-133-107-212.us-east-2.compute.amazonaws.com:9000/api/measures/component?component=BMIBeta&metricKeys=coverage'"
  echo 'code coverage displayed'
  sh "curl -u ${username}:${password} -X GET 'http://ec2-3-133-107-212.us-east-2.compute.amazonaws.com:9000/api/measures/component?component=BMIBeta&metricKeys=bugs'"
  echo 'bugs displayed'
  sh "curl -u ${username}:${password} -X GET 'http://ec2-3-133-107-212.us-east-2.compute.amazonaws.com:9000/api/measures/component?component=BMIBeta&metricKeys=violations'"
  echo 'violations displayed'
  sh "curl -u ${username}:${password} -X GET 'http://ec2-3-133-107-212.us-east-2.compute.amazonaws.com:9000/api/measures/component?component=BMIBeta&metricKeys=complexity'"
  echo 'complexity displayed'
}
}
