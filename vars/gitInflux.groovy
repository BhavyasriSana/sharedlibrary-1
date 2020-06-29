import groovy.json.*


@NonCPS
create(){
def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/gitrepos.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
  //print (resultJson)
def repocount = resultJson.size()
  sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'Git,Metric=GitRepoCount Value=${repocount}'"""
}


def call()
{
	create()
}
