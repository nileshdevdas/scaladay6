package cg.samp2
package cg.samp2

import org.apache.spark.{SparkConf, SparkContext}


object GroupByDemo2 {

  def main(args: Array[String]): Unit = {
    val sparkConfig = new SparkConf().setAppName("groupbydemo").setMaster("local[*]");
    val sc = SparkContext.getOrCreate(config = sparkConfig);
    val airportsRDD = sc.textFile("d:/inputData/airports.csv");
    val groupedAirports = airportsRDD.map(eachLine=>eachLine.replaceAll("\"", "") ).
      map(line => line.split(",")).groupBy(each=> each(8)).sortBy(line=>line._1);
  }
}
