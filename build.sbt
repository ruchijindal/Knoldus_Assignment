
name := "Knoldus_POS"

version := "0.1.0"

organization := "com.astar"
 
scalaVersion := "2.9.1"
 
seq(webSettings: _*)

resolvers += "Java.net Maven2 Repo" at "http://download.java.net/maven/2/"

resolvers += "Sonatype OSS Snapshot Repository" at "https://oss.sonatype.org/content/repositories/snapshots/"
 

  
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "1.6.1" % "test",
  "junit" % "junit" % "4.5" % "test->default",
  "com.h2database" % "h2" % "1.2.138",
  "ch.qos.logback" % "logback-classic" % "0.9.26" % "compile->default",
  "org.eclipse.jetty"         %  "jetty-webapp"       % "8.0.4.v20111024"     % "container"
)