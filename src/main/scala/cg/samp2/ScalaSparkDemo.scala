package cg.samp2

import org.apache.spark.{SparkConf, SparkContext}

object ScalaSparkDemo {
  def main(args: Array[String]): Unit = {
    println(System.getProperties)
    val sparkConfig = new SparkConf().setAppName("remote").setMaster("spark://192.168.64.130:7077");
    val sc = new SparkContext(sparkConfig);
    val data = sc.textFile("hdfs://sparkmaster:9000/airports.csv");
    data.filter(f => f.contains("small_airport")).saveAsTextFile("hdfs://sparkmaster:9000/smallresult");
    data.filter(f => f.contains("medium_airport")).saveAsTextFile("hdfs://sparkmaster:9000/smallresult");
  }
}
