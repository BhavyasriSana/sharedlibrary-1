@NonCPS
db(String metric,float value){
    def var=sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'SONARDATAnew,Metric=${metric} Value=${value}'"""
        
}

 


    

 

def call()
{
    
    def resultJson = readJSON file :'metrics.json'
      print (resultJson)
      def size=resultJson.Sonar.Metrics.component.measures.size
      print(size)
      for(int i=0;i<size;i++){
        
            print(i)
              String t0=resultJson.Sonar.Metrics.component.measures[i].metric
          String metric=t0.replaceAll("\\[", "").replaceAll("\\]","");
          String t3=resultJson.Sonar.Metrics.component.measures[i].value
        float value=Float.parseFloat(t3);
        print (metric)
              print (value)
        db(metric,value)
        //sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'SONARDATAnew,Metric=${metric} Value=${value}'"""
    }
}
 
