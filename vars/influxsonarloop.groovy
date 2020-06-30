import groovy.json.*
import groovy.json.JsonSlurper 

@NonCPS
create(){
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
	  	def t3=resultJson.Sonar.Metrics.component.measures[i].value
		float value=Float.parseFloat(t3);
		print (metric)
          	print (value)
		db(metric,t3)
		//sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'SONARDATAnew,Metric=${metric} Value=${value}'"""
	}
}
	@NonCPS
	db(String metric,float value){
		var="$(curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'SONARDATAnew,Metric=${metric} Value=${value}')"
			def response = sh(script: 'curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'SONARDATAnew,Metric=${metric} Value=${value}'', returnStdout: true)
		
	}

def call()
{
	create()
}
