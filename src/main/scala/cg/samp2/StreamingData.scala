package cg.samp2

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.{Seconds, StreamingContext}

object StreamingData {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("test").setMaster("local[*]");
    val streamingContext = new StreamingContext(conf,Seconds(1));
    val lines = streamingContext.socketTextStream("localhost", 9000, StorageLevel.MEMORY_AND_DISK_SER);
    lines.print();
    streamingContext.start();
    streamingContext.awaitTermination();
  }
}
