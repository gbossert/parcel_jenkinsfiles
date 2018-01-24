#!groovy
pipeline {
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
			    return params.microservices == 'all' || params.microservices.contains('service1api')
			}
		    }
		    steps {
			script {
			    sh 'building service1-api'
			    // service1_pipeline = load './service1-pipeline.groovy'
			    // service1_pipeline.build()

			    
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
    }
}
// // def build() {
// //     println("Building service1")
// // }

// // return this

// sh 'echo "plop plop"'
