package cg.samp2

import org.apache.spark.{SparkConf, SparkContext}

object FlatMapDemo {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("test");
    val sc = SparkContext.getOrCreate(conf);
    val names = Array("nilesh", "nilesh", "nilesh", "mahesh", "ramesh", "satish");
    val nsrdd = sc.parallelize(names);
    val flattened = nsrdd.flatMap(line => line.split(","));
    println(flattened.count)
    val reduced = flattened.map(word => (word, 1)).reduceByKey(_+_);
    reduced.foreach(line => println(line))
  }
}
