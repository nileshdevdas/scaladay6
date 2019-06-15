package cg.samp2

import org.apache.spark.sql.SparkSession

object SparkDFDemo {

  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder().appName("dfdemo").master("local[*]").getOrCreate();
    val df = sparkSession.read.option("header", true).option("inferScheme", true).option("delimiter", ",").csv("d:/inputData/airports.csv");
//    df.printSchema();
    val cg = df.groupBy("iso_country")
    val a = df.select("iso_country").where("iso_country='IN'")
    a.show();
  }
}
