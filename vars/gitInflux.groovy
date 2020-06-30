import groovy.json.*


@NonCPS
create(){
def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/gitrepos.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
  //print (resultJson)
def repocount = resultJson.size()
  //sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'Git,Metric=GitRepoCount Value=${repocount}'"""
	
def jsonSlurper2 = new JsonSlurper()
def reader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/commits.json"),"UTF-8"))
def resultJson2 = jsonSlurper.parse(reader2)
  //print (resultJson2)
def commitscount = resultJson2.size()
	sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'GIT,Metric=GitRepoCount Value=${repocount}
	Git,Metric=GitCommitsCountInRepo Value=${commitscount}'"""
	
}


def call()
{
	create()
}
