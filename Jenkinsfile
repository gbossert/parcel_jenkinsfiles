#!groovy

pipeline {

    agent none

    environment {
	ENV_VAR1 = 'hello'
	ENV_VAR2 = 'world'
    }

    

    stages {
	stage('Build Service1') {
	    when {
		expression {
		    return params.targets == 'all' || params.targets.contains('build')
		}
	    }
	    
	    parallel {
		stage('Build Service1/API') {
		    agent {
			label 'python'
		    }
		    when {
			expression {
			    return params.microservices == 'all' || params.microservices.contains('service1api') \
			    || load('./has_changed.groovy')(['services/service1/api/', 'libs/lib1'])
			}
		    }
		    steps {
			sh "echdo 'building service1/api'"
		    }
		    post {
			failure {
			    def response = httpRequest httpMode: 'POST', requestBody: "text=ALERT: Service1-API failed to build !", url: 'https://8b8b0cf4.ngrok.io/api/v1/tts'
			    println("Status: "+response.status)
			}
		    }
		}
		stage('Build Service1/Worker') {
		    agent {
			label 'python'
		    }		    
		    when {
			expression {
			    return params.microservices == 'all' || params.microservices.contains('service1worker')
			}
		    }
		    steps {
			sh "echo 'building service1/worker'"
		    }
		}
		stage('Build Service1/Front') {
		    agent {
			label 'nodejs'
		    }
		    when {
			expression {
			    return params.microservices == 'all' || params.microservices.contains('service1front')
			}
		    }
		    steps {
			sh "echo 'building service1/front'"
		    }
		}
	    }	    
	}

	stage('Test Service1') {
	    when {
		expression {
		    return params.targets == 'all' || params.targets.contains('test')
		}
	    }
	    
	    parallel {
		stage('Test Service1/API') {
		    agent {
			label 'python'
		    }
		    when {
			expression {
			    return params.microservices == 'all' || params.microservices.contains('service1api')
			}
		    }
		    steps {
			sh "echo 'testing service1/api'"
		    }
		}
		stage('Test Service1/Worker') {
		    agent {
			label 'python'
		    }
		    when {
			expression {
			    return params.microservices == 'all' || params.microservices.contains('service1worker')
			}
		    }
		    steps {
			sh "echo 'testing service1/worker'"
		    }
		}
		stage('Test Service1/Front') {
		    agent {
			label 'nodejs'
		    }
		    when {
			expression {
			    return params.microservices == 'all' || params.microservices.contains('service1front')
			}
		    }
		    steps {
			sh "echo 'testing service1/front'"
		    }
		}
	    }	    
	}

	stage('Push Service1') {
	    when {
		expression {
		    return params.targets == 'all' || params.targets.contains('push')
		}
	    }
	    
	    parallel {
		stage('Push Service1/API') {
		    agent {
			label 'python'
		    }		    
		    when {
			expression {
			    return params.microservices == 'all' || params.microservices.contains('service1api')
			}
		    }
		    steps {
			sh "echo 'pushing service1/api'"
		    }
		}
		stage('Push Service1/Worker') {
		    agent {
			label 'python'
		    }		    
		    when {
			expression {
			    return params.microservices == 'all' || params.microservices.contains('service1worker')
			}
		    }
		    steps {
			sh "echo 'pushing service1/worker'"
		    }
		}
		stage('Push Service1/Front') {
		    agent {
			label 'nodejs'
		    }		    
		    when {
			expression {
			    return params.microservices == 'all' || params.microservices.contains('service1front')
			}
		    }
		    steps {
			sh "echo 'pushing service1/front'"
		    }
		}
	    }	    
	}

	
	stage('Build Service2') {
	    when {
		expression {
		    return params.targets == 'all' || params.targets.contains('build')
		}
	    }
	    
	    parallel {
		stage('Build Service2/API') {
		    agent {
			label 'python'
		    }
		    when {
			expression {
			    return params.microservices == 'all' || params.microservices.contains('service2api')
			}
		    }
		    steps {
			sh "echo 'building service2/api'"
		    }
		}
		stage('Build Service2/Worker') {
		    agent {
			label 'python'
		    }		    
		    when {
			expression {
			    return params.microservices == 'all' || params.microservices.contains('service2worker')
			}
		    }
		    steps {
			sh "echo 'building service2/worker'"
		    }
		}
		stage('Build Service2/Front') {
		    agent {
			label 'nodejs'
		    }
		    when {
			expression {
			    return params.microservices == 'all' || params.microservices.contains('service2front')
			}
		    }
		    steps {
			sh "echo 'building service2/front'"
		    }
		}
	    }	    
	}

	stage('Test Service2') {
	    when {
		expression {
		    return params.targets == 'all' || params.targets.contains('test')
		}
	    }
	    
	    parallel {
		stage('Test Service2/API') {
		    agent {
			label 'python'
		    }
		    when {
			expression {
			    return params.microservices == 'all' || params.microservices.contains('service2api')
			}
		    }
		    steps {
			sh "echo 'testing service2/api'"
		    }
		}
		stage('Test Service2/Worker') {
		    agent {
			label 'python'
		    }
		    when {
			expression {
			    return params.microservices == 'all' || params.microservices.contains('service2worker')
			}
		    }
		    steps {
			sh "echo 'testing service2/worker'"
		    }
		}
		stage('Test Service2/Front') {
		    when {
			expression {
			    return params.microservices == 'all' || params.microservices.contains('service2front')
			}
		    }
		    steps {
			sh "echo 'testing service2/front'"
		    }
		}
	    }	    
	}

	stage('Push Service2') {
	    when {
		expression {
		    return params.targets == 'all' || params.targets.contains('push')
		}
	    }
	    
	    parallel {
		stage('Push Service2/API') {
		    agent {
			label 'python'
		    }		    
		    when {
			expression {
			    return params.microservices == 'all' || params.microservices.contains('service2api')
			}
		    }
		    steps {
			sh "echo 'pushing service2/api'"
		    }
		}
		stage('Push Service2/Worker') {
		    agent {
			label 'python'
		    }		    
		    when {
			expression {
			    return params.microservices == 'all' || params.microservices.contains('service2worker')
			}
		    }
		    steps {
			sh "echo 'pushing service2/worker'"
		    }
		}
		stage('Push Service2/Front') {
		    agent {
			label 'nodejs'
		    }		    
		    when {
			expression {
			    return params.microservices == 'all' || params.microservices.contains('service2front')
			}
		    }
		    steps {
			sh "echo 'pushing service2/front'"
		    }
		}
	    }	    
	}

	
	
    }

}
