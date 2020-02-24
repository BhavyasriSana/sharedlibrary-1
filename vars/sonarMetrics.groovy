def call(){
withCredentials([usernamePassword(credentialsId: 'sonar_cred', passwordVariable: 'password', usernameVariable: 'username')]){
  /*"""curl -0 -v -u ${username}:${password} -X GET http://ec2-3-133-107-212.us-east-2.compute.amazonaws.com:9000/api/measures/component?component=BMIBeta&metricKeys=coverage,vulnerabilities,bugs,violations,complexity \
  -H "Expect:" \
  -H 'Content-Type: text/json; charset=utf-8' \
  -d @myfile.json"""*/
  sh "curl -u ${username}:${password} -X GET 'http://ec2-3-133-107-212.us-east-2.compute.amazonaws.com:9000/api/measures/component?component=BMIBeta&metricKeys=coverage,vulnerabilities,bugs,violations,complexity' -o metrics.json | jq '.'"
  echo 'metrics collected'
}
}
