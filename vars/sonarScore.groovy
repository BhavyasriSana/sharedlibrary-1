import groovy.json.*

@NonCPS
create(){
def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/QualityGateDetails.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
def GateId = resultJson.id

}
def call(){
create()
}
