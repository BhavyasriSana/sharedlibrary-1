def call(jsondata){
def jsonString = jsondata
//println(jsonString)
def jsonObj = readJSON text: jsonString
//println(jsonObj.code_quality)

String a = jsonObj.code_quality.projects.project.project_key
String ProjectKey=a.replaceAll("\\[", "").replaceAll("\\]","");
	
	"http://ec2-3-16-33-107.us-east-2.compute.amazonaws.com:9000/api/projects/delete?key=${delkey}"
	sh "curl --location --request POST 'http://ec2-3-16-33-107.us-east-2.compute.amazonaws.com:9000/api/projects/delete?key=${ProjectKey}' \
--header 'Authorization: Basic YWRtaW46YWRtaW4='"
