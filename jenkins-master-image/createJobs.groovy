pipelineJob('Gauntlt test webgoat') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url 'https://github.com/yschu710/devsecops-jenkins-scanner.git'
                    }
                    branch 'main'
                    scriptPath('jenkins-master-image/Jenkinsfile/gauntlt-webgoat')
                }
            }
        }
    }
}
pipelineJob('AWS CodeBuild webgoat') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url 'https://github.com/yschu710/devsecops-jenkins-scanner.git'
                    }
                    branch 'main'
                    scriptPath('jenkins-master-image/Jenkinsfile/build-webgoat')
                }
            }
        }
    }
}
pipelineJob('pipelineJob') {
    definition {
        cps {
            script(readFileFromWorkspace('jenkins-master-image/Jenkinsfile/pipelinejob'))
            sandbox()
        }
    }
}