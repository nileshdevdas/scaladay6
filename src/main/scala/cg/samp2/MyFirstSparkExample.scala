package cg.samp2

import org.apache.spark.{SparkConf, SparkContext}


object MyFirstSparkExample {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().
      setMaster("local[*]").
      setAppName("MyFirstApp");
    val sc = SparkContext.getOrCreate(conf);
    val mydata = Array(
      "nilesh",
      "john",
      "ramesh",
      "ramesh",
      "paresh",
      "nilesh",
      "satish");
    val myrdd = sc.parallelize(mydata);
    val result = myrdd.map(word => (word,1)).reduceByKey((accum,v) =>accum+v);
    result.foreach(line=>println(line));
    result.cache();
  }
}
