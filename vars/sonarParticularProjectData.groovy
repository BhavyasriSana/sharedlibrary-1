  
def call(jsondata){
def jsonString = jsondata
//println(jsonString)
def jsonObj = readJSON text: jsonString
//println(jsonObj.code_quality)

String a = jsonObj.code_quality.projects.project.project_key
String ProjectKey=a.replaceAll("\\[", "").replaceAll("\\]","");


	sh "curl --location --request GET 'http://3.16.33.107:9000/api/measures/component?metricKeys=ncloc,complexity,violations&component=${ProjectKey}' \
--header 'Authorization: Basic YWRtaW46YWRtaW4='"
}
