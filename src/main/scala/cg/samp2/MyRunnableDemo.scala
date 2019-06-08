package cg.samp2

object MyRunnableDemo extends  App{
  // thread creation and start code
  val t = new Thread(new MyRunnable);
  t.start();
}
