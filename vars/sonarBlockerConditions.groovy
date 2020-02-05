import groovy.json.JsonSlurper 

@NonCPS
create(){
def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/sonar/QualityGateDetails.json"),"UTF-8"))
def resultJson = jsonSlurper.parseText(reader)
def GateId = resultJson.id

	sh "curl --location --request POST 'http://3.16.33.107:9000/api/qualitygates/create_condition?gateId=${GateId}&metric=blocker_violations&op=GT&warning=5&error=10' \
--header 'Authorization: Basic YWRtaW46YWRtaW4='"
}
def call(){
create()

}
