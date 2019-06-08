package cg.samp2

import org.apache.spark.sql.SparkSession

object SparkSessionDemo {

  def main(args: Array[String]): Unit = {
    val session =
        SparkSession.builder()
            .master("local[1]")
              .appName("MyApp")
                .getOrCreate();
    val data = session.read.option("header", true).csv("d:/inputData/airports.csv");
    println(data);
    data.show(10);
    data.printSchema();
    println(data.count())
  }
}
