#!groovy

pipeline {

    agent any

    environment {
	ENV_VAR1 = 'hello'
	ENV_VAR2 = 'world'
    }

    stages {

	stage('Service1') {
	    when {
		expression {
		    return params.microservices == 'all' || params.microservices.containes('service1')
		}
	    }
	    stage('Build') {
		steps {
		    sh "echo 'building service1'"
		}
	    }
	    stage('Test') {
		when {
		    expression {
			return params.mode == 'normal' || params.mode == 'deploy'
		    }
		}
		steps {
		    sh "echo 'testing service1'"
		}
	    }
	    stage('Push') {
		when {
		    expression {
			return params.mode == 'deploy'
		    }
		}
		steps {
		    sh "echo 'pushing service1'"
		}
	    }	    
	}

	stage('Service2') {
	    when {
		expression {
		    return params.microservices == 'all' || params.microservices.containes('service2')
		}
	    }
	    stage('Build') {
		steps {
		    sh "echo 'building service2'"
		}
	    }
	    stage('Test') {
		when {
		    expression {
			return params.mode == 'normal' || params.mode == 'deploy'
		    }
		}
		steps {
		    sh "echo 'testing service2'"
		}
	    }
	    stage('Push') {
		when {
		    expression {
			return params.mode == 'deploy'
		    }
		}
		steps {
		    sh "echo 'pushing service2'"
		}
	    }	    
	}

	
	
    }

}
