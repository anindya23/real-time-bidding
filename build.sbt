name := "real-time-bidding"

version := "1.0"

scalaVersion := "2.12.6"

libraryDependencies ++= {
	val AkkaVersion = "2.5.19"
  	val AkkaHttpVersion = "10.1.6"
  	val Json4sVersion = "3.6.6"
	Seq(
		"com.typesafe.akka"	%% "akka-actor" % AkkaVersion,
		"com.typesafe.akka"	%% "akka-stream" % AkkaVersion,
		"com.typesafe.akka"	%% "akka-http" % AkkaHttpVersion,
		"com.typesafe.akka"	%% "akka-http-spray-json" % AkkaHttpVersion,
		"com.typesafe.akka"	%% "akka-http-testkit" % AkkaHttpVersion % "test",
		"com.typesafe.akka"	%% "akka-testkit" % AkkaVersion % Test,
  	  	"com.typesafe.akka"	%% "akka-slf4j" % AkkaVersion,
  	  	"org.json4s" %% "json4s-native"	% Json4sVersion,
    	"org.json4s" %% "json4s-ext" % Json4sVersion,
		"de.heikoseeberger"	%% "akka-http-json4s" % "1.25.2",
	  	"com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
  		"org.scalatest"	%% "scalatest" % "3.0.1" % Test,
	  	"ch.qos.logback" % "logback-classic" % "1.2.3"
	)
}