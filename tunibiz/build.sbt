name := """Tunibiz"""
organization := "scala"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.14"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test
libraryDependencies += "org.postgresql" % "postgresql" % "42.2.20"



// Adds additional packages into Twirl
//TwirlKeys.templateImports += "scala.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "scala.binders._"
