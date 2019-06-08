package cg.samp2

import org.apache.spark.{SparkConf, SparkContext}


object GroupByDemo1 {
  def main(args: Array[String]): Unit = {

    val sparkConfig = new SparkConf().setAppName("groupbydemo").setMaster("local[*]");
    val sparkContext = SparkContext.getOrCreate(config = sparkConfig);
    val airportsRDD = sparkContext.textFile("d:/inputData/airports.csv");
    val plainData =
      airportsRDD.map(eachRecord =>eachRecord.replaceAll("\"", ""));
    val mappedData = plainData.map(line => line.split(","))
    val groupedData = mappedData.groupBy(each => each(8));
    groupedData.foreach(group => println(group));
  }
}
