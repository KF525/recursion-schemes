name := "recursion-schemes"

version := "0.1"

scalaVersion := "2.12.6"

scalacOptions += "-Ypartial-unification"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "1.4.0",
  "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  "org.hamcrest" % "hamcrest-all" % "1.3" % Test
)