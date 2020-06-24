import groovy.json.*

@NonCPS
create(){
def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/metrics.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
//def total = resultJson.component.measures[1].value
  def total = 10
  echo "$total"
sh """curl -i -XPOST 'http://18.222.223.64/write?db=mydb' --data-binary 'complexity =${total}' 
"""
}


def call()
{
create()
}
