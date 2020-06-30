import groovy.json.*
import groovy.json.JsonSlurper 

def call(JSON){
	def jsonString = JSON
	def jsonObja = readJSON text: jsonString
	def IP=jsonObja.GIT.GitUrl
  	print(IP)
	def user=jsonObja.GIT.GitUserName
	def pass=jsonObja.GIT.GitPassword
  	def repoName=jsonObja.GIT.GitRepoName
 sh 'curl -u $user:$pass -H "ContentType: application/json; charset=UTF-8"  ${IP}/users/${user}/repos -o gitrepos.json'
 //sh "curl -X GET -u $user:$pass ${IP}/repos/${user}/${repoName}/commits -o commits.json"
}
