package _self.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

object BuildAndTestPullRequest : BuildType({
    templates(_self.templates.CompileAndRunUnitTestsTemplate)
    name = "Compile and test pull request"

    triggers {
        vcs {
            id = "TRIGGER_5"
            branchFilter = "+:refs/pull/*/head"
        }
    }
})