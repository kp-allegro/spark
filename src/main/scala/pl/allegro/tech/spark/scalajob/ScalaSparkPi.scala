package pl.allegro.tech.spark.scalajob

import org.apache.spark.sql.SparkSession

import scala.math._

object ScalaSparkPi {

  def main(args: Array[String]) {

    val spark = SparkSession.builder().getOrCreate()

    val slices = 2
    val n = math.min(100000L * slices, Int.MaxValue).toInt


    val count = spark.sparkContext.parallelize(1 until n, slices).map { i =>
        val x = random * 2 - 1
        val y = random * 2 - 1
        if (x*x + y*y < 1) 1 else 0
      }.reduce(_ + _)

    spark.stop()
  }
}
