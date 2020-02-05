import groovy.json.*

@NonCPS
create(){
def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/sonar/QualityGateDetails.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
def GateId = resultJson.id

	sh "curl --location --request POST 'http://3.16.33.107:9000/api/projects/delete?key=${GateId}' \
--header 'Authorization: Basic YWRtaW46YWRtaW4='"
}
def call(){
create()
}
