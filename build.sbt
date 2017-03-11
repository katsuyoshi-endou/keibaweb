name := """keibaweb"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  evolutions,
  javaJdbc,
  cache,
  javaWs,
  "org.postgresql" % "postgresql" % "9.4.1212",
  "com.typesafe.play" %% "play-mailer" % "5.0.0",
  "org.freemarker" % "freemarker" % "2.3.23",
  "org.apache.commons" % "commons-email" % "1.4",
  "javax.mail" % "mail" % "1.4.7",
	"org.jfree" % "jfreechart" % "1.0.19"
)
ivyConfiguration ~= { originalIvyConfiguration =>

  val config = originalIvyConfiguration.asInstanceOf[InlineIvyConfiguration]

  val ivyHome = file("./.ivy2")

  val ivyPaths = new IvyPaths(config.paths.baseDirectory, Some(ivyHome))

  new InlineIvyConfiguration(ivyPaths, config.resolvers, config.otherResolvers,

    config.moduleConfigurations, config.localOnly, config.lock,

    config.checksums, config.resolutionCacheDir, config.log)

}
EclipseKeys.projectFlavor := EclipseProjectFlavor.Java           // Java project. Don't expect Scala IDE
EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.ManagedClasses, EclipseCreateSrc.ManagedResources)  // Use .class files instead of generated .scala files for views and routes
EclipseKeys.preTasks := Seq(compile in Compile)
