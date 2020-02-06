/*import groovy.json.JsonSlurper 
@NonCPS

def call(message)
{
 println(message)
 def request = libraryResource 'sonarConnectorData.json'
 def jsonSlurper = new JsonSlurper() 
 def resultJson = jsonSlurper.parseText(request)
 def rpkey = resultJson.pkey
   sh " echo '${rpkey}' ${message} >>log.txt"
}*/

def call(message,jsondata)
{
  
def jsonString = jsondata
def jsonObj = readJSON text: jsonString
println(jsonObj.code_quality)

String a=jsonObj.code_quality.projects.project.project_name
String projectName=a.replaceAll("\\[", "").replaceAll("\\]","");
  
 println(message)
  Date date = new Date() 
  sh " echo '${date}' SONAR '${projectName}' ${message} >>log.txt"
}
