package cg.samp2
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
object RDDDemo1 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("Reducer")
    val sc = SparkContext.getOrCreate(conf)
    val data=sc.parallelize(Seq(("maths",52),("english",75),("science",82), ("computer",65),("maths",85)))
    val sorted = data.sortByKey(ascending = true)
    sorted.foreach(println)
  }
}
