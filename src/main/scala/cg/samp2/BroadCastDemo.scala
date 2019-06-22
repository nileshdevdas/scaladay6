package cg.samp2

import org.apache.spark.{SparkConf, SparkContext}

object BroadCastDemo {

  def main(args: Array[String]): Unit = {
    val a = Array(1 to 10000);
    val sc = SparkContext.getOrCreate(new SparkConf().setMaster("local[*]").setAppName("sparkaccum"))
    val rdd = sc.parallelize(a)
    val sb = sc.broadcast(rdd.collect());
    sb.value.foreach(data=>println(data));
  }
}
