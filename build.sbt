name := "HelloWorld"
version := "1.0"
scalaVersion := "2.13.6"

// libraryDependencies += groupID % artifactID % revision
libraryDependencies ++= Seq(
    "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2",
    "mysql" % "mysql-connector-java" % "8.0.25"
  )

