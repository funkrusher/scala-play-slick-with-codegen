name := """achamoth-backend"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)

resolvers += Resolver.sonatypeRepo("snapshots")

scalaVersion := "2.13.8"

libraryDependencies ++= Seq(
  guice,
  "com.typesafe.play" %% "play-slick" % "4.0.2",
  "com.typesafe.play" %% "play-slick-evolutions" % "4.0.2",
  "com.typesafe.slick" %% "slick-codegen" % "3.3.3",
  "org.mariadb.jdbc" % "mariadb-java-client" % "2.4.3",
  "com.softwaremill.common" %% "id-generator" % "1.3.1"
)
// see: https://github.com/softwaremill/scala-id-generator
