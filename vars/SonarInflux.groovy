import groovy.json.*

@NonCPS
create(String t0,int t1){
	echo t0
	echo t1
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