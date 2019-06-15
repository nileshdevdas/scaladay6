package cg.samp2


package cg.samp2
import org.apache.spark.sql.SparkSession

object JDBCLoader2 {
  def main(args: Array[String]): Unit = {
    // create the sparksession
    val sparkSession = SparkSession.builder.appName("jdbcdemo").
      master("local[*]").getOrCreate();
    val df1 = sparkSession.read.format("jdbc").option("url","jdbc:mysql://localhost:3306/test").
      option("driver","com.mysql.jdbc.Driver").option("user","root").option("spark.sql.crossJoin.enabled", true).option("password","root").
      option("dbtable","test_table").load();

    val df2 = sparkSession.read.format("jdbc").option("url","jdbc:mysql://localhost:3306/test").
      option("driver","com.mysql.jdbc.Driver").option("user","root").option("password","root").
      option("dbtable","dept").option("spark.sql.crossJoin.enabled", true).load();
      df1.select("*").explain(extended = true);
      df1.crossJoin(df2).show();
      df1.join(df2, Seq("id"), "left").show();
  }
}
