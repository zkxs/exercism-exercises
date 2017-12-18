lazy val commonSettings = Seq(
  scalaVersion := "2.12.4"
)

lazy val macros = (project in file("macro"))
    .settings(commonSettings)

lazy val core = (project in file("core"))
    .settings(commonSettings)
    .dependsOn(macros)

lazy val root = (project in file("."))
    .aggregate(macros, core)
