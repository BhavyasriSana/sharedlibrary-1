def call(jsondata){
def jsonString = jsondata
println(jsonString)
def jsonObj = readJSON text: jsonString
println(jsonObj.code_quality)

String a = jsonObj.code_quality.projects.project.project_key
String ProjectKey=a.replaceAll("\\[", "").replaceAll("\\]","");
	
String b = jsonObj.code_quality.projects.project.project_name
String ProjectName=b.replaceAll("\\[", "").replaceAll("\\]","");
//def credentials = resultJson.cname
	sh "curl --location --request POST 'http://ec2-3-16-33-107.us-east-2.compute.amazonaws.com:9000/api/projects/create?key=${ProjectKey}&name=${ProjectName}' \
--header 'Authorization: Basic YWRtaW46YWRtaW4='"
}
