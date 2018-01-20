name := "riemann-logback-appender"


organization := "com.rla"

version := "0.1-SNAPSHOT"

description := "Riemann Logack Appender"
resolvers += "Clojars" at "http://clojars.org/repo"

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "io.riemann" % "riemann-java-client" % "0.4.5",
  "org.scalatest" %% "scalatest" % "3.0.4" % Test
)
