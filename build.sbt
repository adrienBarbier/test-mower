val scala3Version = "3.1.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "lawn-mower",
    version := "0.1.0",

    scalaVersion := scala3Version,
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % "test",
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.10"
  )
