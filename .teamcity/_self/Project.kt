package _self

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.Project

object FamilyEngagementProject : Project ({

    buildType(_self.buildTypes.BuildAndTestPullRequest)
    buildType(_self.buildTypes.RestoreNugetAndRunUnit)

    template(_self.templates.CompileAndRunUnitTestsTemplate)
})