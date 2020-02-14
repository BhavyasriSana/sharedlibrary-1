def call(){
sh 'curl -X GET http://3.16.33.107:9000/api/measures/component?component=comrades.bmi:BMI&metricKeys=ncloc,complexity,violations'
}
