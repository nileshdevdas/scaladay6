package cg.samp2

import org.apache.spark.ml.Pipeline
import org.apache.spark.storage.StorageLevel

object  AccumulatorDemo {

  def main(args: Array[String]): Unit = {
    import org.apache.spark.SparkConf
    import org.apache.spark.SparkContext
    val sc = SparkContext.getOrCreate(new SparkConf().setMaster("spark://ec2-54-183-220-207.us-west-1.compute.amazonaws.com:7077").setAppName("sparkaccum"))
    sc.getConf.getAll.foreach(line => {
      println(line)
    });
    val data = sc.textFile("d:/inputData/airports.csv");
  //storage level configures where you wish to persist
    //data.persist(StorageLevel.DISK_ONLY);
    data.cache();
    val bl = sc.longAccumulator("CURRENT_RECORD_POSITION");
    data.foreach(line=>{
      bl.add(1);
    });
    val notUs = data.filter(line=> {
      !line.contains("US")});

    Thread.sleep(1000000);
  }
}
