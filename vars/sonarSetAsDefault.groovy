import groovy.json.*

@NonCPS
create(){
def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/QualityGateDetails.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
def GateId = resultJson.id

	sh "curl --location --request POST 'http://ec2-3-16-33-107.us-east-2.compute.amazonaws.com:9000/api/qualitygates/set_as_default?id=${GateId}' \
--header 'Authorization: Basic YWRtaW46YWRtaW4='"
}
def call()
{
create()
}
