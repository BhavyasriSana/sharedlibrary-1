import groovy.json.JsonSlurper 

@NonCPS
createRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def ProjectKey = resultJson.pkey
def ProjectName = resultJson.pname
def QualityGateName = resultJson.qname
def credentials = resultJson.cname
	sh "curl --location --request POST 'http://ec2-3-16-33-107.us-east-2.compute.amazonaws.com:9000/api/projects/create?key=${ProjectKey}&name=${ProjectName}' \
--header 'Authorization: Basic YWRtaW46YWRtaW4='"
}
	def call(JSON){
createRepo(JSON)
}
