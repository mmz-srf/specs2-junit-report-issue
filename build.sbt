
name := "specs2-junit-report-issue"

version := "1.0"

scalaVersion := "2.12.1"

testOptions in ThisBuild ++= Seq(Tests.Argument("junitxml"), Tests.Argument("console"))

//This option destroys the test case names in the xml report
//testOptions in Test ++= Seq(Tests.Argument(TestFrameworks.Specs2, "exclude", "io"))

val specs2Version = "3.9.1"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % specs2Version,
  "org.specs2" %% "specs2-junit" % specs2Version
)

lazy val root = (project in file("."))
  .disablePlugins(plugins.JUnitXmlReportPlugin) //we don't use the SBT JUnitXmlReport Plugin for the reports
