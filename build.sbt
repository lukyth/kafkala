name := "Kafkala"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.1.3"
  , "com.sclasen" %% "akka-kafka" % "0.1.0" % "compile"
  , "com.typesafe.akka" %% "akka-slf4j" % "2.3.9" % "compile"
  , "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"
  , "org.apache.kafka" %% "kafka" % "0.8.2.2"
  , "org.scalatest" %% "scalatest" % "2.2.5" % "test"
)
