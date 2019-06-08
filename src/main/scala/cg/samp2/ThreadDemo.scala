package cg.samp2

object ThreadDemo extends App{
  for(i <- 1 to 10) {
    val thread = new Thread {
      override def run: Unit = {
        for(j <- 1 to 1000){
          Thread.sleep(100);
          println(Thread.currentThread.getName + "---" + j)
        }
      }
    }
    thread.start;
  }
}
