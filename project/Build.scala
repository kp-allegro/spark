import sbt.Keys._
import sbt._
import sbtassembly.AssemblyPlugin.autoImport._

object Build extends Build {

  private lazy val librarySettings = Seq(
    name := "scala-spark-template",
    scalaVersion := "2.11.8",
    organization := "pl.allegro.analytics.braincode",

    libraryDependencies ++= Dependencies.dependencies,

    resolvers += "CONJARS" at "http://conjars.org/repo/",
    resolvers += "CDH5" at "https://repository.cloudera.com/artifactory/cloudera-repos/",

    ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) },
    scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature"),

    fork in Test := true,
    parallelExecution in Test := false,

    assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false),
    assemblyMergeStrategy in assembly := {
      case PathList("META-INF", xs @ _*) =>
        (xs map {_.toLowerCase}) match {
          case ("manifest.mf" :: Nil) | ("index.list" :: Nil) | ("dependencies" :: Nil) => MergeStrategy.discard
          case _ => MergeStrategy.discard
        }
      case _ => MergeStrategy.first
    }

  )

  lazy val `spark-job-template-scala-sbt` = (project in file("."))
    .settings(librarySettings)

}






