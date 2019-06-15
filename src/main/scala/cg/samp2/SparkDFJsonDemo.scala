package cg.samp2

import org.apache.spark.sql.SparkSession

object SparkDFJsonDemo{

  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder().
        appName("jsondemo").master("local[*]").getOrCreate();
    val df =  sparkSession.read.option("inferScheme", true)
        .json("d:/inputData/citylots.json");
    df.printSchema();
  }
}
