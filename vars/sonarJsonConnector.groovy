def call(jsondata){
def jsonString = jsondata
println(jsonString)
def jsonObj = readJSON text: jsonString
println(jsonObj.code_quality)
String a=jsonObj.code_quality.projects.project.project_name

String jobname=a.replaceAll("\\[", "").replaceAll("\\]","");
String b=jsonObj.ci.jobs.job.dsl_fileName
String dslfilename=b.replaceAll("\\[", "").replaceAll("\\]","");

String c=jsonObj.ci.jobs.job.job_type
String jobtype=c.replaceAll("\\[", "").replaceAll("\\]","");
