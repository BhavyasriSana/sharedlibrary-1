import groovy.json.*

@NonCPS
create(String metric,String operator,String warning,String error){
echo metric
def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/sonar/QualityGateDetails.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
def GateId = resultJson.id

	sh "curl --location --request POST 'http://3.16.33.107:9000/api/qualitygates/create_condition?gateId=${GateId}&metric=${metric}&op=${operator}&warning=${warning}&error=${error}' \
--header 'Authorization: Basic YWRtaW46YWRtaW4='"
}
def call(jsondata){
def jsonString = jsondata

def jsonObj = readJSON text: jsonString

String a = jsonObj.code_quality.projects.project[0].quality_gate[0].metrics[0].metric
String metric=a.replaceAll("\\[", "").replaceAll("\\]","");
	
String b = jsonObj.code_quality.projects.project[0].quality_gate[0].metrics[0].operator
String operator=b.replaceAll("\\[", "").replaceAll("\\]","");

String c = jsonObj.code_quality.projects.project[0].quality_gate[0].metrics[0].warning
String warning=c.replaceAll("\\[", "").replaceAll("\\]","");
	
String d = jsonObj.code_quality.projects.project[0].quality_gate[0].metrics[0].error
String error=d.replaceAll("\\[", "").replaceAll("\\]","");
	
create(metric,operator,warning,error)

}
