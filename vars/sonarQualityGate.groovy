def call(jsondata){
def jsonString = jsondata
//println(jsonString)
def jsonObj = readJSON text: jsonString
//println(jsonObj.code_quality)

String a = jsonObj.code_quality.projects.project.quality_gate.gate_name
String QualityGateName=a.replaceAll("\\[", "").replaceAll("\\]","");

	sh "curl --location --request POST 'http://3.16.33.107:9000/api/qualitygates/create?name=${QualityGateName}' \
--header 'Authorization: Basic YWRtaW46YWRtaW4=' -o QualityGateDetails.json"
}
