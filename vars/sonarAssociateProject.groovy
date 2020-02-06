  
import groovy.json.*

@NonCPS
create(){
def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/QualityGateDetails.json"),"UTF-8"))
def reader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/ProjectDetails.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
def resultJson2 = jsonSlurper.parse(reader2)
def GateId = resultJson.id
def ProjectId = resultJson2.component.id
	sh "curl --location --request POST 'http://3.16.33.107:9000/api/qualitygates/select?gateId=${GateId}&projectId=${ProjectId}' \
--header 'Authorization: Basic YWRtaW46YWRtaW4='"
}
def call()
{
create()
}
