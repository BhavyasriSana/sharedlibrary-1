
@NonCPS
create(){
def resultJson = readJSON file :'gitrepos.json'
  //print (resultJson)
def repocount = resultJson.size()

def resultJson2 = readJSON file :'commits.json'	
  //print (resultJson2)
def commitscount = resultJson2.size()
	sh """curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'GIT,Metric=GitRepoCount Value=${repocount} 1593515953791341888
	GIT,Metric=GitCommitsCountInRepo Value=${commitscount} 1593515953791341888'"""
	
	/*def out=script: ('curl -i -XPOST "http://18.222.223.64:8086/write?db=mydb" --data-binary 'GIT1,mytag=3 myfield=89 1463689157000000000',returnStdout: true)	 
	print("value"+out)*/

	
}



def call()
{
	create()
}
