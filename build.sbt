ThisBuild / scalaVersion := "2.13.14"

lazy val root = (project in file("."))
  .enablePlugins(SbtAutoBuildPlugin, GatlingPlugin)
  .settings(
    name := "digital-tariffs-ruling-performance-tests",
    version := "2.0.0",
    //implicitConversions & postfixOps are Gatling recommended -language settings
    scalacOptions += "-feature",
    libraryDependencies ++= Dependencies(),
    // Enabling sbt-auto-build plugin provides DefaultBuildSettings with default `testOptions` from `sbt-settings` plugin.
    // These testOptions are not compatible with `sbt Gatling/test`. So we have to override testOptions here.
    Test / testOptions := Seq.empty
  )

addCommandAlias("scalafmtAll", "all scalafmtSbt scalafmt Test/scalafmt")
