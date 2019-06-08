package cg.samp2

class MyRunnable  extends Runnable{

   def run: Unit = {
      for(i <- 1 to 1000) {
         Thread.sleep(100);
         println("My Business logic.....")
      }
   }
}
