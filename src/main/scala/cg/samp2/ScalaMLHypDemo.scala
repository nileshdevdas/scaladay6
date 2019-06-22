package cg.samp2

import breeze.linalg.Matrix
import org.apache.spark.graphx.{Edge, Graph}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.{MultivariateStatisticalSummary, Statistics}
import org.apache.spark.{SparkConf, SparkContext}

object ScalaMLHypDemo{
  def main(args: Array[String]): Unit = {
    val sc = SparkContext.getOrCreate(new SparkConf().setMaster("local[*]").setAppName("test"));
    val events = Vectors.dense(49.2,87.1,29.2,2.3,528.8,517.5,365.1,481.1,332.6,388.5,558.2,33.6,3373.2,136.3,560.3,1696.3,980.3);
    println(Statistics.chiSqTest(events));


    val vertices=Array((1L, ("SFO")),(2L, ("ORD")),(3L,("DFW")))
    val vRDD= sc.parallelize(vertices)
    vRDD.take(1)
    val nowhere = "nowhere"

    val edges = Array(Edge(1L,2L,1800),Edge(2L,3L,800),Edge(3L,1L,1400))
    val eRDD= sc.parallelize(edges)

    eRDD.take(2)
    // Array(Edge(1,2,1800), Edge(2,3,800))

    // define the graph
    val graph = Graph(vRDD,eRDD, nowhere)
    // graph vertices
    graph.vertices.collect.foreach(println)
    // (2,ORD)
    // (1,SFO)
    // (3,DFW)

    // graph edges
    graph.edges.collect.foreach(println)

    // Edge(1,2,1800)
    // Edge(2,3,800)
    // Edge(3,1,1400)

    val numairports = graph.numVertices
    println(numairports);

    graph.edges.filter { case Edge(src, dst, prop) => prop > 1000 }.collect.foreach(println)
    // Edge(1,2,1800)
    // Edge(3,1,1400)
  }
}
