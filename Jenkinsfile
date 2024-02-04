pipeline {

 agent any

   stages{
    stage('Build Jar'){
        steps{
           // echo "doing mvn clean"
            sh "mvn -version" 
	    sh 'mvn -B -DskipTests clean package'
            }
    }
    stage('Build Image') {
        steps{
            echo "building docker image"

			 sh "docker build -t=nagdacker/selenium ."
         }
    }
        stage('Push  Image') {
            steps{
                echo "Push docker image"

    			 sh "docker push nagdacker/selenium"
             }
        }
   }

}
