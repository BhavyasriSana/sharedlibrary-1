import groovy.json.*


@NonCPS
create(){
def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/gitrepos.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
  //print (resultJson)
def repocount = resultJson.size()
	
def jsonSlurper2 = new JsonSlurper()
def reader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/commits.json"),"UTF-8"))
def resultJson2 = jsonSlurper2.parse(reader2)
  //print (resultJson2)
def commitscount = resultJson2.size()
	/*sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'GIT,Metric=GitRepoCount Value=${repocount} 1593515953791341888
	Git,Metric=GitCommitsCountInRepo Value=${commitscount} 1593515953791341888'"""*/
	
	def out=sh script:'curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'GIT,mytag=3 myfield=89 1463689152000000000
	GIT,mytag=2 myfield=34 1463689156000000000',returnStdout:true

	
}


def call()
{
	create()
}
