package com.lightbend.play.application

import com.lightbend.play.PlayMultiVersionApplicationIntegrationTest
import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.TaskOutcome

abstract class PlayIdePluginIntegrationTest extends PlayMultiVersionApplicationIntegrationTest {

    abstract String getIdePlugin()
    abstract String getIdeTask()
    abstract List<File> getIdeFiles()
    abstract String[] getBuildTasks()

    def "generates IDE configuration"() {
        applyIdePlugin()
        when:
        BuildResult result = build(ideTask)
        then:
        buildTasks.each {
            assert result.task(it).outcome == TaskOutcome.SUCCESS
        }
        ideFiles.each {
            assert it.exists()
        }
    }

    def "does not blow up when no IDE plugin is applied"() {
        expect:
        build("tasks")
    }

    protected void applyIdePlugin() {
        buildFile << """
    allprojects {
        apply plugin: "${idePlugin}"
    }
"""
    }
}