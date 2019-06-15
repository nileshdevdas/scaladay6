package cg.samp2

import org.apache.spark.sql.SparkSession

object SparkSQLDemo {

  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.builder()
      .master("local[1]")
      .appName("SQLApp")
      .getOrCreate();
    val data = sparkSession.read.option("header" ,"true").csv("d:/inputData/airports.csv");
    data.printSchema();
    data.show(10);
    data.select("name").show(100);

  }

}
