package cg.samp2

import org.apache.spark.sql.{Row, SparkSession}
// here i have added the spark sql function
import org.apache.spark.sql.functions._

object SparkJoinDemo {

  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder.appName("dfdemo").master("local[*]").getOrCreate
    val sales = sparkSession.read.option("header", true).csv("d:/inputData/sales.csv");
    val customer = sparkSession.read.option("header", true).csv("d:/inputData/customers.csv");
    sales.show();
    customer.show();

    val joindata = sales.join(customer, sales("cid") === customer("cid"))
    joindata.show();
    joindata.printSchema();
    joindata.show(10);
    // this the rdd way
    println(joindata.select("amount").rdd.map(row => row(0).toString.toFloat).reduce(_+_));

    // this the sql way
    joindata.select(sum("amount")).show();
    joindata.select(mean("amount")).show();
    joindata.select(max("amount")).show();
  }
}
