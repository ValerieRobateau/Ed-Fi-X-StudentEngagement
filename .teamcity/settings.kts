import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.swabra
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.powerShell
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2021.1"

project {

    buildType(BuildAndTestPullRequest)
    buildType(RestoreNugetAndRunUnit)

    template(CompileAndRunUnitTestsTemplate)
}

object BuildAndTestPullRequest : BuildType({
    templates(CompileAndRunUnitTestsTemplate)
    name = "Build and test pull request"

    triggers {
        vcs {
            id = "TRIGGER_5"
            branchFilter = "+:refs/pull/*/head"
        }
    }
})

object RestoreNugetAndRunUnit : BuildType({
    templates(CompileAndRunUnitTestsTemplate)
    name = "Compile and Run Unit Tests"

    triggers {
        vcs {
            id = "TRIGGER_4"
            branchFilter = "+:<default>"
        }
    }
})

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
