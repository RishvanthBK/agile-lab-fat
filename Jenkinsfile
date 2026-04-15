pipeline { 
    agent any 

    environment { 
        DOCKER_IMAGE = "rishvanthbkr0709/payroll-system:latest" 
    } 

    stages { 

        stage('Clone Repository') { 
            steps { 
                git branch: 'main', 
                url: 'https://github.com/RishvanthBK/agile-lab-fat.git' 
            } 
        } 

        stage('Build & Run Tests') { 
            steps { 
                bat 'mvn clean test' 
            } 
            post { 
                always { 
                    junit 'target/surefire-reports/*.xml' 
                } 
            } 
        } 

        stage('Package Application') { 
            steps { 
                bat 'mvn package -DskipTests' 
            } 
        } 

        stage('Build Docker Image') { 
            steps { 
                bat "docker build -t %DOCKER_IMAGE% ." 
            } 
        } 

        stage('Push to DockerHub') { 
            steps { 
                retry(3) {   // retry 3 times
                    withCredentials([usernamePassword( 
                        credentialsId: 'dockerhub-creds', 
                        usernameVariable: 'DOCKER_USER', 
                        passwordVariable: 'DOCKER_PASS' 
                    )]) { 
                        bat """ 
                        docker logout
                        docker login -u %DOCKER_USER% -p %DOCKER_PASS%
                        docker push %DOCKER_IMAGE%
                        """ 
                    }
                }
            } 
        }

        stage('Deploy to Kubernetes') { 
            steps { 
                bat 'kubectl apply -f deployment.yaml' 
            } 
        } 
    } 
}