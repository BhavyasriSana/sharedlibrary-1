import groovy.json.*

@NonCPS
create(){
def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/metrics.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
  print (resultJson)
  def t0=resultJson.Sonar.Metrics.component.measures[0].value
  def t1=resultJson.Sonar.Metrics.component.measures[1].value
  def t2=resultJson.Sonar.Metrics.component.measures[2].value
  def t3=resultJson.Sonar.Metrics.component.measures[3].value
  //def total = 10
//sh """curl -k --connect-timeout 30 -XPOST "http://18.222.223.64:8086/write?db=mydb&precision=s" --data-binary '${total}'"""
  sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'SONAR,duplicated_lines=${t0} complexity=${t1} violations=${t2} sqale_index=${t3}'"""
}


def call()
{
create()
}
