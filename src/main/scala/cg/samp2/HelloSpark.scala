package cg.samp2

import org.apache.spark.{SparkConf, SparkContext}

object HelloSpark {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("HelloSpark");
    val sc = SparkContext.getOrCreate(conf);
    val myrdd = sc.textFile("d:/inputData/airports.csv");
    println(myrdd);
  }
}
