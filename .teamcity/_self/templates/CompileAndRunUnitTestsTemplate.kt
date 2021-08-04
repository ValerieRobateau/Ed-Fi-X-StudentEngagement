package _self.templates

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.powerShell
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.swabra


object CompileAndRunUnitTestsTemplate : Template({
    name = "Compile and Run Unit Tests Template"

    params {
        param("StudentEngagement", "MSDF.StudentEngagement.Web.sln")
    }

    vcs {
        root(RelativeId("EdFiXStudentEngagement"))
    }

    steps {
        powerShell {
            name = "Restore nuget packages"
            id = "RUNNER_8"
            formatStderrAsError = true
            workingDir = "StudentEngagement"
            scriptMode = script {
                content = "%StudentEngagement%"
            }
        }
        powerShell {
            name = "Compile"
            id = "RUNNER_9"
            formatStderrAsError = true
            workingDir = "StudentEngagement"
            scriptMode = script {
                content = "%StudentEngagement%"
            }
        }
        powerShell {
            name = "Run Unit Tests"
            id = "RUNNER_10"
            formatStderrAsError = true
            workingDir = "StudentEngagement"
            scriptMode = script {
                content = "%StudentEngagement%"
            }
        }
    }

    features {
        swabra {
            id = "swabra"
        }
    }
})
