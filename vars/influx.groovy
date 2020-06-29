import groovy.json.*

@NonCPS
create(String t0,int t1){
      sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=SonarDB" --data-binary 'SONARMETRIC,Metric=${t0} Value=${t1}'"""
}
def call(){
def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/metrics.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
  print (resultJson)
  def size=resultJson.Sonar.Metrics.component.measures.size
  print(size)
  for(int i=0;i<size;i++){
    print(i)
    String t0=resultJson.Sonar.Metrics.component.measures[i].metric
	  String metric=t0.replaceAll("\\[", "").replaceAll("\\]","");
    int t1=Integer.parseInt(resultJson.Sonar.Metrics.component.measures[i].value)
	  //int value = Integer.parseInt(t1);
    	  print (t0)
          print (t1)
 	  create(metric,t1)
  }

}
/*import groovy.json.*

@NonCPS
create(String t0,int t1){
  sh "curl -i -XPOST http://18.222.223.64:8086/write?db=SonarDB --data-binary 'SONARMETRIC,Metric=${t0} Value=${t1}'"
}
/*create(){
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
  sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'SONARDATA,Metric=duplicated_lines type=intrgral server=sonar Value=${t0} 1593159883918987231'"""
  sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'SONARDATA,Metric=complexity type=intrgral server=sonar Value=${t1} 1593159883918987232'"""
  sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'SONARDATA,Metric=violations type=intrgral server=sonar Value=${t2} 1593159883918987233'"""
  sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'SONARDATA,Metric=sqale_index type=intrgral server=sonar Value=${t3} 1593159883918987234'"""
}*/


/*def call()
{
  def jsonSlurper = new JsonSlurper()
def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/metrics.json"),"UTF-8"))
def resultJson = jsonSlurper.parse(reader)
  print (resultJson)
  def size=resultJson.Sonar.Metrics.component.measures.size
  print(size)
  for(int i=0;i<size;i++){
    print(i)
    def t0=resultJson.Sonar.Metrics.component.measures[i].metric
    def t1=resultJson.Sonar.Metrics.component.measures[i].value
    print (t0)
    print (t1)
    create(t0,t1)
    //sh "curl -i -XPOST http://18.222.223.64:8086/write?db=SonarDB --data-binary 'SONARMETRIC,Metric=${t0} Value=${t1}'"
    
    print(i)
  }
}*/
