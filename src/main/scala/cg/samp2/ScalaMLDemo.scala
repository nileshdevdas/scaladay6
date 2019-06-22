package cg.samp2
import org.apache.spark.ml.clustering.KMeansModel
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.mllib.stat.{MultivariateStatisticalSummary, Statistics}

object ScalaMLDemo {
  def main(args: Array[String]): Unit = {
val sc = SparkContext.getOrCreate(new SparkConf().setMaster("local[*]").setAppName("test"));
    // excel
    val observations = sc.parallelize(
      Seq(
        Vectors.dense(1.0, 10.0, 100.0),
        Vectors.dense(2.0, 20.0, 200.0),
        Vectors.dense(3.0, 30.0, 300.0)
      )
    )

  /// use statistics model
  val summary: MultivariateStatisticalSummary = Statistics.colStats(observations);
    println(summary.mean)
    println(summary.variance)
    println(summary.numNonzeros)

  }
}
