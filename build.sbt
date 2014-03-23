name := "play-sandbox"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "com.google.inject" % "guice" % "3.0",
  "javax.inject" % "javax.inject" % "1"
)     

play.Project.playJavaSettings
