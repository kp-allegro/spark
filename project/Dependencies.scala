import sbt._

object Dependencies {

  lazy val dependencies = Seq(
    "org.apache.spark" %% "spark-core" % Versions.sparkVersion % Provided,
    "org.apache.spark" %% "spark-sql" % Versions.sparkVersion % Provided,
    "org.apache.spark" %% "spark-hive" % Versions.sparkVersion % Provided,
    "org.scalatest" %% "scalatest" % "2.2.6" % Test
  )
}

object Versions {
  val sparkVersion = "2.3.0"
}

