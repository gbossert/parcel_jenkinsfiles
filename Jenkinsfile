#!groovy

pipeline {

    agent any

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
		    when {
			expression {
			    return params.microservices == 'all' || params.microservices.contains('service1api')
			}
		    }
		    steps {
			sh "echo 'building service1/api'"
		    }
		}
		stage('Build Service1/Worker') {
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

	
	
	// stage('Service2') {
	//     when {
	// 	expression {
	// 	    return params.microservices == 'all' || params.microservices.containes('service2')
	// 	}
	//     }
	//     stage('Build') {
	// 	steps {
	// 	    sh "echo 'building service2'"
	// 	}
	//     }
	//     stage('Test') {
	// 	when {
	// 	    expression {
	// 		return params.mode == 'normal' || params.mode == 'deploy'
	// 	    }
	// 	}
	// 	steps {
	// 	    sh "echo 'testing service2'"
	// 	}
	//     }
	//     stage('Push') {
	// 	when {
	// 	    expression {
	// 		return params.mode == 'deploy'
	// 	    }
	// 	}
	// 	steps {
	// 	    sh "echo 'pushing service2'"
	// 	}
	//     }	    
	// }

	
	
    }

}
