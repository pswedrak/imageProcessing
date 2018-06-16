name := "foobar"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.10.2"

seq(scageSettings: _*)

libraryDependencies ++= Seq(
    "com.sksamuel.scrimage" %% "scrimage-core" % "2.1.0",
    "com.sksamuel.scrimage" %% "scrimage-io-extra" % "2.1.0",
    "com.sksamuel.scrimage" %% "scrimage-filters" % "2.1.0"
)
