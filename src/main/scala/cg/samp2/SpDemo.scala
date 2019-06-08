package cg.samp2

import org.apache.spark.{SparkConf, SparkContext}

object SpDemo extends App {
  val conf = new SparkConf().setMaster("local").setAppName("Airports");
  val sc = new SparkContext(conf);
  val file = sc.textFile("d:/inputData/airports.csv");
  val header = file.first();
  val data = file.filter(line => line != header)
  println(data.first);
  data.map(rec => rec.split(",")).map(rec => {
    if(rec(0).toInt > 1 )
      rec(0);
  } ).saveAsTextFile("d:/inputData/save");
}
