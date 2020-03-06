import groovy.json.*

@NonCPS
create(){
  def jsonBuilder = new groovy.json.JsonBuilder()
  def jsonSlurper = new JsonSlurper()
  def reader = new BufferedReader(new InputStreamReader(new FileInputStream("/var/lib/jenkins/workspace/${JOB_NAME}/metrics.json"),"UTF-8"))
  def jsonObj = jsonSlurper.parse(reader)
  List<String> LIST = new ArrayList<String>();
  //def jsonObj = readJSON text: metrics
  int score=10;
  for(i=0;i<jsonObj.component.measures.size();i++){
    def metric=jsonObj.component.measures[i].metric
    print(metric)
    def d=jsonObj.component.measures[i].value
    double data = Double.parseDouble(d); 
    print(data)
    
    if(metric.equals("sqale_index")){
      if(data<10){
        score+=10;
        LIST.add(["metric":metric,"score":score])
        print(List)
      }
    }
    if(metric.equals("vulnerabilities")){
      if(data<10){
        score+=10;
        LIST.add(["metric":metric,"score":score])
        print(List)
      }
    }
    if(metric.equals("coverage")){
      if(data>20){
        score+=10;
        LIST.add(["metric":metric,"score":score])
        print(List)
      }
    }
    if(metric.equals("duplicated_lines")){
      if(data<100){
        score+=10;
        LIST.add(["metric":metric,"score":score])
        print(List)
      }
    }
    if(metric.equals("complexity")){
      if(data<10){
        score+=10;
        LIST.add(["metric":metric,"score":score])
        print(List)
      }
    }
    if(metric.equals("violations")){
      if(data<10){
        score+=10;
        LIST.add(["metric":metric,"score":score])
        print(List)
      }
    }
    if(metric.equals("bugs")){
      if(data<10){
        score+=10;
        LIST.add(["metric":metric,"score":score])
        print(List)
      }
    }
    if(metric.equals("tests")){
      if(data<10){
        score+=10;
        LIST.add(["metric":metric,"score":score])
        print(List)
      }
    }
  }
  for(j=0;j<LIST.size();j++){
    print(LIST[j])
  }
  jsonBuilder.SONAR(
    "SonarMetrics" : LIST
    
    )
  File file = new File("/var/lib/jenkins/workspace/${JOB_NAME}/SONAR.json")
  file.write(jsonBuilder.toPrettyString())
}


def call(){
create()
}
}
