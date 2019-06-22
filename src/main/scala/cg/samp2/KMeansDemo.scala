package cg.samp2

import org.apache.spark.ml.clustering.KMeans

object KMeansDemo {

  def main(args: Array[String]): Unit = {
    val kmeans = new KMeans();
    println(kmeans.explainParams)
  }
}
