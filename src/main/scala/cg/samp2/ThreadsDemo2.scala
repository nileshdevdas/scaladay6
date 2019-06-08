package cg.samp2

import scala.io.Source

object ThreadsDemo2 extends App{
   val threadBusiness1 = new Thread {
      override def run(): Unit ={
        val lines = Source.fromFile("d:/inputData/airports.csv").getLines();
        lines.foreach(line => {
           println(line);
            Thread.sleep(50)
        })
      }
   }

  val threadBusiness2 = new Thread {
     override def run(): Unit ={
        for(i <- 1 to 1000){
          Thread.sleep(100);
           println("Processed  --> " +  i );
        }
     }
  }

  threadBusiness2.start();
  threadBusiness1.start();
  println("Threads Kicked offffffffff..............");
}
