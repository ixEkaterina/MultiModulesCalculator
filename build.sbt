name := "MultiModulesCalculator"

version := "0.1"

scalaVersion := "2.12.15"

lazy val root = (project in file(".")).aggregate(core, data, app)

lazy val core = (project in file("core"))
  .dependsOn(data)
  .settings(libraryDependencies += Dependencies.test)

lazy val data = project in file("data")

lazy val app = (project in file("app"))
  .dependsOn(data, core)
  .settings(
    libraryDependencies += Dependencies.test,
    mainClass := Some("ru.example.app.Main")
  )
