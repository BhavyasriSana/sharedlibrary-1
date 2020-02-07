

def call(message)
{
  
//def jsonString = jsondata
//def jsonObj = readJSON text: jsonString
//println(jsonObj.code_quality)

//String a=jsonObj.code_quality.projects.project.project_name
//String projectName=a.replaceAll("\\[", "").replaceAll("\\]","");
  
  Date date = new Date() 
  sh " echo '${date}' SONARQUBE ${message} >>log.txt"
}
