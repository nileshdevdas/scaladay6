package cg.samp2

import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.ml.feature.{OneHotEncoderModel, StringIndexer, VectorAssembler}
import org.apache.spark.sql.{SQLContext, SparkSession}

object PipelineDemo {

  def main(args: Array[String]): Unit = {
    import org.apache.spark.sql.SparkSession
    val sparkSession = SparkSession.builder.appName("dfdemo").master("local[*]").getOrCreate
    val sqlContext = new SQLContext(sparkSession.sparkContext);

    val input = sqlContext.createDataFrame(Seq(
      ("a@email.com", 12000,"M"),
      ("b@email.com", 43000,"M"),
      ("c@email.com", 5000,"F"),
      ("d@email.com", 60000,"M")
    )).toDF("email", "income","gender")

    import org.apache.spark.ml.feature.{OneHotEncoder, StringIndexer}
    import org.apache.spark.ml.feature.VectorAssembler
    import org.apache.spark.ml.clustering.KMeans
    import org.apache.spark.ml.Pipeline

    val indexer = new StringIndexer().setInputCol("gender").setOutputCol("genderIndex")
    val encoder = new OneHotEncoder().setInputCol("genderIndex").setOutputCol("genderVec")
    val assembler = new VectorAssembler().setInputCols(Array("income","genderVec")).setOutputCol("features")
    val kmeans = new KMeans().setK(2).setFeaturesCol("features").setPredictionCol("prediction")

    val pipeline = new Pipeline().setStages(Array(indexer, encoder, assembler, kmeans))
    val kMeansPredictionModel = pipeline.fit(input)
    val predictionResult = kMeansPredictionModel.transform(input)
    predictionResult.show();
    Thread.sleep(100000);
  }
}
