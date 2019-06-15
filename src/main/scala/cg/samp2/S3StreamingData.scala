package cg.samp2

import org.apache.spark.streaming.Seconds
import org.apache.spark.{SparkConf, SparkContext}

object S3StreamingData {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("Simple Application").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val hadoopConf=sc.hadoopConfiguration;
    hadoopConf.set("fs.s3.impl", "org.apache.hadoop.fs.s3native.NativeS3FileSystem")
    hadoopConf.set("fs.s3.awsAccessKeyId","AKIAJVF3N55SV6CZHPDA")
    hadoopConf.set("fs.s3.awsSecretAccessKey","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")
    val ssc = new org.apache.spark.streaming.StreamingContext(
      sc,Seconds(10));
    val lines = ssc.textFileStream("s3://ioteventsbucket/")
    lines.print(100);
    lines.print()
    ssc.start()             // Start the computation
    ssc.awaitTermination()
  }
}
