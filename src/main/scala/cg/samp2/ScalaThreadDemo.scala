package cg.samp2

object ScalaThreadDemo extends App{
   val thread = new Thread {
      override def run: Unit ={
          println(Thread.currentThread().getName);
      }
   }
    thread.start;

}
