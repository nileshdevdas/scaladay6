package cg.samp2

import org.apache.spark.{SparkConf, SparkContext}

object RddAppDemo {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("RDDDemo");
    val sc = SparkContext.getOrCreate(conf);

//    val conf1 = new SparkConf().setMaster("spark://sparkmaster:7077").setAppName("RDDDemo");
//    val sc1 = SparkContext.getOrCreate(conf1);
  }
}
