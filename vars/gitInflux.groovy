
def call(JSON){
	def jsonString = JSON
	def jsonObja = readJSON text: jsonString
	def IP=jsonObja.INFLUXDB.InfluxUrl
  	print(IP)
	def database=jsonObja.INFLUXDB.DatabaseName
	def table=jsonObja.INFLUXDB.GitTableName

def resultJson = readJSON file :'gitrepos.json'
  //print (resultJson)
def repocount = resultJson.size()
	print(repocount)

def resultJson2 = readJSON file :'commits.json'	
  //print (resultJson2)
def commitscount = resultJson2.size()
	print(commitscount)
	sh """curl -i -XPOST "${IP}/write?db=${database}" --data-binary '${table},Metric=GitRepoCount Value=${repocount}
	${table},Metric=GitCommitsInRepo Value=${commitscount}'"""	
}
