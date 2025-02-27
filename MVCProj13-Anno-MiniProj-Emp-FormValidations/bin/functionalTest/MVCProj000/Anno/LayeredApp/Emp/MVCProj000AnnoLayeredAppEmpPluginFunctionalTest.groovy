/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package MVCProj000.Anno.LayeredApp.Emp

import spock.lang.Specification
import org.gradle.testkit.runner.GradleRunner

/**
 * A simple functional test for the 'MVCProj000.Anno.LayeredApp.Emp.greeting' plugin.
 */
public class MVCProj000AnnoLayeredAppEmpPluginFunctionalTest extends Specification {
    def "can run task"() {
        given:
        def projectDir = new File("build/functionalTest")
        projectDir.mkdirs()
        new File(projectDir, "settings.gradle") << ""
        new File(projectDir, "build.gradle") << """
            plugins {
                id('MVCProj000.Anno.LayeredApp.Emp.greeting')
            }
        """

        when:
        def runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments("greeting")
        runner.withProjectDir(projectDir)
        def result = runner.build()

        then:
        result.output.contains("Hello from plugin 'MVCProj000.Anno.LayeredApp.Emp.greeting'")
    }
}
