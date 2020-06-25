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
  sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'SONARQ,Metric=duplicated_lines Value=${t0} field=1 
  SONARQ,Metric=complexity Value=${t1} field=2 
  SONARQ,Metric=violations Value=${t2} field=3 
  SONARQ,Metric=sqale_index Value=${t3} field=4'"""
}


def call()
{
create()
}
