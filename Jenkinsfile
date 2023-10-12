pipeline {
    agent any

    tools {
        maven "mvn 3.9.5"
    }

    stages {
        stage('Build') {
            steps {
                sh "mvn clean -D suiteXmlFile=smoke test"
            }
            post {
                            // If Maven was able to run the tests, even if some of the test
                            // failed, record the test results and archive the jar file.
                            success { allure([
                                includeProperties: false,
                                jdk: '',
                                properties: [],
                                reportBuildPolicy: 'ALWAYS',
                                results: [[path: 'target/allure-results']]
                            ])
                        }
        }
    }
}
}