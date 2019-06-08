package cg.samp2

import org.apache.spark.{SparkConf, SparkContext}

object RDDDemo2 {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("rdd2");
    val sc = SparkContext.getOrCreate(sparkConf);
    val rdd2 = sc.textFile("d:/inputData/airports.csv",4);
    val totalWords = rdd2.flatMap(line => line.split(","))
    println(totalWords);
    println(totalWords.count())
    val counts = totalWords.map(word => (word, 1)).reduceByKey((a,b) => a+b);
    val countsUS= counts.filter(each=>each._1=="\"US\"");
    countsUS.foreach(line=>println(line));
  }
}
