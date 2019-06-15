package cg.samp2

import org.apache.spark.sql.SparkSession

object SparkSessionDemo {
  def main(args: Array[String]): Unit = {
    val session = SparkSession.builder().master("local[1]").
      appName("MyApp").getOrCreate();
    val data = session.read.option("header", true).csv("d:/inputData/airports.csv");
    data.show(10);
    data.printSchema();
    val select_iso = data.select("iso_country");
    select_iso.foreach(f=> println(f));
    val only_India_airports = data.select("name")
        .where("iso_country='IN'");
    only_India_airports.show(100);
    import org.apache.spark.sql.functions.monotonically_increasing_id
    data.withColumn("sr_no", monotonically_increasing_id).show(100);
  }
}
