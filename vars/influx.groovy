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
  //sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'SONARDATA,Metric=duplicated_lines Value=${t0}'"""
  sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'SONARDATA,Metric=complexity Value=${t1}'"""
  //sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'SONARDATA,Metric=violations Value=${t2}'"""
  //sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'SONARDATA,Metric=sqale_index Value=${t3}'"""
}


def call()
{
create()
}
