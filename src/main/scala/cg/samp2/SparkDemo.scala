package cg.samp2

import org.apache.spark.{SparkConf, SparkContext}

object SparkDemo extends App{
  // spark configuration /////
  val conf =
      new SparkConf().
          setAppName("AirportsData").
                setMaster("local");
  val sc = new SparkContext(conf);
  val myairports =
      sc.textFile("d:/inputData/airports.csv");
  myairports.filter(line =>
          line.contains("small_airport"))
              .saveAsTextFile("d:/inputData/results/");

}
