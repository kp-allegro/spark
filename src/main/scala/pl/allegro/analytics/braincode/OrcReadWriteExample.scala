package pl.allegro.analytics.braincode

import org.apache.spark.sql.SparkSession



object OrcReadWriteExample {

  def main(args: Array[String]) {

    val path = args(0)

    val spark = SparkSession.builder().getOrCreate()
    val sampleData = spark.range(10000)
    sampleData.write.orc(path)
    print("Sample records saved: " + spark.read.orc(path).count)

    spark.stop()
  }
}
