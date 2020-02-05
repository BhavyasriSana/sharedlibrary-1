import groovy.json.JsonSlurper 

@NonCPS
createRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def GateId = resultJson.id

	sh "curl --location --request POST 'http://3.16.33.107:9000/api/qualitygates/create_condition?gateId=${GateId}&metric=blocker_violations&op=GT&warning=5&error=10' \
--header 'Authorization: Basic YWRtaW46YWRtaW4='"
}
	def call(){
def request = libraryResource 'QualityGateDetails.json'
createRepo(request)
}
