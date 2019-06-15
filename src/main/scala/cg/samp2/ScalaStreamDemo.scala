package cg.samp2

import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

object ScalaStreamDemo {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().
      setAppName("StreamApplication").
      setMaster("local[*]")
    val sc = new SparkContext(conf)
    val ssc = new StreamingContext(sc, Seconds(5));
    val hadoopConf=sc.hadoopConfiguration;
    hadoopConf.set("fs.s3.impl", "org.apache.hadoop.fs.s3native.NativeS3FileSystem")
    hadoopConf.set("fs.s3.awsAccessKeyId","AKIAJVF3N55SV6CZHPDA")
    hadoopConf.set("fs.s3.awsSecretAccessKey","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")
    ssc.textFileStream("s3://bucketmine/")

    ssc.start();
    ssc.awaitTermination();
    //lines.print(100);


  }
}
