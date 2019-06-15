package cg.samp2
import org.apache.spark.sql.SparkSession

object SparkXMLDemo {

  def main(args: Array[String]): Unit = {
    import org.apache.spark.sql.SparkSession
    val sparkSession =
        SparkSession.builder.
          appName("xmldemo").
          master("local[*]").
          getOrCreate();
    val df = sparkSession.read.
              format("com.databricks.spark.xml").
              option("rowTag", "book").
              load("d:/inputData/books.xml");
    df.show();
    df.printSchema();
    println(df.count());

  }
}
