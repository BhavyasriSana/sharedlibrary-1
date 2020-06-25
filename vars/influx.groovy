import groovy.json.*

@NonCPS
create(){
def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/metrics.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
  print (resultJson)
  def total=resultJson.Sonar.Metrics.component.measures[1].value
  //def total = 10
  echo "$total"
//sh """curl -k --connect-timeout 30 -XPOST "http://18.222.223.64:8086/write?db=mydb&precision=s" --data-binary '${total}'"""
  sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'sonar complexity=${total}'"""
}


def call()
{
create()
}
