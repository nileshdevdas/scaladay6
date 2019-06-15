
package cg.samp2
import org.apache.spark.sql.SparkSession

object JDBCLoader {
  def main(args: Array[String]): Unit = {
    // create the sparksession
    val sparkSession = SparkSession.builder.appName("jdbcdemo").
        master("local[*]").getOrCreate();
    val query = """(select * from test_table where name = 'nilesh') mytst"""
    val df = sparkSession.read.format("jdbc").option("url","jdbc:mysql://localhost:3306/test").
      option("driver","com.mysql.jdbc.Driver").option("user","root").option("password","root").
       option("dbtable",query).load();
    df.show(100);
    val a = df.select("id").where("name='nilesh'")
    a.show(100);
  }
}
