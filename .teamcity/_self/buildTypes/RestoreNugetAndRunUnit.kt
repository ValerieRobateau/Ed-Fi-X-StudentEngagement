package _self.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

object RestoreNugetAndRunUnit : BuildType({
    templates(_self.templates.CompileAndRunUnitTestsTemplate)
    name = "Compile and Run Unit Tests"

    triggers {
        vcs {
            id = "TRIGGER_4"
            branchFilter = "+:<default>"
        }
    }
})