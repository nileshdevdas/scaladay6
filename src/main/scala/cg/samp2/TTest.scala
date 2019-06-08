package cg.samp2

object TTest extends App{

  val t = new Thread {
    override def run(): Unit ={
      for(i <- 1 to 100){
          println(Thread.currentThread() + "---" +  i);
        Thread.sleep(50);
      }
    }
  }
  t.start();


}
