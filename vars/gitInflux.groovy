import groovy.json.*


@NonCPS
create(){
def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/gitrepos.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
  //print (resultJson)
def repocount = resultJson.size()
//sh """curl -k --connect-timeout 30 -XPOST "http://18.222.223.64:8086/write?db=mydb&precision=s" --data-binary '${total}'"""
  sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'Git,Metric=GitRepoCount Value=${repocount} 1593159883918987231'"""
 // sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'SONARDATAnew,Metric=complexity type=intrgral server=sonar Value=${t1} 1593159883918987232'"""
  //sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'SONARDATAnew,Metric=violations type=intrgral server=sonar Value=${t2} 1593159883918987233'"""
  //sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'SONARDATAnew,Metric=sqale_index type=intrgral server=sonar Value=${t3} 1593159883918987234'"""
}


def call()
{
	create()
}
