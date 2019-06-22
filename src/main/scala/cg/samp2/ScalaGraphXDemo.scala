package cg.samp2

import breeze.linalg.Matrix
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.graphx._

import org.apache.spark.sql.SparkSession;
object ScalaGraphXDemo{
  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().master("local[*]").appName("test").getOrCreate();
    val airports = spark.read.option("header", true).csv("d:/inputData/airports.csv");
    airports.printSchema();
    val namesofAirports = airports
      .selectExpr("float(id) as airport_id", "name")
      .distinct()
    namesofAirports.show(10);
  }
}
