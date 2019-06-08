package cg.samp2

import org.apache.spark.{SparkConf, SparkContext}

object ScalaRDDDemo extends App{
  val conf = new SparkConf().setMaster("local[*]").setAppName("myapp");
  val sc = SparkContext.getOrCreate(conf);
  val acTransList = Array(
    "SB10001,1000",
    "SB10002,1200",
    "SB10003,8000",
    "SB10004,400",
    "SB10005,300",
    "SB10006,10000",
    "SB10007,500",
    "SB10008,56",
    "SB10009,30",
    "SB10010,7000",
    "CR10001,7000",
    "SB10002,-10")
  val acTransRDD = sc.parallelize(acTransList)
  val goodTransRecords = acTransRDD.filter(_.split(",")(1).toDouble > 0).filter(_.split(",")(0).startsWith("SB"));
  val highValueTransRecords = goodTransRecords.filter(_.split(",")(1).toDouble > 1000)
  val badAmountLambda = (trans: String) => trans.split(",")(1).toDouble <= 0
  val badAcNoLambda = (trans: String) => trans.split(",")(0).startsWith("SB") == false
  val badAmountRecords = acTransRDD.filter(badAmountLambda)
  val badAccountRecords = acTransRDD.filter(badAcNoLambda)
  val badTransRecords = badAmountRecords.union(badAccountRecords)
  println(badTransRecords.count)
  badTransRecords.foreach(line => {
    println(Thread.currentThread().getName + " - " + line);
  });

}
