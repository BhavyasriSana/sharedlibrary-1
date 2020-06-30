def call(JSON)
{
    def jsonString = JSON
	def jsonObja = readJSON text: jsonString
	def IP=jsonObja.INFLUXDB.InfluxUrl
  	print(IP)
	def database=jsonObja.INFLUXDB.DatabaseName
	def table=jsonObja.INFLUXDB.SonarTableName
    
    def resultJson = readJSON file :'metrics.json'
      print (resultJson)
    def size=resultJson.Sonar.Metrics.component.measures.size()
      for(int i=0;i<size;i++){
        
            print(i)
              String t0=resultJson.Sonar.Metrics.component.measures[i].metric
          String metric=t0.replaceAll("\\[", "").replaceAll("\\]","");
          String t3=resultJson.Sonar.Metrics.component.measures[i].value
        float value=Float.parseFloat(t3);
        print (metric)
              print (value)
          sh"""curl -i -XPOST "${IP}/write?db=${database}" --data-binary '${table},Metric=${metric} Value=${value}'"""
    }
}
 
